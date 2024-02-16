package com.teste.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "xmlnfe")
public class XMLData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xmlnfe_seq")
    @SequenceGenerator(name = "xmlnfe_seq", sequenceName = "xmlnfe_seq", allocationSize = 1)
    private Long id;

    @Lob
    private byte[] xmlContent;

    
}