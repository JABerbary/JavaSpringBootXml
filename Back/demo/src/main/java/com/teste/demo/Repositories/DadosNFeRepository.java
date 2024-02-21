package com.teste.demo.Repositories;
import com.teste.demo.Entities.DadosNFe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DadosNFeRepository extends JpaRepository<DadosNFe, Long> {
    List<DadosNFe> findAllByOrderByCreatedAtAsc();
}