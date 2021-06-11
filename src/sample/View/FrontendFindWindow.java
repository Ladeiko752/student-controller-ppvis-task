package sample.View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Controller.Controller;
import javafx.scene.control.Label;


public class FrontendFindWindow {
    private TextField firstTextField;
    private TextField secondTextField;
    private final String FullName = "ФИО:";
    private final String Group = "Группа:";
    private final String Course = "Курс:";
    private final String Language = "Язык:";
    private final String CompletedLabs = "Готово работ:";
    private final String AllLabs = "Всего работ:";

    public void showFindWindow(Controller controller, Label firstCriterion, Label secondCriterion){
        HBox hBoxFirstCriterion = new HBox();
        this.firstTextField = new TextField();
        hBoxFirstCriterion.setSpacing(40);
        hBoxFirstCriterion.setAlignment(Pos.CENTER);
        hBoxFirstCriterion.getChildren().addAll(firstCriterion, firstTextField);

        HBox hBoxSecondCriterion = new HBox();
        this.secondTextField = new TextField();
        hBoxSecondCriterion.setSpacing(40);
        hBoxSecondCriterion.setAlignment(Pos.CENTER);
        hBoxSecondCriterion.getChildren().addAll(secondCriterion, secondTextField);

        HBox hBoxButtons = new HBox();

        Button buttonFind = new Button("Поиск");
        buttonFind.setOnAction(event -> {
            if (firstCriterion.getText().equals(FullName) && secondCriterion.getText().equals(Group)){
                controller.findElementByFullNameAndGroup(firstTextField.getText(), secondTextField.getText());
            }
            if (firstCriterion.getText().equals(Course) && secondCriterion.getText().equals(Language)){
                controller.findElementByCourseAndLanguage(firstTextField.getText(), secondTextField.getText());
            }
            if (firstCriterion.getText().equals(CompletedLabs) && secondCriterion.getText().equals(AllLabs)){
                controller.findByLabs(firstTextField.getText(), secondTextField.getText());
            }

        });

        Button buttonCancel = new Button("Отмена");
        buttonCancel.setOnAction(event -> controller.cancelButtonLogic());

        hBoxButtons.setSpacing(40);
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().addAll(buttonFind, buttonCancel);

        VBox vBoxFindWindow = new VBox();
        vBoxFindWindow.setAlignment(Pos.CENTER);
        vBoxFindWindow.setSpacing(10);
        vBoxFindWindow.getChildren().addAll(hBoxFirstCriterion, hBoxSecondCriterion,hBoxButtons);

        Scene scene = new Scene(vBoxFindWindow);

        Stage findDialogWindow = new Stage();
        findDialogWindow.setScene(scene);
        findDialogWindow.setTitle("Поиск");
        findDialogWindow.setResizable(false);
        findDialogWindow.setMinHeight(145);
        findDialogWindow.setMinWidth(350);
        findDialogWindow.show();
    }


}
