package com.training.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.spring.MyPerson;

public interface MyPersonDAO extends CrudRepository<MyPerson, Long> {

    List<MyPerson> findByNameAndSurname(String name,
                                        String surname);

    @Query("select p from MyPerson p where p.name = :isim and p.surname = :soy")
    List<MyPerson> myMethod(@Param("isim") String name,
                            @Param("soy") String surname);


    @Query(value = "select * from MyPerson where name = :isim and surname = :soy", nativeQuery = true)
    List<MyPerson> myMethod2(@Param("isim") String name,
                             @Param("soy") String surname);

}
