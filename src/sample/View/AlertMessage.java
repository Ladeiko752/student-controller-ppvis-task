package sample.View;

import javafx.scene.control.Alert;

public class AlertMessage implements Warning{
    @Override
    public void showMessage() {
        Alert messageNotFind = new Alert(Alert.AlertType.INFORMATION);
        messageNotFind.setTitle("Ошибка!");
        messageNotFind.setHeaderText(null);
        messageNotFind.setContentText("По вашему запросу ничего не найдено! Попробуйте ещё раз...");
        messageNotFind.showAndWait();
    }
    @Override
    public void showMessage(String message, int buffer) {
        Alert messageNotFind = new Alert(Alert.AlertType.INFORMATION);
        messageNotFind.setTitle("Ошибка!");
        messageNotFind.setHeaderText(null);
        messageNotFind.setContentText(message + buffer);
        messageNotFind.showAndWait();
    }
}
