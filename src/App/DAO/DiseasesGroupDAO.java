package App.DAO;

import App.Connection.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiseasesGroupDAO {
    public static String getDiseasesGroupNameForDiseases(int diseasesGroupID) {
        String diseasesGroupName = null;
        try {
            JDBCConnection jdbcConnection = new JDBCConnection();
            Connection connection = jdbcConnection.getJDBCConnection();
            String sqlSelect = String.format("SELECT * FROM TB_DISEASES_GROUP WHERE DISEASES_GROUP_ID = %d",diseasesGroupID);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                diseasesGroupName = resultSet.getString("DISEASES_GROUP_NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseasesGroupName;
    }
}
