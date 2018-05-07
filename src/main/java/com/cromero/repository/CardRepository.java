package com.cromero.repository;

import org.springframework.data.repository.CrudRepository;

import com.cromero.model.Card;

public interface CardRepository extends CrudRepository<Card,Long> {

}
