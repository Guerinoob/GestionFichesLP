package com.gestionficheslp.repositories;

import javax.transaction.Transactional;

import com.gestionficheslp.entities.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}