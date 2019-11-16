/*Project:HW_3 Stack Frame
*Created: 10/20/2019
*Author: Mireya Hernandez Cruz
 *Purpose: Main Class of the Media Player Production Program
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //does not allow me to decrease the indentation for the whole main
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayerProduction.fxml"));
        primaryStage.setTitle("Software Produce Products");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
