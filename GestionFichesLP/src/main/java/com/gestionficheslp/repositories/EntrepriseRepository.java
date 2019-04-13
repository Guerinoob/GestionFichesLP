package com.gestionficheslp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionficheslp.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}