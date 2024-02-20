package com.teste.demo.Entities;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "dadosnfe")
public class DadosNFe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dadosnfe_seq")
    @SequenceGenerator(name = "dadosnfe_seq", sequenceName = "dadosnfe_seq", allocationSize = 1)
    private long id;

    private String idNfse;
    private Timestamp dhEmi;
    private Integer nNF;
    private Integer cUF;
    private String CNPJ;
    private String xFant;
    private String CNPJdest;
    private String xNome;
    private Double vTotTrib;
    private Double vNF;

}
