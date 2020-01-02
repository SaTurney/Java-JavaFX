// Sabrina Turney
// Week 6 - JavaFX Program 1
// TaxCalculator - Based on Tip Calculator
// COP 2800 - Programming with Java
//Here is the Controller class for the tax calculator,
//where the slider and button controls events will be handled.


  // TaxCalculatorController.java
  // Controller that handles calculateButton and taxPercentageSlider events
  import java.math.BigDecimal;
  import java.math.RoundingMode;
  import java.text.NumberFormat;
  import javafx.beans.value.ChangeListener;
  import javafx.beans.value.ObservableValue;
  import javafx.fxml.FXML;
  import javafx.scene.control.Label;
  import javafx.scene.control.Slider;
  import javafx.scene.control.TextField;

   public class TaxCalculatorController {
      // formatters for currency and percentages
      private static final NumberFormat currency =
         NumberFormat.getCurrencyInstance();
      private static final NumberFormat percent =
         NumberFormat.getPercentInstance();

      private BigDecimal taxPercentage = new BigDecimal(0.06); // 6% default

      // GUI controls defined in FXML and used by the controller's code
      @FXML
      private TextField amountTextField;

      @FXML
      private Label taxPercentageLabel;

      @FXML
      private Slider taxPercentageSlider;

      @FXML
      private TextField taxTextField;

      @FXML
      private TextField totalTextField;

      // calculates and displays the tax and total amounts
      @FXML
    private void calculateButtonPressed() {
      try {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tax = amount.multiply(taxPercentage);
            BigDecimal total = amount.add(tax);

            taxTextField.setText(currency.format(tax));
            totalTextField.setText(currency.format(total));
         }
      catch (NumberFormatException ex) {
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
         }
      }

      // called by FXMLLoader to initialize the controller
    public void initialize() {
         // 0-4 rounds down, 5-9 rounds up
         currency.setRoundingMode(RoundingMode.HALF_UP);

         // listener for changes to tipPercentageSlider's value
         taxPercentageSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
               @Override
              public void changed(ObservableValue<? extends Number> ov,
                  Number oldValue, Number newValue) {
                  taxPercentage =
                     BigDecimal.valueOf(newValue.intValue() / 100.0);
                  taxPercentageLabel.setText(percent.format(taxPercentage));
               }
            }
         );
         
      }
   }