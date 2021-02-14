package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        StringBuilder sb=new StringBuilder();
        String line;
        while (!((line=fileReader.readLine()) ==null))
            sb=sb.append(line);
        String htmlString =sb.toString();
        fileReader.close();
        Document doc = Jsoup.parse(htmlString," ", Parser.xmlParser());
        Elements elements = doc.select(args[0]);
        for(Element elem:elements)
        System.out.println(elem);

    }
}
