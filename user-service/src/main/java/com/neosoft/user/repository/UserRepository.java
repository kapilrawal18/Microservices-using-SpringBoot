package com.neosoft.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.user.entity.User;

@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//	User findByUserId(Long userId);
//
//}

public interface UserRepository extends MongoRepository<User, Long> {

	User findByUserId(Long userId);

}