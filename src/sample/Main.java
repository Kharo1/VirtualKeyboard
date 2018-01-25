package sample;

/**
 * Main.java builds the GUI
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final TextField textField = new TextField();
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("text field: " + textField.getText());
            }
        });
        //text area is not used
        final TextArea textArea = new TextArea();

        final Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("OK Button Pressed!");
            }
        });

        //cancels field from accepting input
        final Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Canceled!");
            }
        });

        //disables keyboard from accepting input
        final CheckBox disabledCheckBox = new CheckBox("Disable");

        final HBox buttons = new HBox(5);
        buttons.getChildren().addAll(okButton, cancelButton, disabledCheckBox);
        buttons.setAlignment(Pos.CENTER);

        //keyboard body dimensions
        final VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);

        VirtualKeyboard vkb = new VirtualKeyboard();

        // just add a border to easily visualize the boundary of the keyboard:
        vkb.view().setStyle("-fx-border-color: darkblue; -fx-border-radius: 5;");
        vkb.view().disableProperty().bind(disabledCheckBox.selectedProperty());

        //if textarea is to be added
        //root.getChildren().addAll(textField, buttons, vkb.view());
        root.getChildren().addAll(textField, buttons, vkb.view());

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
