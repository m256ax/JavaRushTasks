package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

//Добавление файла в архив
//        В метод main приходит список аргументов.
//        Первый аргумент - полный путь к файлу fileName.
//        Второй аргумент - путь к zip-архиву.
//        Добавить файл (fileName) внутрь архива в директорию 'new'.
//        Если в архиве есть файл с таким именем, то заменить его.
//
//        Пример входных данных:
//        C:/result.mp3
//        C:/pathToTest/test.zip
//
//        Файлы внутри test.zip:
//        a.txt
//        b.txt
//
//        После запуска Solution.main архив test.zip должен иметь такое содержимое:
//        new/result.mp3
//        a.txt
//        b.txt
//
//        Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
//        Пользоваться файловой системой нельзя.
//
//
//        Requirements:
//        1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
//        2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
//        3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
//        4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
//        5. Потоки для работы с архивом должны быть закрыты.

public class Solution {
    public static void main(String[] args) throws IOException {
        //создаем Map для хранения имени файла и его содержания
        Map<String, byte[]> mapFiles = new HashMap<>();
        // создаем входиящий поток
        try (FileInputStream inputStream = new FileInputStream(args[1]);
             ZipInputStream zipInput = new ZipInputStream(inputStream))
        {
            // создаем zip - запись, вхождение
            ZipEntry zipEntry = zipInput.getNextEntry();
//            создаем буффер
            byte[] buffer = new byte[2048];
            // пока запись не ровна null
            while (zipEntry != null){
                // создаем байтовый поток
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int lenght=0;
//            читаем в буффер пока не дойдем до 0
            while ((lenght = zipInput.read(buffer)) > 0){
                // пишем из буффура поток содержимое файла
                byteArrayOutputStream.write(buffer, 0, lenght);
            }
            // кладем в Map имя файла и его содержимое
            mapFiles.put(zipEntry.getName(), byteArrayOutputStream.toByteArray());
            zipEntry = zipInput.getNextEntry();
            byteArrayOutputStream.close();
            }
        }


        // создаем исходящие потоки
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))){
            // создаем из строки Path, чтобы потом получить имя файла
            Path fileName = Paths.get(args[0]);
            // помещаем в исходящий поток zip-запись
            zipOutputStream.putNextEntry(new ZipEntry("new/" + fileName.getFileName()));
            Files.copy(fileName, zipOutputStream);
            // записываем все данный из Map в исходящий поток
            for (Map.Entry<String, byte[]> pair: mapFiles.entrySet()) {
                if (!pair.getKey().equals("new/" + fileName.getFileName())) {
                    zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                    zipOutputStream.write(pair.getValue());
                }
            }
        }
    }
}
