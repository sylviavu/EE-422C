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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Login {

    public static Stage stage;
    public static Scene loginScene;
    GridPane loginGridPane;
    public static boolean guest = false;

    public Login(Stage s){
        stage = s;
        loginGridPane = new GridPane();
        loginUI(loginGridPane);
        loginScene = new Scene(loginGridPane, ClientMain_1.WIDTH, ClientMain_1.HEIGHT);
        stage.setScene(loginScene);
    }

    public static void loginUI(GridPane pane){
        //GridPane loginPane = new GridPane();


        Shape loginBackground = new Rectangle(ClientMain_1.WIDTH, ClientMain_1.HEIGHT);
        Label usernameLabel = new Label("Username:");
        usernameLabel.setMinSize(150, 100);
        usernameLabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 185%; -fx-font-family: Beirut; ");

        Label loginBanner = new Label("e-Hills Login");
        loginBanner.setMinSize(300, 200);
        loginBanner.setStyle("-fx-text-fill: #000000; -fx-font-size: 185%; -fx-font-family: Beirut; ");

        Label passwordLabel = new Label("Password:");
        passwordLabel.setMinSize(150, 100);
        passwordLabel.setStyle("-fx-text-fill: #000000; -fx-font-size: 185%; -fx-font-family: Beirut; ");

        TextField usernameIn = new TextField();
        usernameIn.setMinSize(200, 100);

        TextField passwordIn = new TextField();
        passwordIn.setMinSize(200,100);

        Button guestButton = new Button("Continue as a guest");
        guestButton.setMinHeight(100);
        guestButton.setStyle(Style.GRAY);
        guestButton.setOnMouseEntered(value ->{
            guestButton.setStyle(Style.GHOSTWHITE);
        });
        guestButton.setOnMouseExited(value ->{
            guestButton.setStyle(Style.GRAY);
        });
        guestButton.setOnAction(value ->{
            StoreUI s = new StoreUI(stage);
            //guest = true;
        });

        Button loginButton = new Button("Log In");
        loginButton.setMinHeight(100);
        loginButton.setStyle(Style.GRAY);
        loginButton.setOnMouseEntered(value ->{
            loginButton.setStyle(Style.GHOSTWHITE);
        });
        loginButton.setOnMouseExited(value ->{
            loginButton.setStyle(Style.GRAY);
        });
        /**
         * TODO: CHANGE WINDOW TO ENTER STORE
         */

        pane.setVgap(5);
        pane.setHgap(5);
        pane.setAlignment(Pos.CENTER);

        pane.add(usernameLabel, 0, 0);
        pane.add(usernameIn, 1, 0);
        pane.add(passwordLabel, 0, 1);
        pane.add(passwordIn, 1, 1);
        pane.add(guestButton, 0, 2);
        pane.add(loginButton, 1, 2);
    }





}
