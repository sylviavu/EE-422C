package final_exam;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Account {

    public Stage stage = ClientMain_1.stage;

    public Account(Button b, GridPane pane){

        String textStyle = "-fx-text-fill: #000000; -fx-font-size: 115%; -fx-font-family: Beirut; ";

        pane.getChildren().clear();
        pane.setOnMouseEntered(value ->{
            b.setStyle(Style.LIGHT_YELLOW);
        });
        pane.setOnMouseExited(value ->{
            b.setStyle(Style.TAN);
        });

        GridPane accPane = new GridPane();
        accPane.setVgap(10);
        accPane.setHgap(10);

        Label userLabel = new Label("Username: ");
        userLabel.setStyle(textStyle);
        userLabel.setMinSize(100, 100);

        Label user = new Label();
        if(Login.guest){
            user.setMinSize(100, 100);
            user.setText("You are signed in as a guest");
            user.setStyle("-fx-text-fill: #cd5c5c; -fx-font-size: 115%; -fx-font-family: Beirut; ");
        }
        else{   //TODO: RETRIEVE USERNAME FROM SERVER
            user.setMinSize(100,100);
            user.setText("LMAO CHANGE THIS");
            user.setStyle(textStyle);
        }

        Button signOutButton = new Button("Sign Out");
        signOutButton.setStyle(Style.RED);
        signOutButton.setMinHeight(100);
        signOutButton.setOnMouseEntered(value ->{
            signOutButton.setStyle(Style.LIGHT_RED);
        });
        signOutButton.setOnMouseExited(value ->{
            signOutButton.setStyle(Style.RED);
        });
        signOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Login backToLogin = new Login(stage);
            }
        });

        pane.setAlignment(Pos.CENTER_LEFT);

        pane.add(userLabel, 2, 5);
        pane.add(user, 3, 5);
        pane.add(signOutButton, 10, 30);

    }
}
