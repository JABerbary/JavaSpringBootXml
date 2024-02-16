package com.teste.demo.Repositories;
import com.teste.demo.Entities.XMLData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XMLDataRepository extends JpaRepository<XMLData, Long> {
}