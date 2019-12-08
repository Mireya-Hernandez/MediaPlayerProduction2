package sample;


import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Product implements Item {

  private int Id; //mismatch pattern
  private ItemType Type;
  private String Manufacturer;
  private String Name;


  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  public Product(String product, String manufacturer) {
  }

  public String toString() {
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: "
        + Type;
  }

  public int getId() {
    return Id;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }


  public ItemType getType() {
    return Type;
  }

  public void setType(ItemType type) {
    this.Type = type;
  }

  class Widget extends Product {

    Widget(String name, String manufacturer, ItemType type) {
      super(name, manufacturer, type); //Unfixed Bug,  code not in use
    }
  }

}