package by.example.ClientServer.view.сomponent;

import javafx.scene.control.ComboBox;
import java.util.List;

public class GroupComboBox extends ComboBox<String> {
    public GroupComboBox(List<String> groupNumberList){
        for (String groupNumber : groupNumberList) {
            this.getItems().add(groupNumber);
        }
    }
}
