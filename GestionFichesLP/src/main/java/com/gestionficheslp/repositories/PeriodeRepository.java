package com.gestionficheslp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionficheslp.entities.Periode;

@Repository
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

}