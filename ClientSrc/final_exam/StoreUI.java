package final_exam;
/*
 * EE422C Final Project submission by
 * Replace <...> with your actual data.
 * Sylvia Vu
 * sav987
 * 16330
 * Spring 2020
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StoreUI {

    public static Stage stage;
    public static Scene storeScene;
    public static int STORE_WIDTH = 700;
    public static int STORE_HEIGHT = 600;

    public StoreUI(Stage s){
        stage = s;
        GridPane controls = new GridPane();
        createUI(controls);
        storeScene = new Scene(controls, STORE_WIDTH, STORE_HEIGHT);
        stage.setScene(storeScene);
    }


    public static void createUI(GridPane controls){

        GridPane shopBackground = new GridPane();

        VBox selections = new VBox();
        selections.setPrefSize(STORE_WIDTH/5, STORE_HEIGHT);
        selections.setStyle("-fx-background-color: #ffffe0 ");

        VBox shopPane = new VBox(shopBackground);
        shopPane.setPrefSize((STORE_WIDTH/5)*4, STORE_HEIGHT);
        shopPane.setStyle("-fx-background-color: #ffffe0 ");

        Button shopButton = new Button("Shop");
        shopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                shopInterface(shopButton, shopBackground);
            }
        });
        HBox shopHBox = createHBox(shopButton);

        Button historyButton = new Button("History");
        historyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                historyInterface(historyButton, shopBackground);
            }
        });
        HBox historyHBox = createHBox(historyButton);

        Button accountButton = new Button("Account");
        accountButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                accountInterface(accountButton, shopBackground);
            }
        });
        HBox accountHBox = createHBox(accountButton);

        selections.getChildren().add(shopHBox);
        selections.getChildren().add(historyHBox);
        selections.getChildren().add(accountHBox);

        controls.add(selections, 0, 0);
        controls.add(shopPane, 1, 0, (STORE_WIDTH/5*4), STORE_HEIGHT);



    }

    public static HBox createHBox(Button b){
        Pane edgePane = new Pane();
        edgePane.setMinSize(STORE_WIDTH/10, STORE_HEIGHT/3);

        HBox selectionBox = new HBox(b);
        selectionBox.setMinSize(STORE_WIDTH/5, STORE_HEIGHT/3);
        b.setStyle(Style.TAN);
        b.setMinSize(STORE_WIDTH/10, STORE_HEIGHT/3);
        b.setOnMouseClicked(value ->{
            b.setStyle(Style.LIGHT_YELLOW);
        });
        b.setOnMouseEntered(value ->{
            b.setStyle(Style.LIGHT_YELLOW);
        });
        b.setOnMouseExited(value ->{
            b.setStyle(Style.TAN);
        });

        return selectionBox;
    }

    public static void shopInterface(Button b, GridPane background){
        Shop shop = new Shop(b, background);
    }

    public static void historyInterface(Button b, GridPane background){
        History history = new History(b, background);
    }

    public static void accountInterface(Button b, GridPane background){
        Account account = new Account(b, background);
    }

}
