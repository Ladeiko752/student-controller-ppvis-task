package sample.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Controller.Controller;


public class FrontendAddWindow {
    private TextField fullNameTextField;
    private TextField courseTextField;
    private TextField groupTextField;
    private TextField allLabsTextField;
    private TextField completedLabsTextField;
    private TextField programmingLanguageTextField;
    private Stage addWindowStage;

    public void initialize(Controller controller, Label label, Label label2){

        HBox hBoxFullName = new HBox();
        Label labelFullName = new Label("ФИО: ");
        labelFullName.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.fullNameTextField = new TextField();
        hBoxFullName.setSpacing(135);
        hBoxFullName.getChildren().addAll(labelFullName, fullNameTextField);

        HBox hBoxCourse = new HBox();
        Label labelCourse = new Label("Курс: ");
        labelCourse.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.courseTextField = new TextField();
        hBoxCourse.setSpacing(132);
        hBoxCourse.getChildren().addAll(labelCourse, courseTextField);

        HBox hBoxGroup = new HBox();
        Label labelGroup = new Label("Группа: ");
        labelGroup.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.groupTextField = new TextField();
        hBoxGroup.setSpacing(120);
        hBoxGroup.getChildren().addAll(labelGroup, groupTextField);

        HBox hBoxAllLabs = new HBox();
        Label labelAllLabs = new Label("Общее кол-во лаб: ");
        labelAllLabs.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.allLabsTextField = new TextField();
        hBoxAllLabs.setSpacing(55);
        hBoxAllLabs.getChildren().addAll(labelAllLabs, allLabsTextField);

        HBox hBoxCompletedLabs = new HBox();
        Label labelCompletedLabs = new Label("Готовые лабы: ");
        labelCompletedLabs.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.completedLabsTextField = new TextField();
        hBoxCompletedLabs.setSpacing(77);
        hBoxCompletedLabs.getChildren().addAll(labelCompletedLabs, completedLabsTextField);

        HBox hBoxProgrammingLanguage = new HBox();
        Label labelProgrammingLanguage = new Label("Язык программирования: ");
        labelProgrammingLanguage.setStyle("-fx-font-weight: bolder; -fx-font-family: Impact; -fx-font-size: 14;");
        this.programmingLanguageTextField = new TextField();
        hBoxProgrammingLanguage.setSpacing(10);
        hBoxProgrammingLanguage.getChildren().addAll(labelProgrammingLanguage, programmingLanguageTextField);

        HBox hBoxButtons = new HBox();
        Button buttonAdd = new Button("Добавить");

        buttonAdd.setOnAction(actionEvent -> {
            controller.addElementInTable(fullNameTextField.getText(), courseTextField.getText(), groupTextField.getText(),
                    completedLabsTextField.getText(), allLabsTextField.getText(), programmingLanguageTextField.getText(), label, label2);
            controller.updateTable();
            addWindowStage.close();
        });

        Button buttonCancel = new Button("Отмена");
        hBoxButtons.setSpacing(35);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().addAll(buttonAdd, buttonCancel);

        VBox vBoxAdderWindow = new VBox(hBoxFullName, hBoxCourse, hBoxGroup, hBoxAllLabs, hBoxCompletedLabs, hBoxProgrammingLanguage, hBoxButtons);
        vBoxAdderWindow.setAlignment(Pos.BASELINE_CENTER);
        vBoxAdderWindow.setSpacing(20);

        Scene scene = new Scene(vBoxAdderWindow);

        this.addWindowStage = new Stage();
        this.addWindowStage.setScene(scene);
        this.addWindowStage.setTitle("Добавить студента");
        this.addWindowStage.setResizable(false);
        this.addWindowStage.setMinHeight(345);
        this.addWindowStage.setMinWidth(350);
        this.addWindowStage.show();
    }

}
