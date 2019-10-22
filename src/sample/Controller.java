package sample;

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

import java.sql.*;


public class Controller {

    @FXML
    private Tab ProduceLineTab;

    @FXML
    private AnchorPane ProductLineAP;

    @FXML
    private Label ProductNameLabel;

    @FXML
    private Label ManufacturerLabel;

    @FXML
    private Label ItemTypeGrid;

    @FXML
    private TextField ProductNameTextField;

    @FXML
    private TextField ManufacturerTextField;

    @FXML
    private ChoiceBox<String> ChoiceBoxItemType;

    @FXML
    private Button addProductButton;
    @FXML
    private Tab ProduceTab;

    @FXML
    private AnchorPane ProduceAP;

    @FXML
    private Label ChooseProductLabel;

    @FXML
    private ListView<?> ChooseProductListView;

    @FXML
    private Label ChooseQuantityLabel;

    @FXML
    private ComboBox<String> chooseQuanityComboBox;

    @FXML
    private Button RecordProductionButton;

    @FXML
    private Tab ProductionLogTab;

    @FXML
    private AnchorPane ProductionLogAP;

    @FXML
    private TextArea TextArea;

    @FXML
    void addProductButtonClick(ActionEvent event){
        System.out.println("Add product");
        initializedDB();

    }

    @FXML
    void recordProButton(ActionEvent event) {
        System.out.println("Add record");
    }


    public void initialize(){


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

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/MediaDB";

        //  Database credentials
        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS); //Fixbug no passward needed, empty

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            //String sql = "SELECT * FROM JOBS";

            String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";
            stmt.executeUpdate(sql);
           // PreparedStatement preparedStatement = conn.prepareStatement(sql);
            /*
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }*/

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