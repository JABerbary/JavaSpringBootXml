package com.prjxml.demo.domain;
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
@SequenceGenerator(name="xmlnfe_id_seq", sequenceName="xmlnfe_id_seq", allocationSize=1)
public class XMLData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="xmlnfe_id_seq")
    private Long id;

    @Lob
    private String xmlContent;

}