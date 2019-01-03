package com.isentric.realtrial.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isentric.realtrial.api.model.Child;


@Repository
public interface ChildRepository extends JpaRepository<Child, Long>
{

}
