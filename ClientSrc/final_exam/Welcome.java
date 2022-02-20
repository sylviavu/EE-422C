package final_exam;
/*
 * EE422C Final Project submission by
 * Replace <...> with your actual data.
 * Sylvia Vu
 * sav987
 * 16330
 * Spring 2020
 */

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Welcome {

    public static Stage stage = ClientMain_1.stage;

    public static void welcomeUI(GridPane grid){

        Pane background = new Pane();       // create the background
        background.setStyle("-fx-background-color: #ffffe0 ");      // set background to LIGHT_YELLOW
        background.setMinSize(ClientMain_1.WIDTH, ClientMain_1.HEIGHT);     // background is 600x600

        Label welcomeLabel = new Label("Welcome to e-Hills!");
        welcomeLabel.setMinSize(100, 100);
        welcomeLabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 185%; -fx-font-family: Beirut; ");

        Label welcomePrompt = new Label("Click below to enter!");
        welcomePrompt.setMinSize(250, 200);
        welcomePrompt.setStyle("-fx-text-fill: #000000; -fx-font-size: 185%; -fx-font-family: Beirut; ");

        Button entranceButton = new Button("Enter");
        entranceButton.setMinHeight(150);
        entranceButton.setStyle(Style.GRAY);
        entranceButton.setOnMouseEntered(value ->{
            entranceButton.setStyle(Style.GHOSTWHITE);
        });
        entranceButton.setOnMouseExited(value ->{
            entranceButton.setStyle(Style.GRAY);
        });
        entranceButton.setOnAction(value ->{
            Login newLogin = new Login(stage);
        });

        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);

        //grid.add(background, 0, 0, ClientMain_1.WIDTH, ClientMain_1.HEIGHT);
        grid.add(welcomeLabel, 0, 1);
        grid.add(welcomePrompt, 0, 2);
        grid.add(entranceButton, 0, 3);
    }


}
