package com.prjxml.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prjxml.demo.domain.DadosNFe;


@Repository
public interface DadosNFeRepository extends JpaRepository<DadosNFe, Long> {
    List<DadosNFe> findAllByOrderByCreatedAtAsc();
}