package com.gestionficheslp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionficheslp.entities.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}