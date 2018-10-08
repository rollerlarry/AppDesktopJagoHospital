package App.Controller;

import App.Entity.Diseases;
import App.Entity.Symptom;
import App.Services.DiseasesGroupService;
import App.Services.SymptomService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DiseasesDetailsController implements Initializable {
    @FXML
    private Label diseasesName;

    @FXML
    private Label diseasesGroup;

    @FXML
    private Label diseasesSummary;

    @FXML
    private Label diseasesLevel;

    @FXML
    private Label diseasesReason;

    @FXML
    private Label diseasesTreatment;

    @FXML
    private Label symptomList;

    @FXML
    private ImageView imgvDiseases;


    public void setData(ObservableList<Diseases> diseases){

        int diseasesGroupID = diseases.get(0).getDiseaseGroupID();
        String diseasesGroupName = DiseasesGroupService.getDiseasesGroupNameForDiseases(diseasesGroupID);


        diseasesName.setText(diseases.get(0).getDiseasesName());
        diseasesGroup.setText(diseasesGroupName);
        diseasesSummary.setText(diseases.get(0).getDiseasesSummary());
        diseasesLevel.setText(diseases.get(0).getDiseasesLevel());
        diseasesReason.setText(diseases.get(0).getDiseasesReason());
        diseasesTreatment.setText(diseases.get(0).getDiseasesTreatment());



        String urlImage = diseases.get(0).getDiseasesImage();
        Image image = new Image(urlImage);
        imgvDiseases.setImage(image);

        String symptomListString = diseases.get(0).getSymptomList();
        List<Symptom> symptomsList = SymptomService.getSymptomsList(symptomListString);
        String lblShowSymptomList = "";
        for (Symptom symptom: symptomsList){
            lblShowSymptomList += symptom.getSymptomName() + "\n";
        }
        symptomList.setText(lblShowSymptomList);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void closeDiseasesDetails(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
