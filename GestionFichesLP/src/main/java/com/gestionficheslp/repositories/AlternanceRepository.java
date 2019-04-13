package com.gestionficheslp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionficheslp.entities.Fiche;

@Repository
public interface AlternanceRepository extends JpaRepository<Fiche, Integer> {

}