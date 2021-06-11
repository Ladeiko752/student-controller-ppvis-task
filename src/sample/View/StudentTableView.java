package sample.View;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Model.Student;

public class StudentTableView {
    public static TableView tableView;


    public StudentTableView(){}

    public void showTable(ObservableList<Student> currentPageArray){
        TableColumn<Student, String> fullNameColumn = new TableColumn<Student, String>("ФИО студента");
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("pos1"));
        fullNameColumn.setMinWidth(250);

        TableColumn<Student, String> courseColumn = new TableColumn<Student, String>("Курс");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("pos2"));
        courseColumn.setMinWidth(40);

        TableColumn<Student, String> groupColumn = new TableColumn<Student, String>("Группа");
        groupColumn.setCellValueFactory(new PropertyValueFactory<>("pos3"));
        groupColumn.setMinWidth(40);

        TableColumn<Student, String> numCompletedLabsColumn = new TableColumn<Student, String>("Количество выполненных работ");
        numCompletedLabsColumn.setCellValueFactory(new PropertyValueFactory<>("pos4"));
        numCompletedLabsColumn.setMinWidth(100);

        TableColumn<Student, String> numAllLabsColumn = new TableColumn<Student, String>("Общее количество работ");
        numAllLabsColumn.setCellValueFactory(new PropertyValueFactory<>("pos5"));
        numAllLabsColumn.setMinWidth(100);

        TableColumn<Student, String> programmingLanguageColumn = new TableColumn<Student, String>("Язык программирования");
        programmingLanguageColumn.setCellValueFactory(new PropertyValueFactory<>("pos6"));
        programmingLanguageColumn.setMinWidth(250);

        //this.tableView = new TableView(tableArray);
        this.tableView = new TableView();

        tableView.getColumns().add(fullNameColumn);
        tableView.getColumns().add(courseColumn);
        tableView.getColumns().add(groupColumn);
        tableView.getColumns().add(numCompletedLabsColumn);
        tableView.getColumns().add(numAllLabsColumn);
        tableView.getColumns().add(programmingLanguageColumn);

        this.tableView.setItems(currentPageArray);
    }

    public TableView getTableView(){
        return tableView;
    }
}
