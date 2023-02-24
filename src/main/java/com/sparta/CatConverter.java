package com.sparta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatConverter {
    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();
    public String objectToJson(Object o) throws JsonProcessingException {
       return jsonMapper.writeValueAsString(o);
    }

    public void objectToJsonFile(String path, Object o) throws IOException {
        jsonMapper.writeValue(new File(path),o);
    }

    public String objectToXml(Object o) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(o);
    }

    public void objectToXmlFile(String path, Object o) throws IOException {
        xmlMapper.writeValue(new File(path), o);
    }

    public List<String> objectsToJson(List<Object> objects) throws JsonProcessingException {
        List<String> jsonStrings = new ArrayList<>();
        for (Object o: objects) {
            jsonStrings.add(objectToJson(o));
        }
        return jsonStrings;
    }

    public List<String> objectsToXml(List<Object> objects) throws JsonProcessingException {
        List<String> xmlStrings = new ArrayList<>();
        for (Object o: objects) {
            xmlStrings.add(objectToXml(o));
        }
        return xmlStrings;
    }

    public Cat jsonToObject(String s) throws JsonProcessingException {
        return jsonMapper.readValue(s, Cat.class);
    }

    public Cat xmlToObject(String s) throws JsonProcessingException {
        return xmlMapper.readValue(s, Cat.class);

    }

    public Cat jsonFileToObject(String path) throws IOException {

        return jsonMapper.readValue(new File(path), Cat.class);
    }

    public Cat xmlFileToObject(String path) throws IOException {
        return xmlMapper.readValue(new File(path), Cat.class);

    }

    public List<Cat> xmlFilesToObject(List<String> files ) throws IOException {
        List<Cat> cats = new ArrayList<>();
        for (String path: files) {
            cats.add(xmlFileToObject(path));
        }
        return cats;
    }

    public List<Cat> jsonFilesToObject(List<String> files ) throws IOException {
        List<Cat> cats = new ArrayList<>();
        for (String path: files) {
            cats.add(jsonFileToObject(path));
        }
        return cats;
    }
}
