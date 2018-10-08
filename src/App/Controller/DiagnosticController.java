package App.Controller;

import App.Entity.Diseases;
import App.Entity.Symptom;
import App.Services.DiseasesService;
import App.Services.SymptomService;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class DiagnosticController implements Initializable {
    private List<String> listSymptomId;
    private ObservableList<Symptom> symptomsList;
    private FilteredList filteredList;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXListView<Diseases> lvResult;

    @FXML
    private Label lblShowSymptom;

    @FXML
    private Label lblCountDiseases;

    @FXML
    private TextField txtSearchSymptom;

    @FXML
    private TableView<Symptom> tbvSymptom;

    @FXML
    private TableColumn<Symptom, CheckBox> check;

    @FXML
    private TableColumn<Symptom, String> symptomName;

    @FXML
    void draggedWindow(MouseEvent event) {
        DraggedPressedWindow.Dragged(event);
    }

    @FXML
    void pressedWindow(MouseEvent event) {
        DraggedPressedWindow.Pressed(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        symptomsList = FXCollections.observableArrayList();
        filteredList = new FilteredList(symptomsList);
        check.setCellValueFactory(new PropertyValueFactory<Symptom,CheckBox>("checkBox"));
        symptomName.setCellValueFactory(new PropertyValueFactory<Symptom,String>("symptomName"));
        symptomsList = SymptomService.getAllSymptomsList();
        tbvSymptom.setItems(symptomsList);
    }

    @FXML
    void searchSymptom(KeyEvent event) {
        txtSearchSymptom.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Symptom>) (Symptom symptom)->{
                if (newValue.isEmpty() || newValue == null){
                    return true;
                }else if(symptom.getSymptomName().contains(newValue)){
                    return true;
                }
                return false;
            });
        });
        SortedList sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tbvSymptom.comparatorProperty());
        tbvSymptom.setItems(sortedList);
    }

    @FXML
    void diagnosticDiseases(MouseEvent event) {
        listSymptomId = new ArrayList<>();
        txtSearchSymptom.clear();

        //Add symptom checked into list
        String strShowSymptom = "";
        for (int i = 0; i < tbvSymptom.getItems().size(); i++) {
            if (tbvSymptom.getItems().get(i).getCheckBox().isSelected()){
                strShowSymptom += tbvSymptom.getItems().get(i).getSymptomName() +"  ";
                listSymptomId .add(String.valueOf(tbvSymptom.getItems().get(i).getSymptomID()));
            }
        }
        //Check checked symptom
        if (checkCheckedSymptom()){
            List<Diseases> listDiseasesOfDiagnostic = DiseasesService.getDiseasesForDiagnosticList(listSymptomId);
            lvResult.getItems().clear();
            ObservableList<Diseases> diseasesObservableList = FXCollections.observableList(listDiseasesOfDiagnostic);
            lvResult.setCellFactory(new Callback<ListView<Diseases>, ListCell<Diseases>>() {
                @Override
                public ListCell<Diseases> call(ListView<Diseases> param) {
                    ListCell<Diseases> cell = new ListCell<Diseases>(){
                        @Override
                        protected void updateItem(Diseases item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null){
                                setText(item.getDiseasesName());
                            }
                        }
                    };
                    return cell;
                }
            });
            lvResult.setItems(diseasesObservableList);
        }
        lblShowSymptom.setText(strShowSymptom);
        showDiseasesNumberForDiagnostic();
    }

    public boolean checkCheckedSymptom(){
        if (listSymptomId.size() == 0){
            JFXDialogLayout jfxDialogLayout = new JFXDialogLayout();
            jfxDialogLayout.setHeading(new Text("Bạn cần chọn ít nhất một triệu chứng"));
            JFXDialog jfxDialog = new JFXDialog(stackPane,jfxDialogLayout,JFXDialog.DialogTransition.CENTER);
            jfxDialog.show();
            return false;
        }
        return true;
    }

    public void showDiseasesNumberForDiagnostic(){
        lblCountDiseases.setText(String.valueOf(lvResult.getItems().size()));
    }

    @FXML
    void chooseDiseases(MouseEvent event){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/App/Views/FXML_DiseasesDetails.fxml"));
            Parent root = loader.load();
            DiseasesDetailsController secController=loader.getController();
            secController.setData(lvResult.getSelectionModel().getSelectedItems());

            Dialog dialog = new Dialog();
            dialog.getDialogPane().setContent(root);
            dialog.initStyle(StageStyle.TRANSPARENT);
            dialog.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
