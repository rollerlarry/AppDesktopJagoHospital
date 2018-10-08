package App.Controller;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController extends StackPane implements Initializable {
    @FXML
    void CloseWindow(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void MinWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void OpenSetting(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_Settings.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
