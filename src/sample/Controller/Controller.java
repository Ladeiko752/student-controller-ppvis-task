package sample.Controller;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import org.xml.sax.SAXException;
import sample.Model.Student;
import sample.Model.Table;
import sample.View.AlertMessage;
import sample.View.StudentTableView;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private final Table table;
    private ObservableList<Student> tableArray;
    private ObservableList<Student> currentPageArray;
    private final String MESSAGE = "Было удалено записей: ";

    public Controller(Table table){
        this.table = table;
        this.tableArray = table.getTableArray();
        this.currentPageArray = table.getCurrentPageArray();
    }

    public void addElementInTable(String personFullName, String course, String group, String numCompletedLabs, String numAllLabs, String programmingLanguage, Label label, Label label2){
        Student student = new Student(personFullName, course, group, numCompletedLabs, numAllLabs, programmingLanguage);
        tableArray = table.getTableArray();
        tableArray.add(student);
        table.setTableArray(tableArray);

        updatingRecordsOnThePage(label, label2);
    }

    public void findElementByFullNameAndGroup(String firstCriterion, String secondCriterion) {
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        int currentBuffer = 0;
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        tableView.getTableView().getSelectionModel().clearSelection();
        for (Student value : tableArray) {
            if (firstCriterion.equals(value.getPersonFullName()) && secondCriterion.equals(value.getGroup())){
                bufferStrings.add(currentBuffer);
                tableView.getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                tableView.getTableView().getSelectionModel().select(currentBuffer);
            }
            currentBuffer++;
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void findElementByCourseAndLanguage(String firstCriterion, String secondCriterion){
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        int currentBuffer = 0;
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        tableView.getTableView().getSelectionModel().clearSelection();
        for (Student value : tableArray) {
            if (firstCriterion.equals(value.getCourse()) && secondCriterion.equals(value.getProgrammingLanguage())){
                bufferStrings.add(currentBuffer);
                tableView.getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                tableView.getTableView().getSelectionModel().select(currentBuffer);
            }
            currentBuffer++;
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void findByLabs(String firstCriterion, String secondCriterion){
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        int currentBuffer = 0;
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        tableView.getTableView().getSelectionModel().clearSelection();
        for (Student value : tableArray) {
            if (firstCriterion.equals(value.getNumCompletedLabs()) && secondCriterion.equals(value.getNumAllLabs())){
                bufferStrings.add(currentBuffer);
                tableView.getTableView().getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                tableView.getTableView().getSelectionModel().select(currentBuffer);
            }
            currentBuffer++;
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void deleteByFullNameAndGroup(String firstCriterion, String secondCriterion){
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        int currentBuffer = 0;

        for (int i = 0; i < tableArray.size(); i++) {
            if (firstCriterion.equals(tableArray.get(i).getPersonFullName()) && secondCriterion.equals(tableArray.get(i).getGroup())){
                bufferStrings.add(currentBuffer);
                tableArray.remove(tableArray.get(i));
                i--;
                currentBuffer++;
            }
        }
        if (!bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage(MESSAGE, currentBuffer);
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void deleteByCourseAndLanguage(String firstCriterion, String secondCriterion){
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        int currentBuffer = 0;

        for (int i = 0; i < tableArray.size(); i++) {
            if (firstCriterion.equals(tableArray.get(i).getCourse()) && secondCriterion.equals(tableArray.get(i).getProgrammingLanguage())){
                bufferStrings.add(currentBuffer);
                tableArray.remove(tableArray.get(i));
                i--;
                currentBuffer++;
            }
        }
        if (!bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage(MESSAGE, currentBuffer);
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void deleteByLabs(String firstCriterion, String secondCriterion){
        tableArray = table.getTableArray();
        StudentTableView tableView = new StudentTableView();
        ArrayList<Integer> bufferStrings = new ArrayList<>();
        int currentBuffer = 0;

        for (int i = 0; i < tableArray.size(); i++) {
            if (firstCriterion.equals(tableArray.get(i).getNumCompletedLabs()) && secondCriterion.equals(tableArray.get(i).getNumAllLabs())){
                bufferStrings.add(currentBuffer);
                tableArray.remove(tableArray.get(i));
                i--;
                currentBuffer++;
            }
        }
        if (!bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage(MESSAGE, currentBuffer);
        }
        if (bufferStrings.isEmpty()){
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.showMessage();
        }
    }

    public void cancelButtonLogic(){
        StudentTableView tableView = new StudentTableView();
        tableView.getTableView().getSelectionModel().clearSelection();
    }

    public void saveFileInXML(){ new SaveController(table.getTableArray()); }

    public void downloadFileXML() throws ParserConfigurationException, SAXException, IOException {
        new DownloadController(table.getTableArray());
    }

    public void updateTable(){
        this.currentPageArray = table.getCurrentPageArray();
        this.currentPageArray.clear();
        this.tableArray = table.getTableArray();
        if (this.tableArray.size() + 1 > table.getNumOfRecordsOnCurrentPage()) {
            for (int i = (table.getCurrentPages() - 1) * table.getNumOfRecordsOnCurrentPage(); i < table.getCurrentPages() * table.getNumOfRecordsOnCurrentPage(); i++) {
                try{this.currentPageArray.add(tableArray.get(i));}
                catch (IndexOutOfBoundsException ex){
                    System.out.println("Что-то пошло не так!");
                }
            }
        } else {
            this.currentPageArray.addAll(tableArray);
        }
        table.setCurrentPageArray(this.currentPageArray);
    }

    public void updatingRecordsOnThePage(Label firstLabel, Label secondLabel){
        this.tableArray = table.getTableArray();
        table.setNumOfRecords(tableArray.size());
        if(tableArray.size() % table.getNumOfRecordsOnCurrentPage() == 0) {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage());
        } else {
            table.setNumOfRecordsOnCurrentPage(tableArray.size() / table.getNumOfRecordsOnCurrentPage() + 1);
        }
        firstLabel.setText("\tТекущая страница: " + table.getCurrentPages() + " Всего страниц: " + table.getNumOfPages());
        secondLabel.setText("\tКол-во записей на странице: " + table.getNumOfRecordsOnCurrentPage() + " Общее кол-во записей: " + table.getNumOfRecords());
    }

    public void toFirstPage(){
        if(tableArray.size() % table.getNumOfRecordsOnCurrentPage() == 0) {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage());
        } else {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage() + 1);}
        table.setCurrentPages(1);
        updateTable();
    }

    public void toPreviousPage(){
        if(tableArray.size() % table.getNumOfRecordsOnCurrentPage() == 0) {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage());
        } else {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage() + 1);}
        if (table.getCurrentPages() != 1) {
            int i = table.getCurrentPages();
            table.setCurrentPages(--i);
            updateTable();
        }
    }

    public void toNextPage(){
        if(tableArray.size() % table.getNumOfRecordsOnCurrentPage() == 0) {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage());
        } else {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage() + 1);}
        if (table.getCurrentPages() < table.getNumOfPages()) {
            int i = table.getCurrentPages();
            table.setCurrentPages(++i);
            updateTable();
        }
    }

    public void toLastPage(){
        if(tableArray.size() % table.getNumOfRecordsOnCurrentPage() == 0) {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage());
        } else {
            table.setNumOfPages(tableArray.size() / table.getNumOfRecordsOnCurrentPage() + 1);}
        table.setCurrentPages(table.getNumOfPages());
        updateTable();
    }

    public void updateNumberOfRecordsOnPage(int numberOfRecordsOnPage){
        table.setNumOfRecordsOnCurrentPage(numberOfRecordsOnPage);
    }

    public void setTableArray(ObservableList<Student> tableArray) {
        this.tableArray = tableArray;
    }

    public ObservableList<Student> getCurrentPageArray() {
        return currentPageArray;
    }

    public void setCurrentPageArray(ObservableList<Student> currentPageArray) {
        this.currentPageArray = currentPageArray;
    }

    public ObservableList<Student> getTableArray() {
        return tableArray;
    }
}
