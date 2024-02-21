package com.teste.demo.Entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "dadosnfe")
public class DadosNFe {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "idnfse")
    private String idNfse;
    
    @Column(name = "dhemi")
    private Timestamp dhEmi;
    
    @Column(name = "nnf")
    private Integer nNF;
    
    @Column(name = "cuf")
    private Integer cUF;
    
    @Column(name = "cnpj")
    private String CNPJ;
    
    @Column(name = "xfant")
    private String xFant;
    
    @Column(name = "cnpjdest")
    private String CNPJdest;
    
    @Column(name = "xnome")
    private String xNome;
    
    @Column(name = "vtottrib")
    private Double vTotTrib;
    
    @Column(name = "vnf")
    private Double vNF;
    
    @ManyToOne
    @JoinColumn(name = "xmlnfe_id")
    private XMLData xmlData;

}
