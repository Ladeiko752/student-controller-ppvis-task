package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.Controller.Controller;
import sample.Model.Table;
import sample.View.FrontendMainWindow;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Table table = new Table();
        Controller controller = new Controller(table);
        FrontendMainWindow frontendMainWindow = new FrontendMainWindow(controller);

        Group group = new Group(frontendMainWindow.getFlowPane());
        Scene scene = new Scene(group);

        primaryStage.setTitle("Контроль учащихся");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
