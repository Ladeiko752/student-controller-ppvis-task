package sample.Controller;

import javafx.collections.ObservableList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sample.Model.Student;
import sample.View.AlertMessage;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class SaveController {

    public SaveController(ObservableList<Student> tableArray) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
            Element element = document.createElement("Information");
            document.appendChild(element);

            for (Student student: tableArray){
                Element studentElement = document.createElement("student");
                element.appendChild(studentElement);
                addElementsXML(document, studentElement, "fullName", student.getPersonFullName());
                addElementsXML(document, studentElement, "course", student.getCourse());
                addElementsXML(document, studentElement, "group", student.getGroup());
                addElementsXML(document, studentElement, "completedLabs", student.getNumCompletedLabs());
                addElementsXML(document, studentElement, "allLabs", student.getNumAllLabs());
                addElementsXML(document, studentElement, "language", student.getProgrammingLanguage());
            }

        } catch (ParserConfigurationException e) {
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
        finally {
            String FILE_XML = "student.xml";
            if (document !=null) recodingFile(document, FILE_XML);
        }
    }

    public void addElementsXML(Document document, Element student, String tagName, String val){
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(val));
        student.appendChild(element);
    }

    public void recodingFile(Document doc, String xml) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            DOMSource domSource = new DOMSource(doc);
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult streamResult = new StreamResult(xml);
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }
}
