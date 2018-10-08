package App.DAO;

import App.Connection.JDBCConnection;
import App.Entity.Symptom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SymptomDAO {
    private static Connection connection;
    private static List<Symptom> symptomList;
    private static ObservableList<Symptom> symptomsList;
    public static List<Symptom> getSymptomsList(List<String> symptomListsString) {
       symptomList = new ArrayList<>();
        connection = JDBCConnection.getJDBCConnection();
        for (String symptomID : symptomListsString){
            String sqlSelect = String.format("SELECT * FROM TB_SYMPTOM WHERE SYMPTOM_ID = %s",symptomID);
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSelect);
                while (resultSet.next()){
                    String symptomName = resultSet.getString("SYMPTOM_NAME");

                    Symptom symptom = new Symptom(new CheckBox(),1000,symptomName);
                    symptomList.add(symptom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return symptomList;
    }

    public static ObservableList<Symptom> getAllSymptomsList() {
        symptomsList = FXCollections.observableArrayList();
        connection = JDBCConnection.getJDBCConnection();
        try {
            String sqlSelect = "SELECT * FROM TB_SYMPTOM";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int symptomID = Integer.parseInt(resultSet.getString("SYMPTOM_ID"));
                String symptomName = resultSet.getString("SYMPTOM_NAME");
                Symptom symptom = new Symptom(new CheckBox(),symptomID, symptomName);
                symptomsList.add(symptom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return symptomsList;
    }
}
