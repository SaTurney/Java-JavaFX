// Sabrina Turney
// Week 6 - JavaFX Program 2
// Color Chooser - Changed Colors
// COP 2800 - Programming with Java
//Here is the main class for the color chooser,
//where the color chooser's main method will be handled.


   import javafx.application.Application;
   import javafx.fxml.FXMLLoader;
   import javafx.scene.Parent;
   import javafx.scene.Scene;
   import javafx.stage.Stage;

   public class ColorChooser extends Application {
      @Override
      public void start(Stage stage) throws Exception {
         Parent root =
            FXMLLoader.load(getClass().getResource("ColorChooser.fxml"));
 
         Scene scene = new Scene(root);
         stage.setTitle("Color Chooser");
         stage.setScene(scene);
         stage.show();
      }

      public static void main(String[] args) {
         launch(args);
      }
   }