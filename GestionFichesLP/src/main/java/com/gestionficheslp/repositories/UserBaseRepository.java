package com.gestionficheslp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.gestionficheslp.entities.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Integer> {

}