// PhamQuocCuong - 20225604
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            System.out.println("Loading FXML...");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Painter.fxml")));
            System.out.println("FXML loaded successfully.");
            Scene scene = new Scene(root);
            stage.setTitle("Painter");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}