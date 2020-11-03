package com.example.demo;

import java.io.File;

//класс для работы с переданными файлами
public class FileWork {

    public static String getFileName() {
        return fileName;
    }

    private static String fileName;
    private  static  File file;
    private static String fileExtension;

    public FileWork() {
        this.fileName = fileName;
        this.file = file;
        this.fileExtension = fileExtension;
    }

    public static String getFileName(String args){
        fileName=args;
        return fileName;
    }

    public static File getFile(String args){
        file = new File(args);
        return file;
    }

    //метод получения расширения файла
    public static String getFileExtension(String args) {
        String fileName = args;
        // если в имени файла есть точка и она не является первым символом в названии файла,
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            fileExtension = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        // в противном случае возвращаем заглушку, то есть расширение не найдено
        else{
            fileExtension = "";
        }
        return fileExtension;
    }
}
