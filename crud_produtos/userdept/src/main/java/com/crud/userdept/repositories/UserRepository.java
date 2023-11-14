package com.crud.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
