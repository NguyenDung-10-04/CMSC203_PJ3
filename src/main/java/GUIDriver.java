import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.CryptoManager;


public class GUIDriver extends Application  {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cybersecurity Encryption and Decryption");
        Label plainLabel = new Label("Enter Plain Text-String to Encrypt: ");
        TextField plainTextField = new TextField();
        plainTextField.setPrefWidth(500);

        Label plainLabel1 = new Label("Encrypted String: ");
        TextField plainTextField1 = new TextField();
        plainTextField1.setPrefWidth(500);
        Label plainLabel2 = new Label("Decrypted String: ");
        TextField plainTextField2 = new TextField();
        plainTextField2.setPrefWidth(500);
        Label plainLabel3 = new Label(" Cipher Key: ");
        TextField plainTextField3 = new TextField();
        plainTextField3.setPrefWidth(500);
        Label plainLabel4 = new Label("Bellaso Key");
        TextField plainTextField4 = new TextField();
        plainTextField4.setPrefWidth(500);
        Button button1 = new Button("Encrypt a string");
        Button button2 = new Button("Decrypt a string");
        Button button3 = new Button("Clear");
        Button button4 = new Button("Exit");
        // Grid - Scene

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        grid.add(plainLabel, 0, 0);
        grid.add(plainLabel1, 0, 1);
        grid.add(plainLabel2, 0, 2);
        grid.add(plainLabel3, 0, 3);
        grid.add(plainLabel4, 0, 4);

        grid.add(plainTextField, 1, 0);
        grid.add(plainTextField1, 1, 1);
        grid.add(plainTextField2, 1, 2);
        grid.add(plainTextField3, 1, 3);
        grid.add(plainTextField4, 1, 4);

        grid.add(button1, 0, 5);
        grid.add(button2, 1, 5);
        grid.add(button3, 0, 6);
        grid.add(button4, 1, 6);



        // Create RadioButtons for Caesar and Bellaso encryption
        RadioButton caesarRadioButton = new RadioButton("Caesar");
        RadioButton bellasoRadioButton = new RadioButton("Bellaso");

// Group the RadioButtons so only one can be selected at a time
        ToggleGroup encryptionToggleGroup = new ToggleGroup();
        caesarRadioButton.setToggleGroup(encryptionToggleGroup);
        bellasoRadioButton.setToggleGroup(encryptionToggleGroup);
        caesarRadioButton.setSelected(true); // default this radio will be chosen

        grid.add(caesarRadioButton,0,7);
        grid.add(bellasoRadioButton,1,7);



// Encrypt
        button1.setOnAction(e -> {
            try {
                String inputText = plainTextField.getText();
                String encryptedText;

                // Conditional statement to choose between Caesar and Bellaso encryption
                if (caesarRadioButton.isSelected()) {
                    int key = Integer.parseInt(plainTextField3.getText());
                    encryptedText = CryptoManager.caesarEncryption(inputText, key);
                } else if (bellasoRadioButton.isSelected()) {
                    String key3 = plainTextField4.getText();
                    encryptedText = CryptoManager.bellasoEncryption(inputText, key3);
                } else {
                    showAlert("Selection Error", "Please select an encryption method.");
                    return;
                }

                plainTextField1.setText(encryptedText);
            } catch (Exception exception) {
                showAlert("Input Error", "Please try again");
            }
        });

// Decryt
        button2.setOnAction(e -> {
            try {
                String encryptedText = plainTextField1.getText();
                String decryptedText;

                // Conditional statement to choose between Caesar and Bellaso decryption
                if (caesarRadioButton.isSelected()) {
                    int key2 = Integer.parseInt(plainTextField3.getText());
                    decryptedText = CryptoManager.caesarDecryption(encryptedText, key2);
                } else if (bellasoRadioButton.isSelected()) {
                    String key4 = plainTextField4.getText();
                    decryptedText = CryptoManager.bellasoDecryption(encryptedText, key4);
                } else {
                    showAlert("Selection Error", "Please select a decryption method.");
                    return;
                }

                plainTextField2.setText(decryptedText);
            } catch (Exception exception) {
                showAlert("Input Error", "Please try again");
            }
        });



        // clear:
        button3.setOnAction(e->{
            plainTextField.clear();
            plainTextField1.clear();
            plainTextField2.clear();
            plainTextField3.clear();
            plainTextField4.clear();

        });

        // button exit:
        button4.setOnAction(e->{
            Platform.exit(); //
        });

        Scene scene = new Scene(grid,300,500);
        stage.setScene(scene);
        stage.show();

    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
