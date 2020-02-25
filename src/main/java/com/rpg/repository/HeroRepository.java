package com.rpg.repository;


import com.rpg.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HeroRepository extends JpaRepository<Hero , Long> {



}
