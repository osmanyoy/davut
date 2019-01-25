package com.training.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);

}
