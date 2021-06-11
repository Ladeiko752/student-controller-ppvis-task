package sample.View;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.xml.sax.SAXException;
import sample.Controller.Controller;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class FrontendMainWindow{

    private final FlowPane flowPane = new FlowPane();
    private final Label labelInfoAboutNumPages;
    private final Label labelInfoAboutRecordsOnPage;
    private final Label labelFullName = new Label("ФИО:");
    private final Label labelGroup = new Label("Группа:");
    private final Label labelCourse = new Label("Курс:");
    private final Label labelProgrammingLanguage = new Label("Язык:");
    private final Label labelCompletedLabs = new Label("Готово работ:");
    private final Label labelAllLabs = new Label("Всего работ:");


    public FrontendMainWindow(Controller controller) {

        this.labelInfoAboutNumPages = new Label();
        this.labelInfoAboutRecordsOnPage = new Label();

        MenuBar menu = new MenuBar();

        Menu changeElementMenu = new Menu("Изменить");
        MenuItem addElementItem = new MenuItem("Добавить");
        addElementItem.setOnAction(actionEvent -> {
            FrontendAddWindow frontendAddWindow = new FrontendAddWindow();
            frontendAddWindow.initialize(controller, labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);
        });

        Menu deleteElementItem = new Menu("Удалить");
        changeElementMenu.getItems().addAll(addElementItem, deleteElementItem);

        MenuItem deleteByFullNameAndGroup = new MenuItem("Фамилия и группа");
        deleteByFullNameAndGroup.setOnAction(event -> {
            FrontendDeleteWindow frontendDeleteWindow = new FrontendDeleteWindow();
            frontendDeleteWindow.showDeleteWindow(controller, labelFullName, labelGroup);
        });

        MenuItem deleteByCourseAndLanguage = new MenuItem("Курс и язык");
        deleteByCourseAndLanguage.setOnAction(event -> {
            FrontendDeleteWindow frontendDeleteWindow = new FrontendDeleteWindow();
            frontendDeleteWindow.showDeleteWindow(controller, labelCourse, labelProgrammingLanguage);
        });

        MenuItem deleteByLabs = new MenuItem("Лабораторные работы");
        deleteByLabs.setOnAction(event -> {
            FrontendDeleteWindow frontendDeleteWindow = new FrontendDeleteWindow();
            frontendDeleteWindow.showDeleteWindow(controller, labelCompletedLabs, labelAllLabs);
        });

        deleteElementItem.getItems().addAll(deleteByFullNameAndGroup, deleteByCourseAndLanguage, deleteByLabs);

        Menu operationElementMenu = new Menu("Операции");

        Menu findElementItem = new Menu("Поиск");

        MenuItem findByFullNameAndGroup = new MenuItem("Фамилия и группа");
        findByFullNameAndGroup.setOnAction(event -> {
            FrontendFindWindow frontendFindWindow = new FrontendFindWindow();
            frontendFindWindow.showFindWindow(controller, labelFullName, labelGroup);
        });

        MenuItem findByCourseAndLanguage = new MenuItem("Курс и язык");
        findByCourseAndLanguage.setOnAction(event -> {
            FrontendFindWindow frontendFindWindow = new FrontendFindWindow();
            frontendFindWindow.showFindWindow(controller, labelCourse, labelProgrammingLanguage);
        });

        MenuItem findByLabs = new MenuItem("Лабораторные работы");
        findByLabs.setOnAction(event -> {
            FrontendFindWindow frontendFindWindow = new FrontendFindWindow();
            frontendFindWindow.showFindWindow(controller, labelCompletedLabs, labelAllLabs);
        });


        findElementItem.getItems().addAll(findByFullNameAndGroup, findByCourseAndLanguage, findByLabs);

        MenuItem saveElementItem = new MenuItem("Сохранить");
        saveElementItem.setOnAction(event -> { controller.saveFileInXML(); });

        MenuItem downloadElementItem = new MenuItem("Загрузить");
        downloadElementItem.setOnAction(event -> {
            try {
                controller.downloadFileXML();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        operationElementMenu.getItems().addAll(findElementItem, saveElementItem, downloadElementItem);

        Menu additionallyMenu = new Menu("Дополнително");

        StudentTableView studentTableView = new StudentTableView();
        studentTableView.showTable(controller.getCurrentPageArray());

        menu.getMenus().addAll(changeElementMenu, operationElementMenu, additionallyMenu);

        HBox hBoxButtons = new HBox();
        Button doubleLeftButton = new Button("<<");
        doubleLeftButton.setOnAction(event -> {
            controller.toFirstPage();
            controller.updatingRecordsOnThePage(labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);
        });

        Button leftButton = new Button("<");
        leftButton.setOnAction(event -> {
            controller.toPreviousPage();
            controller.updatingRecordsOnThePage(labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);

        });

        Button rightButton = new Button(">");
        rightButton.setOnAction(event -> {
            controller.toNextPage();
            controller.updatingRecordsOnThePage(labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);
        });

        Button doubleRightButton = new Button(">>");
        doubleRightButton.setOnAction(event -> {
            controller.toLastPage();
            controller.updatingRecordsOnThePage(labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);
        });

        hBoxButtons.setSpacing(5);
        hBoxButtons.getChildren().addAll(doubleLeftButton, leftButton, rightButton, doubleRightButton);


        this.flowPane.getChildren().addAll(menu, studentTableView.getTableView(), hBoxButtons, labelInfoAboutNumPages, labelInfoAboutRecordsOnPage);
    }

    public FlowPane getFlowPane(){ return this.flowPane;}

}
