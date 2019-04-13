package com.gestionficheslp.repositories;

import javax.transaction.Transactional;

import com.gestionficheslp.entities.Tuteuriut;

@Transactional
public interface TuteuriutRepository extends UserBaseRepository<Tuteuriut> {
	Tuteuriut findByUsername(String username);
}