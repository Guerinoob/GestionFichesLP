package com.gestionficheslp.repositories;

import javax.transaction.Transactional;

import com.gestionficheslp.entities.Tuteuriut;

public interface TuteuriutRepository extends UserBaseRepository<Tuteuriut> {
	Tuteuriut findByUsername(String username);
}