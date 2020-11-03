package com.example.demo;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//класс для работы с CSV
class CSVReaderTest {

    public static void ReaderToCsv(String args) throws Exception {

        Path myPath = Paths.get(args);

        //записываем данные из CSV файла в экз. класса  Orders
        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_16LE)) {

            ColumnPositionMappingStrategy<Orders> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Orders.class);
            String[] fields = {"id", "amount", "currecy", "comment"};
            strategy.setColumnMapping(fields);

            CsvToBean<Orders> csvToBean = new CsvToBeanBuilder<Orders>(br)
                    .withSkipLines(1)
                    .withSeparator(';')
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Orders> list = csvToBean.parse();

            for (Object object : list) {

                Orders order = (Orders) object;
                order.setLine(list.indexOf(object)+1);
                System.out.println(order);

            }
        }
    }
}

