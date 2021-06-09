package sample;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class Main extends Application{

    int maxPower,maxVolume,maxResistance,maxBattery,maxCost;

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ObservableList<Person> people = FXCollections.observableArrayList(
                new Person("GeekVape",45, 4,3,1200,3,0.0265),
                new Person("IJust S",60, 4,2,3000,5,0.0023),
                new Person("IJust 3 Pro",100, 6,3,3000,1,0.0022),
                new Person("Wismec Active",80, 4,3,2100,4,0.0065),
                new Person("Smoant Knife 80",80, 4,3,2500,2,0.0056)
        );

        TableView<Person> table = new TableView<Person>(people);
        table.setPrefWidth(500);
        table.setPrefHeight(500);

        TableColumn<Person, String> nameColumn = new TableColumn<Person, String>("Name");
        // определяем фабрику для столбца с привязкой к свойству name
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        // добавляем столбец
        table.getColumns().add(nameColumn);

        TableColumn<Person, Integer> powerColumn = new TableColumn<Person, Integer>("Maximum power");
        powerColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("power"));
        table.getColumns().add(powerColumn);

        TableColumn<Person, Integer> volumeColumn = new TableColumn<Person, Integer>("Volume of the tank");
        volumeColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("volume"));
        table.getColumns().add(volumeColumn);

        TableColumn<Person, Integer> resistanceColumn = new TableColumn<Person, Integer>("Supported resistance");
        resistanceColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("resistance"));
        table.getColumns().add(resistanceColumn);

        TableColumn<Person, Integer> batteryColumn = new TableColumn<Person, Integer>("Battery capacity");
        batteryColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("battery"));
        table.getColumns().add(batteryColumn);

        TableColumn<Person, Integer> costColumn = new TableColumn<Person, Integer>("The cost");
        costColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("cost"));
        table.getColumns().add(costColumn);

        TableColumn<Person, Integer> alternativeColumn = new TableColumn<Person, Integer>(" The optimal alternative");
        alternativeColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("alternative"));
        table.getColumns().add(alternativeColumn);

        TextField textPower = new TextField();
        textPower.setPromptText("Maximum power");
        TextField textVolume = new TextField();
        textVolume.setPromptText("Volume of the tank");
        TextField textResistance = new TextField();
        textResistance.setPromptText("Supported resistance");
        TextField textBattery = new TextField();
        textBattery.setPromptText("Battery capacity");
        TextField textCost = new TextField();
        textCost.setPromptText("The cost");
        TextField nameCost = new TextField();
        nameCost.setPromptText("Name");

        Button btn = new Button("Add Element");
        btn.setPrefWidth(500);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                people.add(new Person(nameCost.getText(),Integer.parseInt(textPower.getText()),Integer.parseInt(textVolume.getText()),Integer.parseInt(textResistance.getText()),Integer.parseInt(textBattery.getText()),Integer.parseInt(textCost.getText()),(1-((Integer.parseInt(textPower.getText())*0.6)/100))*(1-((Integer.parseInt(textVolume.getText())*0.8)/6.5))*(1-((Integer.parseInt(textResistance.getText())*0.9)/3.5))*(1-((Integer.parseInt(textBattery.getText())*0.8)/3000))*(1-((Integer.parseInt(textCost.getText())*0.9)/5))));
                table.refresh();
            }
        });

        FlowPane root = new FlowPane(10, 10, table,textPower,textVolume,textResistance,textBattery,textCost,nameCost,btn);

        Scene scene = new Scene(root, 500, 625);

        stage.setScene(scene);
        stage.setTitle("TableView in JavaFX");
        stage.show();
    }
}