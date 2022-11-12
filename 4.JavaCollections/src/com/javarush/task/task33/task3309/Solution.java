package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {

        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(obj.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, writer);

        String start = writer.toString();

        String[] arrayStrings = start.split("\n");

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < arrayStrings.length; i++) {
            arrayStrings[i] = arrayStrings[i].trim();

                    if (arrayStrings[i].contains("<" + tagName)) {
                            stringBuilder.append("<!--").append(comment).append("-->").append("\n");
                    }

            stringBuilder.append(arrayStrings[i]).append("\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws JAXBException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }


    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4 = "second";
        @XmlElement(name = "second")
        public String item5 = "![CDATA[need CDATA because of \"";
    }

}
