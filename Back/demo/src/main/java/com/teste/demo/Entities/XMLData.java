package com.teste.demo.Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Entity
@Data
@Table(name = "xmlnfe")
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement 
public class XMLData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "xmlnfe_seq")
    @SequenceGenerator(name = "xmlnfe_seq", sequenceName = "xmlnfe_seq", allocationSize = 1)
    private Long id;

    @Lob
    private String xmlContent;

    
}