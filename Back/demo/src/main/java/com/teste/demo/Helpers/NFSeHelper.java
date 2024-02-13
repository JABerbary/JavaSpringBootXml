package com.teste.demo.Helpers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.teste.demo.Entities.DadosNFe;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class NFSeHelper {
    public static DadosNFe extrairDadosNFe(String xmlContent) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlContent)));
        

        Element infNFe = (Element) document.getElementsByTagName("infNFe").item(0);
        Element ide = (Element) infNFe.getElementsByTagName("ide").item(0);
        Element emit = (Element) infNFe.getElementsByTagName("emit").item(0);
        Element dest = (Element) infNFe.getElementsByTagName("dest").item(0);
        Element total = (Element) infNFe.getElementsByTagName("total").item(0);
        Element ICMSTot = (Element) total.getElementsByTagName("ICMSTot").item(0);

        DadosNFe dadosNFe = new DadosNFe();
        dadosNFe.setIdNfse((String)(infNFe.getAttribute("Id")));
        String dhEmiString = ide.getElementsByTagName("dhEmi").item(0).getTextContent();
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dhEmiString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Timestamp timestamp = Timestamp.from(offsetDateTime.toInstant());
        dadosNFe.setDhEmi(timestamp);
        // dadosNFe.setDhEmi(Timestamp.valueOf(ide.getElementsByTagName("dhEmi").item(0).getTextContent()));
        dadosNFe.setNNF(Integer.parseInt(ide.getElementsByTagName("nNF").item(0).getTextContent()));
        dadosNFe.setCUF(Integer.parseInt(ide.getElementsByTagName("cUF").item(0).getTextContent()));
        dadosNFe.setCNPJ(emit.getElementsByTagName("CNPJ").item(0).getTextContent());
        dadosNFe.setXFant(emit.getElementsByTagName("xFant").item(0).getTextContent());
        dadosNFe.setCNPJdest(dest.getElementsByTagName("CNPJ").item(0).getTextContent());
        dadosNFe.setXNome(dest.getElementsByTagName("xNome").item(0).getTextContent());
        dadosNFe.setVTotTrib(Double.parseDouble(ICMSTot.getElementsByTagName("vTotTrib").item(0).getTextContent()));
        dadosNFe.setVNF(Double.parseDouble(ICMSTot.getElementsByTagName("vNF").item(0).getTextContent()));

        return dadosNFe;
    }
}
