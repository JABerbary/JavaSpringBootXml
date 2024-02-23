package com.prjxml.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prjxml.demo.domain.DadosNFe;


@Repository
public interface DadosNFeRepository extends JpaRepository<DadosNFe, Long> {

    @Query(nativeQuery = true, value = "ALTER SEQUENCE dadosnfe_id_seq1 RESTART WITH 1")
    void resetAutoIncrement();

    List<DadosNFe> findAllByOrderByCreatedAtAsc();
}