// Sabrina Turney
// Week 6 - JavaFX Program 1
// TaxCalculator - Based on Tip Calculator
// COP 2800 - Programming with Java
//Here is the main class for the tax calculator,
//where the tax calculators main method will be handled.


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TaxCalculator extends Application {
      @Override
      public void start(Stage stage) throws Exception{
         Parent root =
            FXMLLoader.load(getClass().getResource("TaxCalculator.fxml"));

         Scene scene = new Scene(root); // attach scene graph to scene
         stage.setTitle("Tax Calculator"); // displayed in window's title bar
         stage.setScene(scene); // attach scene to stage
         stage.show(); // display the stage
      }

      public static void main(String[] args) {
         // create a TaxCalculator object and call its start method
         launch(args);
      }
   }
