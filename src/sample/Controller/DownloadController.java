package sample.Controller;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sample.Model.Student;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class DownloadController{
    final String FILE_XML = "student.xml";
    private String tagName;
    private String personFullName;
    private String course;
    private String group;
    private String numCompletedLabs;
    private String numAllLabs;
    private String programmingLanguage;

    public DownloadController(ObservableList<Student> tableArray) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler defaultHandler = new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                tagName = qName;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (tagName == null){
                    return;
                }

                switch (tagName){
                    case "fullName": {
                        personFullName = new String(ch, start, length);
                        break;
                    }
                    case "course": {
                        course = new String(ch, start, length);
                        break;
                    }
                    case "group":{
                        group = new String(ch, start, length);
                        break;
                    }
                    case "completedLabs":{
                        numCompletedLabs = new String(ch, start, length);
                        break;
                    }
                    case "allLabs":{
                        numAllLabs = new String(ch, start, length);
                    }
                    case "language":{
                        programmingLanguage = new String(ch, start, length);
                    }
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName!=null){
                    if (qName.equals("student")){
                        Student student = new Student(personFullName, course, group, numCompletedLabs, numAllLabs, programmingLanguage);
                        tableArray.add(student);
                    }
                }
                tagName = null;
            }
        };
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(new File(FILE_XML), defaultHandler);
    }
}
