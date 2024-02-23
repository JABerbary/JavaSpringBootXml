package com.prjxml.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prjxml.demo.domain.XMLData;

@Repository
public interface XMLDataRepository extends JpaRepository<XMLData, Long> {

     @Query(nativeQuery = true, value = "ALTER SEQUENCE xmlnfe_id_seq RESTART WITH 1")
    void resetAutoIncrement();
}