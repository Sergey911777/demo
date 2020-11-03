package com.example.demo;

import org.json.simple.parser.ParseException;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);
        // disable spring banner
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String[] args) throws Exception {

        System.out.println("Переданные файлы:");

        List<String> listFileName = new ArrayList();
        for (int i = 0; i < args.length; i++) {
            listFileName.add(args[i]);
            System.out.println(listFileName.get(i));
        }

        for (int i = 0; i < listFileName.size(); i++) {
            String fileName = FileWork.getFileName(listFileName.get(i));
            String fileExtension = FileWork.getFileExtension(listFileName.get(i));
            Runnable task = () -> {
                if (fileExtension.equals("json")) {
                    System.out.println("Расширение файла: " + fileExtension);
                    try {
                        JSONReaderTest.JsonReaderTest(fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (fileExtension.equals("csv")) {
                    System.out.println("Расширение файла: " + fileExtension);
                    try {
                        CSVReaderTest.ReaderToCsv(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else
                    System.out.println("Не поддерживаемый формат");
            };

            Thread thread = new Thread(task);

            Thread.currentThread().setName("Поток № " + Integer.toString(i));
            thread.start();
            String threadName = Thread.currentThread().getName();
            System.out.println("Текущий поток " + threadName);
            TimeUnit.SECONDS.sleep(5);
        }

    }

}
