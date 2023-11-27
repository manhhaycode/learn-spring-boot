package com.springbootjpalombok.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootjpalombok.model.User;

public interface UserRepository extends CrudRepository<User, String> {
    @Transactional
    @Modifying
    @Query(value = "DELETE u FROM User u WHERE u.id = :id", nativeQuery = true)
    int removeById(String id);
}
