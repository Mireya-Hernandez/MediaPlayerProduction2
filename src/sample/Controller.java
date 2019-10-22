package sample;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;




public class Controller {

  @FXML
  private Tab produceLineTab;

  @FXML
  private AnchorPane productLineAP;

  @FXML
  private Label productNameLabel;

  @FXML
  private Label manufacturerLabel;

  @FXML
  private Label itemTypeGrid;

  @FXML
  private TextField productNameTextField;

  @FXML
  private TextField manufacturerTextField;

  @FXML
  private ChoiceBox<String> choiceBoxItemType;

  @FXML
  private Button addProductButton;
  @FXML
  private Tab produceTab;

  @FXML
  private AnchorPane produceAP;

  @FXML
  private Label chooseProductLabel;

  @FXML
  private ListView<?> chooseProductListView;

  @FXML
  private Label chooseQuantityLabel;

  @FXML
  private ComboBox<String> chooseQuanityComboBox;

  @FXML
  private Button recordProductionButton;

  @FXML
  private Tab productionLogTab;

  @FXML
  private AnchorPane productionLogAP;

  @FXML
  private TextArea textArea;

  @FXML
  void addProductButtonClick(ActionEvent event) {
    System.out.println("Add product");
    initializedDB();

  }

  @FXML
  void recordProButton(ActionEvent event) {
    System.out.println("Add record");
  }


  public void initialize() {

    chooseQuanityComboBox.getItems().add("1");
    chooseQuanityComboBox.getItems().add("2");
    chooseQuanityComboBox.getItems().add("3");
    chooseQuanityComboBox.getItems().add("4");
    chooseQuanityComboBox.getItems().add("5");
    chooseQuanityComboBox.getItems().add("6");
    chooseQuanityComboBox.getItems().add("7");
    chooseQuanityComboBox.getItems().add("8");
    chooseQuanityComboBox.getItems().add("9");
    chooseQuanityComboBox.getItems().add("10");
    chooseQuanityComboBox.setEditable(true);
    chooseQuanityComboBox.getSelectionModel().selectFirst();
  }

  public static void initializedDB() {
    //No more than 2 constructive capital letter
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/MediaDB";

    //  Database credentials
    final String User = "";
    final String Pass = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, User, Pass); //Fixbug no passward needed, empty

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      //String sql = "SELECT * FROM JOBS";

      String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', "
          + "'Apple', 'iPod' )";
      stmt.executeUpdate(sql);

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}