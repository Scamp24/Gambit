package com.gambit.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gambit.server.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
