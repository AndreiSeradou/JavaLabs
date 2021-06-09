package by.example.ClientServer.view.сomponent;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.List;


public class SearchBySurnameOrGroupNumber extends VBox {
    private final TextField surname;
    private final GroupComboBox groupNumberBox;

    public SearchBySurnameOrGroupNumber(List<String> groupNumberList){
        super(10);

        surname = new TextField();
        groupNumberBox = new GroupComboBox(groupNumberList);

        setCard();
    }

    private void setCard(){
        surname.setMaxWidth(200);
        surname.setPromptText("Фамилия");

        groupNumberBox.setMaxWidth(200);
        groupNumberBox.setValue("Номер группы");

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(surname, groupNumberBox);
    }

    public String getSurname() {
        return surname.getText();
    }

    public String getGroupNumber(){
        return groupNumberBox.getValue();
    }
}
