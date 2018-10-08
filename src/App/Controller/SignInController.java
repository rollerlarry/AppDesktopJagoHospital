package App.Controller;

import App.Connection.ConnectionClass;
import App.Connection.JDBCConnection;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    private Parent root;
    @FXML
    private Label lbNoti;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void GoSignUp(MouseEvent event) {
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
    void GoHome(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_Index.fxml"));
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
        //ConnectionClass connectionClass = new ConnectionClass();
        // connection = connectionClass.getConnection();

        JDBCConnection jdbcConnection = new JDBCConnection();
        Connection connection = jdbcConnection.getJDBCConnection();

        String userName = txtUsername.getText();
        String passWord = txtPassword.getText();

        if (userName.isEmpty() || passWord.isEmpty()){
            lbNoti.setText("Tên tài khoản người dùng hoặc mật khẩu không được để trống");
        }else{
            try {
                String sqlSelect = "SELECT * FROM TB_USER WHERE USER_NAME = '"+userName+"' AND PASSWORD = '"+passWord+"'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSelect);

                if (resultSet.next()){
                    try {
                        root = FXMLLoader.load(getClass().getClassLoader().getResource("App/Views/FXML_Home.fxml"));
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
                }else{
                    lbNoti.setText("Tên tài khoản người dùng hoặc mật khẩu sai");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void SignIn(KeyEvent event) {
            System.out.println("123");
    }
}
