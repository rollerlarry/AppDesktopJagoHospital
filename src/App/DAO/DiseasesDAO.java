package App.DAO;

import App.Connection.JDBCConnection;
import App.Entity.Diseases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiseasesDAO {

    public static List<Diseases> getDiseasesList(){
        ArrayList<Diseases> diseasesList = new ArrayList<>();
        JDBCConnection jdbcConnection = new JDBCConnection();
        Connection connection = jdbcConnection.getJDBCConnection();
        try {
            String sqlSelect = "SELECT * FROM TB_DISEASES";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int diseasesID = resultSet.getInt("DISEASES_ID");
                String diseasesName = resultSet.getString("DISEASES_NAME");
                String diseasesSummary = resultSet.getString("DISEASES_SUMMARY");
                String symptomList = resultSet.getString("SYMPTOM_LIST");
                String diseasesReason = resultSet.getString("DISEASES_REASON");
                String diseasesLevel = resultSet.getString("DISEASES_LEVEL");
                String diseasesTreatment = resultSet.getString("DISEASES_TREATMENT");
                int diseasesGroupId = resultSet.getInt("DISEASES_GROUP_ID");
                String diseasesImage = resultSet.getString("DISEASES_IMAGE");

                Diseases diseases = new Diseases(diseasesID, diseasesName, diseasesSummary, symptomList, diseasesReason, diseasesLevel, diseasesTreatment, diseasesGroupId, diseasesImage);
                diseasesList.add(diseases);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseasesList;
    }
}
