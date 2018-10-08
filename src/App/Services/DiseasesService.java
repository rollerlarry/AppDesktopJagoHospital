package App.Services;

import App.DAO.DiseasesDAO;
import App.Entity.Diseases;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DiseasesService {

    public static List<Diseases> getDiseasesForDiagnosticList(List<String> symptomIdList){
        List<Diseases> diseasesResultList = new ArrayList<>();
        List<Diseases> diseasesList = DiseasesDAO.getDiseasesList();

        if (symptomIdList.size() > 0){
            for (Diseases diseases : diseasesList){
                List<String> symptomIdListOfDiseases = new ArrayList<>();
                symptomIdListOfDiseases.add(diseases.getSymptomList());
                for (String symptomList : symptomIdListOfDiseases){
                    StringTokenizer stringTokenizer = new StringTokenizer(symptomList, ",");
                    List<String> symptomListAfterToken = new ArrayList<>();
                    while (stringTokenizer.hasMoreElements()){
                        symptomListAfterToken.add(stringTokenizer.nextToken());
                    }
                    int count = 0;
                    for (int i = 0; i < symptomIdList.size(); i++) {
                        for (int j = 0; j < symptomListAfterToken.size(); j++) {
                            if (symptomIdList.get(i).equals(symptomListAfterToken.get(j))){
                                count++;
                            }
                        }
                    }

                    if (count  == symptomIdList.size()){
                        diseasesResultList.add(diseases);
                    }
                }
            }
        }
        return diseasesResultList;
    }
}
