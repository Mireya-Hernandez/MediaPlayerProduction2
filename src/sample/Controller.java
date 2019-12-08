/*Project:HW_3 Stack Frame
 * Created: 10/20/2019
 * Author: Mireya Hernandez Cruz
 * Purpose: The controller of the Media Player Production with fields. Scene Builder was used.
 *   Give user feature to interact with the system.
 * //I could not figure out how to populate the TableView my classmates Luis Hernandez and
    //Nicholis tried to help me out but my code is was confusing.
    //I also received help from Professor Vanselow and the Teacher Assistant Damien
 */

package sample;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class Controller {

  @FXML
  public ChoiceBox<ItemType> choiceBoxItemType;

  @FXML
  public Tab produceLineTab;

  @FXML
  public AnchorPane productLineAP;

  @FXML
  public Label productNameLabel;

  @FXML
  public Label manufacturerLabel;

  @FXML
  public Label itemTypeGrid;

  @FXML
  public TextField productNameTextField;

  @FXML
  public TextField manufacturerTextField;

  @FXML
  public Button addProductButton;

  @FXML
  public Tab produceTab;

  @FXML
  public AnchorPane produceAP;

  @FXML
  public Label chooseProductLabel;

  @FXML
  public ListView<?> chooseProductListView;

  @FXML
  public Label chooseQuantityLabel;

  @FXML
  public ComboBox<Integer> chooseQuanityComboBox;

  @FXML
  public Button recordProductionButton;

  @FXML
  public Tab productionLogTab;

  @FXML
  public AnchorPane productionLogAP;

  @FXML
  public TextArea textArea;

  @FXML
  public TableView<Product> exsitProductTableView;

  @FXML
  public TableColumn<?, ?> colProductName;

  @FXML
  public TableColumn<?, ?> tableColumType;

  @FXML
  public TableColumn<?, ?> colManufacturer;

  private ObservableList<Product> productionLine;
  //Table view

  public void initialize() {

    chooseQuanityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    chooseQuanityComboBox.setEditable(true);
    chooseQuanityComboBox.getSelectionModel().selectFirst();
    //choiceBox for ItemType
    choiceBoxItemType.getItems().addAll(ItemType.values());

    productionLine = FXCollections.observableArrayList();
    initializedDB();
  }


  /**
   * ` User can press the add production button and it display is the console add product. In the
   * database there is type - audio, manufacturer-Apple and name-ipod.
   */
  public void addProductButtonClick(ActionEvent event) {
    System.out.println("Add Product");
    productionLine.add(new Product(productNameTextField.getText(), manufacturerTextField.getText(),
        choiceBoxItemType.getValue()));
    exsitProductTableView.setItems(productionLine);
    colProductName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    colManufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
    tableColumType.setCellValueFactory(new PropertyValueFactory<>("type"));

  }

  @FXML
  void recordProButton(ActionEvent event) {
    System.out.println("Add record");
  }

  /**
   * Represents initialization of the comobox to add string items users can select . The user may
   * select  or input one string if they do not the default is 1.
   */


  static void initializedDB() {
    //No more than 2 constructive capital letter but i left it as is
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/MediaDB";

    //  Database credentials
    final String User = "";
    final String Pass = "PASSWORD";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, User, Pass); //Unfixed Bug

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      //String sql = "SELECT * FROM JOBS";

      String sql =
          "INSERT INTO PRODUCT(ID,NAME,TYPE,MANUFACTURER)" + " VALUES (?,?,?)";
      System.out.println("sql is " + sql);
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



