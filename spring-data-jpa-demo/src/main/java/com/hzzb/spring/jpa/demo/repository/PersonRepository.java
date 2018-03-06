package com.hzzb.spring.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hzzb.spring.jpa.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
