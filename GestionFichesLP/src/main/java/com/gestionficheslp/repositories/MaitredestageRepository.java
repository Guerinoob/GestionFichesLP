package com.gestionficheslp.repositories;

import javax.transaction.Transactional;

import com.gestionficheslp.entities.Maitredestage;

@Transactional
public interface MaitredestageRepository extends UserBaseRepository<Maitredestage> {
	Maitredestage findByUsername(String username);
}