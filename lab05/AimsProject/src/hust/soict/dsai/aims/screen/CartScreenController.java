// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartScreenController {
    private Cart cart;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media,Float> colMediaCost;
    @FXML
    private Label totalPrice;
    @FXML
    private ToggleGroup sortCategory;
    @FXML
    private RadioButton radioBtnSortCost;
    @FXML
    private RadioButton radioBtnSortTitle;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnRemove.setOnAction(event -> {
            try {
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                cart.removeMedia(media);
                totalPrice.setText(cart.totalCost() + "$");
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: No media in cart to remove", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        tfFilter.textProperty().addListener((observableValue, s, t1) -> showFilterMedia(t1));

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, media, t1) -> updateButtonBar(t1)
        );
        totalPrice.setText(cart.totalCost() + "$");

        btnPlay.setOnAction(event -> {
            try {
                JDialog playDialog = MediaStore.createPlayDialog(tblMedia.getSelectionModel().getSelectedItem());
                playDialog.setVisible(true);
                playDialog.setSize(300, 200);
                playDialog.pack();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnPlaceOrder.setOnAction(event -> {
            createPopUp();
            cart.getItemsOrdered().clear();
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            totalPrice.setText(cart.totalCost() + "$");
        });

        sortCategory.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == radioBtnSortCost) {
                cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
            } else if (newValue == radioBtnSortTitle) {
                cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
            }
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
        });
    }

    @FXML
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    void showFilterMedia(String t1) {
        if (t1 == null || t1.trim().isEmpty()) {
            tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            return;
        }

        List<Media> filteredList = new ArrayList<>();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().toLowerCase().contains(t1.toLowerCase())) {
                filteredList.add(media);
            } else if (radioBtnFilterId.isSelected() && String.valueOf(media.getId()).contains(t1)) {
                filteredList.add(media);
            }
        }
        tblMedia.setItems(FXCollections.observableList(filteredList));
    }

    @FXML
    void createPopUp() {
        Stage popUpWindow =new Stage();
        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Place order");

        Label label1 = new Label("Cuong PQ 5604: You have place your order !");
        label1.setFont(Font.font("Arial", FontWeight.BOLD,14));
        Label label2 = new Label("Cuong PQ 5604: Your bill total is " + cart.totalCost() + "$");
        Button button1= new Button("OK !");
        label2.setTextFill(Color.RED);
        button1.setOnAction(e -> popUpWindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2,button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 200);
        popUpWindow.setScene(scene1);
        popUpWindow.show();
    }
}