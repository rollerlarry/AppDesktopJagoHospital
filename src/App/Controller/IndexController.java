package App.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    private double x,y;
    private Parent root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

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
    void SignUp(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_SignUp.fxml"));
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

    @FXML
    void SignIn(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_SignIn.fxml"));
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
