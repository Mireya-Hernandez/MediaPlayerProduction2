/*Project:HW_3 Stack Frame
  * Created: 10/20/2019
  * Author: Mireya Hernandez Cruz
  * Purpose: The controller of the Media Player Production with fields. Scene Builder was used.
  *   Give user feature to interact with the system.
 */

package sample;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
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
  private ChoiceBox<ItemType> choiceBoxItemType;
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
  private ComboBox<Integer> chooseQuanityComboBox;

  @FXML
  private Button recordProductionButton;

  @FXML
  private Tab productionLogTab;

  @FXML
  private AnchorPane productionLogAP;

  @FXML
  private TextArea textArea;

  @FXML
  private TableView<Product> exsitProductTableView;

  @FXML
  private TableColumn<String, Product> colProductName;

  @FXML
  private TableColumn<ItemType, Product> tableColumType;

  @FXML
  private TableColumn<String, Product> colManufacturer;
  private ObservableList<Product> productionLine;


  /**
   * User can press the add production button and it display is the console add product. In the
   * database there is type - audio, manufacturer-Apple and name-ipod.
   */
  @FXML
  void addProductButtonClick(ActionEvent event) {
    System.out.println("Add product");
    initializedDB();
  }

  @FXML
  void recordProButton(ActionEvent event) {
    System.out.println("Add record");
  }

  /**
   * Represents initialization of the comobox to add string items users can select . The user may
   * select  or input one string if they do not the default is 1.
   */
  public void initialize() {

    chooseQuanityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    chooseQuanityComboBox.setEditable(true);
    chooseQuanityComboBox.getSelectionModel().selectFirst();
    //choiceBox for ItemType
    choiceBoxItemType.getItems().addAll(ItemType.values());

    productionLine = FXCollections.observableArrayList();// Observable list is an interface
    colProductName.setCellValueFactory(new PropertyValueFactory("Product"));
    colManufacturer.setCellValueFactory(new PropertyValueFactory("Manufcturer"));
    tableColumType.setCellValueFactory(new PropertyValueFactory("Type"));
    exsitProductTableView.setItems(productionLine);
    //add more code
  }


  /**
   * The testMultimedia class allow for demonstration of the functionality of the user interface.
   */
  public static void testMultimedia() {
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
          "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
          MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }   //does not allow me to move further
    }




  /**
   * Represents initialization of the h2 database to connect it to the Media Production Program .
   * In the database there is type - audio, manufacturer-Apple and name-ipod.
   */

  public static void initializedDB() {
    //No more than 2 constructive capital letter but i left it as is
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