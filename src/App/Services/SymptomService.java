package App.Services;

import App.DAO.SymptomDAO;
import App.Entity.Symptom;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SymptomService {
    public static List<Symptom> getSymptomsList(String symptomListString) {
        List<String> symptomListsString = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(symptomListString,",");
        while (stringTokenizer.hasMoreElements()){
            symptomListsString.add(stringTokenizer.nextToken());
        }

        return SymptomDAO.getSymptomsList(symptomListsString);
    }

    public static ObservableList<Symptom> getAllSymptomsList() {
        return SymptomDAO.getAllSymptomsList();
    }
}
