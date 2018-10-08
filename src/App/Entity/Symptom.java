package App.Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Symptom {

    int symptomID;
    CheckBox checkBox;
    SimpleStringProperty symptomName;

    public Symptom(CheckBox checkBox, int symptomID, String symptomName) {
        this.checkBox = checkBox;
        this.symptomID = symptomID;
        this.symptomName = new SimpleStringProperty(symptomName);
    }

    public int getSymptomID() {
        return symptomID;
    }

    public int symptomIDProperty() {
        return symptomID;
    }


    public String getSymptomName() {
        return symptomName.get();
    }

    public SimpleStringProperty symptomNameProperty() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName.set(symptomName);
    }


    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
