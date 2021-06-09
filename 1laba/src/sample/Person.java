package sample;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class Person{

    private SimpleIntegerProperty power;
    private SimpleIntegerProperty volume;
    private SimpleIntegerProperty resistance;
    private SimpleIntegerProperty battery;
    private SimpleIntegerProperty cost;
    private SimpleDoubleProperty alternative;
    private SimpleStringProperty name;


    Person(String name,int power, int volume, int resistance, int battery, int cost, double alternative){
        this.power = new SimpleIntegerProperty(power);
        this.volume = new SimpleIntegerProperty(volume);
        this.resistance = new SimpleIntegerProperty(resistance);
        this.battery = new SimpleIntegerProperty(battery);
        this.cost = new SimpleIntegerProperty(cost);
        this.alternative = new SimpleDoubleProperty(alternative);
        this.name = new SimpleStringProperty(name);
    }

    public int getPower(){ return power.get();}
    public void setPower(int value){ power.set(value);}

    public int getVolume(){ return volume.get();}
    public void setVolume(int value){ volume.set(value);}

    public int getResistance(){ return resistance.get();}
    public void setResistance(int value){ resistance.set(value);}

    public int getBattery(){ return battery.get();}
    public void setBattery(int value){ battery.set(value);}

    public int getCost(){ return cost.get();}
    public void setCost(int value){ cost.set(value);}

    public double getAlternative(){ return alternative.get();}
    public void setAlternative(double value){ alternative.set(value);}

    public String getName(){ return name.get();}
    public void setName(String value){ name.set(value);}
}




