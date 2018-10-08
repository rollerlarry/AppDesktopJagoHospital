package App.Entity;

public class Diseases {
    private int diseaseID;
    private String diseasesName;
    private String diseasesSummary;
    private String symptomList;
    private String diseasesReason;
    private String diseasesLevel;
    private String diseasesTreatment;
    private int diseaseGroupID;
    private String diseasesImage;

    public Diseases(int diseaseID, String diseasesName, String diseasesSummary, String symptomList, String diseasesReason, String diseasesLevel, String diseasesTreatment, int diseaseGroupID, String diseasesImage) {
        this.diseaseID = diseaseID;
        this.diseasesName = diseasesName;
        this.diseasesSummary = diseasesSummary;
        this.symptomList = symptomList;
        this.diseasesReason = diseasesReason;
        this.diseasesLevel = diseasesLevel;
        this.diseasesTreatment = diseasesTreatment;
        this.diseaseGroupID = diseaseGroupID;
        this.diseasesImage = diseasesImage;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getDiseasesName() {
        return diseasesName;
    }

    public void setDiseasesName(String diseasesName) {
        this.diseasesName = diseasesName;
    }

    public String getDiseasesSummary() {
        return diseasesSummary;
    }

    public void setDiseasesSummary(String diseasesSummary) {
        this.diseasesSummary = diseasesSummary;
    }

    public String getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(String symptomList) {
        this.symptomList = symptomList;
    }

    public String getDiseasesReason() {
        return diseasesReason;
    }

    public void setDiseasesReason(String diseasesReason) {
        this.diseasesReason = diseasesReason;
    }

    public String getDiseasesLevel() {
        return diseasesLevel;
    }

    public void setDiseasesLevel(String diseasesLevel) {
        this.diseasesLevel = diseasesLevel;
    }

    public String getDiseasesTreatment() {
        return diseasesTreatment;
    }

    public void setDiseasesTreatment(String diseasesTreatment) {
        this.diseasesTreatment = diseasesTreatment;
    }

    public int getDiseaseGroupID() {
        return diseaseGroupID;
    }

    public void setDiseaseGroupID(int diseaseGroupID) {
        this.diseaseGroupID = diseaseGroupID;
    }

    public String getDiseasesImage() {
        return diseasesImage;
    }

    public void setDiseasesImage(String diseasesImage) {
        this.diseasesImage = diseasesImage;
    }

    @Override
    public String toString() {
        return "Diseases{" +
                "diseaseID=" + diseaseID +
                ", diseasesName='" + diseasesName + '\'' +
                ", diseasesSummary='" + diseasesSummary + '\'' +
                ", symptomList='" + symptomList + '\'' +
                ", diseasesReason='" + diseasesReason + '\'' +
                ", diseasesLevel='" + diseasesLevel + '\'' +
                ", diseasesTreatment='" + diseasesTreatment + '\'' +
                ", diseaseGroupID=" + diseaseGroupID +
                ", diseasesImage='" + diseasesImage + '\'' +
                '}';
    }
}
