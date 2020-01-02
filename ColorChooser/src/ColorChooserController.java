// Sabrina Turney
// Week 6 - JavaFX Program 2
// Color Chooser - Changed Colors
// COP 2800 - Programming with Java
//Here is the controller class for the color chooser,
//where the color chooser's sliders, colors, and palette will be handled.


   // Controller for the ColorChooser app
   import javafx.beans.value.ChangeListener;
   import javafx.beans.value.ObservableValue;
   import javafx.fxml.FXML;
   import javafx.scene.control.Slider;
   import javafx.scene.control.TextField;
   import javafx.scene.paint.Color;
   import javafx.scene.shape.Rectangle;

   public class ColorChooserController {
      // instance variables for interacting with GUI components
      @FXML private Slider aquaSlider;
      @FXML private Slider coralSlider;
      @FXML private Slider lavenderSlider;
      @FXML private Slider alphaSlider;
      @FXML private TextField aquaTextField;
      @FXML private TextField coralTextField;
      @FXML private TextField lavenderTextField;
      @FXML private TextField alphaTextField;
      @FXML private Rectangle colorRectangle;

      // instance variables for managing
      private int aqua = 0;
      private int coral = 0;
      private int lavender = 0;
      private double alpha = 1.0;

      public void initialize() {
         // bind TextField values to corresponding Slider values
         aquaTextField.textProperty().bind(
            aquaSlider.valueProperty().asString("%.0f"));
         coralTextField.textProperty().bind(
            coralSlider.valueProperty().asString("%.0f"));
         lavenderTextField.textProperty().bind(
            lavenderSlider.valueProperty().asString("%.0f"));
         alphaTextField.textProperty().bind(
            alphaSlider.valueProperty().asString("%.2f"));

         // listeners that set Rectangle's fill based on Slider changes
         aquaSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
               @Override
               public void changed(ObservableValue<? extends Number> ov,
                 Number oldValue, Number newValue) {
                  aqua = newValue.intValue();
                 colorRectangle.setFill(Color.rgb(aqua, coral, lavender, alpha));
               }
            }
         );
         coralSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
               @Override
               public void changed(ObservableValue<? extends Number> ov,
                  Number oldValue, Number newValue) {
                  coral = newValue.intValue();
                  colorRectangle.setFill(Color.rgb(aqua, coral, lavender, alpha));
               }
            }
         );
         lavenderSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
               @Override
              public void changed(ObservableValue<? extends Number> ov,
                  Number oldValue, Number newValue) {
                  lavender = newValue.intValue();
                  colorRectangle.setFill(Color.rgb(aqua, coral, lavender, alpha));
               }
            }
         );
         alphaSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
               @Override
               public void changed(ObservableValue<? extends Number> ov,
                  Number oldValue, Number newValue) {
                  alpha = newValue.doubleValue();
                  colorRectangle.setFill(Color.rgb(aqua, coral, lavender, alpha));
               }
            }
         );
      }
   }