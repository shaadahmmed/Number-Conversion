import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
    @FXML
    private Label resultLabel;
    @FXML
    private Label secondScreenLabel;
    @FXML
    private Group calculatorGroup;
    @FXML
    private Group secondPage;

    @FXML
    private TextField inputTextField;

    private int decimalNumber;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // inputTextField.setText("");
        resultLabel.setText("No Input Detected");
        decimalNumber = 0;
    }

    @FXML
    public void binary() {
        String value = inputTextField.getText();
        if (value.isBlank() || value.isEmpty()) {
            resultLabel.setText("Please Enter a number");
            return;
        }
        if (isNumber(value)) {
            decimalNumber = Integer.parseInt(value);
            String binary = "";
            while (decimalNumber != 0) {
                binary += decimalNumber % 2;
                decimalNumber /= 2;
            }
            resultLabel.setText(reverseString(binary));
            return;
        }
        if (isDouble(value)) {
            resultLabel.setText("Integer Numbers Only");
        } else {
            resultLabel.setText("Provide a Integer Number");
        }
    }

    @FXML
    public void octal() {
        String value = inputTextField.getText();
        if (value.isBlank() || value.isEmpty()) {
            resultLabel.setText("Please Enter a number");
            return;
        }
        if (isNumber(value)) {
            decimalNumber = Integer.parseInt(value);
            String octal = "";
            while (decimalNumber != 0) {
                octal += decimalNumber % 8;
                decimalNumber /= 8;
            }
            resultLabel.setText(reverseString(octal));
            return;
        }
        if (isDouble(value)) {
            resultLabel.setText("Integer Numbers Only");
        } else {
            resultLabel.setText("Provide a Integer Number");
        }

    }

    @FXML
    public void hexadecimal() {
        String value = inputTextField.getText();
        if (value.isBlank() || value.isEmpty()) {
            resultLabel.setText("Please Enter a number");
            return;
        }
        if (isNumber(value)) {
            decimalNumber = Integer.parseInt(value);
            String hex = "";
            while (decimalNumber != 0) {
                int temp = decimalNumber % 16;
                switch (temp) {
                    case 10:
                        hex += 'A';
                        break;
                    case 11:
                        hex += 'B';
                        break;
                    case 12:
                        hex += 'C';
                        break;
                    case 13:
                        hex += 'D';
                        break;
                    case 14:
                        hex += 'E';
                        break;
                    case 15:
                        hex += 'F';
                        break;
                    default:
                        hex += temp;
                        break;
                }
                decimalNumber /= 16;
            }
            resultLabel.setText(reverseString(hex));
            return;
        }
        if (isDouble(value)) {
            resultLabel.setText("Integer Numbers Only");
        } else {
            resultLabel.setText("Provide a Integer Number");
        }
    }

    @FXML
    public void nextPage() {
        calculatorGroup.setVisible(false);
        secondPage.setVisible(true);
    }

    @FXML
    public void previousPage() {
        inputTextField.setText("");
        resultLabel.setText("No Input Detected");
        calculatorGroup.setVisible(true);
        secondPage.setVisible(false);
    }

    @FXML
    public void clear() {
        inputTextField.setText("");
        resultLabel.setText("No Input Detected");
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String reverseString(String string) {
        StringBuilder reverse = new StringBuilder(string);
        reverse.reverse();
        return reverse.toString();
    }
}
