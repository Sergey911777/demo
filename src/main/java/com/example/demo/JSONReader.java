package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

//класс для работы с JSON
class JSONReaderTest {

    public static void JsonReaderTest(String args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(args));
        //Конвертируем obj в JSONObject
        JSONObject jo = (JSONObject) obj;

        //перебираем все объекты и по ключю выводим их в нужном формате
        JSONArray order = (JSONArray) jo.get("orders");
        order.forEach(entry -> {
            JSONObject project = (JSONObject) entry;
            System.out.println("Заказ{id:" + project.get("id") + ", amount:" + project.get("amount") + ", currency:" + project.get("currency") + ", comment:" + project.get("comment") + ", имя файла:" + (FileWork.getFileName()) + ", строка№:" + order.indexOf(project) + "}");

        });
    }
}
