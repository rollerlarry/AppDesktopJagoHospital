package App.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HomeController {
    private double x,y;
    private Parent root;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void DraggedWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void PressedWindow(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void btnDiagnostic(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_Diagnostic.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
