package App.Services;

import App.DAO.DiseasesGroupDAO;

public class DiseasesGroupService {
    public static String getDiseasesGroupNameForDiseases(int diseasesGroupID) {
        return DiseasesGroupDAO.getDiseasesGroupNameForDiseases(diseasesGroupID);
    }
}
