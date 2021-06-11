package sample.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private StringProperty personFullName;
    private StringProperty course;
    private StringProperty group;
    private StringProperty numCompletedLabs;
    private StringProperty numAllLabs;
    private StringProperty programmingLanguage;
    private final String EMPTY = "";

    public Student(){};

    public Student(String personFullName, String course, String group, String numCompletedLabs, String numAllLabs, String programmingLanguage){
        this.personFullName = new SimpleStringProperty(personFullName);
        this.course = new SimpleStringProperty(course);
        this.group = new SimpleStringProperty(group);
        this.numCompletedLabs = new SimpleStringProperty(numCompletedLabs);
        this.numAllLabs = new SimpleStringProperty(numAllLabs);
        this.programmingLanguage = new SimpleStringProperty(programmingLanguage);
    }

    public StringProperty pos1Property(){
        if (this.personFullName == null){
            this.personFullName = new SimpleStringProperty(this.EMPTY);
        }
        return this.personFullName;
    }

    public StringProperty pos2Property(){
        if (this.course == null){
            this.course = new SimpleStringProperty(this.EMPTY);
        }
        return this.course;
    }

    public StringProperty pos3Property(){
        if (this.group == null){
            this.group = new SimpleStringProperty(this.EMPTY);
        }
        return this.group;
    }

    public StringProperty pos4Property(){
        if (this.numCompletedLabs == null){
            this.numCompletedLabs = new SimpleStringProperty(this.EMPTY);
        }
        return this.numCompletedLabs;
    }

    public StringProperty pos5Property(){
        if (this.numAllLabs == null){
            this.numAllLabs = new SimpleStringProperty(this.EMPTY);
        }
        return this.numAllLabs;
    }

    public StringProperty pos6Property(){
        if (this.programmingLanguage == null){
            this.programmingLanguage = new SimpleStringProperty(this.EMPTY);
        }
        return this.programmingLanguage;
    }

    public String getPersonFullName() {
        return personFullName.get();
    }

    public String getCourse() {
        return course.get();
    }

    public String getGroup() {
        return group.get();
    }

    public String getNumCompletedLabs() {
        return numCompletedLabs.get();
    }

    public String getNumAllLabs() {
        return numAllLabs.get();
    }

    public String getProgrammingLanguage() {
        return programmingLanguage.get();
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName.set(personFullName);
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public void setNumAllLabs(String numAllLabs) {
        this.numAllLabs.set(numAllLabs);
    }

    public void setNumCompletedLabs(String numCompletedLabs) {
        this.numCompletedLabs.set(numCompletedLabs);
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage.set(programmingLanguage);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public StringProperty groupProperty() {
        return group;
    }

    public StringProperty numAllLabsProperty() {
        return numAllLabs;
    }

    public StringProperty numCompletedLabsProperty() {
        return numCompletedLabs;
    }

    public StringProperty personFullNameProperty() {
        return personFullName;
    }

    public StringProperty programmingLanguageProperty() {
        return programmingLanguage;
    }

}
