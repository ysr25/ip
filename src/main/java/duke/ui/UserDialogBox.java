package duke.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class UserDialogBox extends HBox {
    @FXML
    private Label label;

    /**
     * Creates a box displaying a message from Duke.
     *
     * @param text message to be displayed
     */
    public UserDialogBox(String text) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/UserDialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        label.setText(text);
        this.setAlignment(Pos.BOTTOM_RIGHT);
    }
}
