package com.sparta;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.time.LocalDate;

//{"name":"Fudge","dob":"2015-03-05","priority":0}

public class Main {
    public static void main(String[] args) {
        Cat fudge = new Cat("Fudge", LocalDate.of(2015, 3, 5), 0);
        System.out.println(fudge);

        Cat pluto = new Cat("Pluto", LocalDate.of(2016, 01, 06), 0);
        System.out.println(pluto);

        Cat marmite = new Cat("Marmite", LocalDate.of(2015, 06, 05), 0);


        Cat[] cats = {fudge, pluto, marmite};

        CatConverter conv = new CatConverter();

        try {
            System.out.println(conv.objectToJson(cats));
            conv.objectToJsonFile("src/main/resources/cats.json", cats);
//            System.out.println(conv.objectToXml(fudge));
//
//            System.out.println(conv.jsonToObject("{\"name\":\"Fudge\",\"dob\":\"2015-03-05\",\"priority\":0}"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}