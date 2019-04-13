package com.gestionficheslp.repositories;

import javax.transaction.Transactional;

import com.gestionficheslp.entities.Etudiant;

public interface EtudiantRepository extends UserBaseRepository<Etudiant> {
	Etudiant findByUsername(String username);
}