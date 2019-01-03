package com.isentric.realtrial.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isentric.realtrial.api.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>
{

}
