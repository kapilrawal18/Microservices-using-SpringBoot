package com.neosoft.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.neosoft.user.entity.User;
import com.neosoft.user.repository.UserRepository;
import com.neosoft.user.vo.Department;
import com.neosoft.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDeparment(Long userId) {
		log.info("Inside getUserWithDeparment of UserService");
		
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
				, Department.class);
	
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}
	
	public Iterable<User> findAllUsers() {
		log.info("Inside findAllUsers of UserService");
		return userRepository.findAll();
	}
}
