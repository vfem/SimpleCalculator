package ru.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class XmlValidationService {

    private static final Logger log = LoggerFactory.getLogger(XmlValidationService.class);

    public boolean validate(Path pathInput) {
        try {
            Source xmlFile = new StreamSource(pathInput.toFile());
            SchemaFactory schemaFactory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(getClass().getResource("/SimpleCalculator.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            return true;
        } catch (IOException | SAXException e) {
            log.error("An exception was thrown", e);
            log.error("Input file not valid");
            return false;
        }
    }
}