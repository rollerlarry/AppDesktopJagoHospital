package App.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DraggedPressedWindow {
    private static double x,y;
    public static void Dragged(MouseEvent event){
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    public static void Pressed(MouseEvent event){
        x = event.getSceneX();
        y = event.getSceneY();
    }
}
