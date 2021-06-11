package sample.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Table {
    private int numOfPages = 1;
    private int currentPages = 1;
    private int numOfRecords = 1;
    private int numOfRecordsOnCurrentPage = 1;

    ObservableList<Student> tableArray = FXCollections.observableArrayList();
    ObservableList<Student> currentPageArray = FXCollections.observableArrayList();

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public int getNumOfRecords() {
        return numOfRecords;
    }

    public void setNumOfRecords(int numOfRecords) {
        this.numOfRecords = numOfRecords;
    }

    public int getNumOfRecordsOnCurrentPage() {
        return numOfRecordsOnCurrentPage;
    }

    public void setNumOfRecordsOnCurrentPage(int numOfRecordsOnCurrentPage) {
        this.numOfRecordsOnCurrentPage = numOfRecordsOnCurrentPage;
    }

    TableView<Student> tableView = new TableView<>();

    public Table(){};

    public ObservableList<Student> getTableArray() {
        return tableArray;
    }

    public ObservableList<Student> getCurrentPageArray() {
        return currentPageArray;
    }

    public void setCurrentPageArray(ObservableList<Student> currentPageArray) {
        this.currentPageArray = currentPageArray;
    }

    public void setTableArray(ObservableList<Student> tableArray) {
        this.tableArray = tableArray;
    }
}
