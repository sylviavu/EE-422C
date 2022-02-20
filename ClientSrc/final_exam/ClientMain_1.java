package final_exam;
/*
 * EE422C Final Project submission by
 * Replace <...> with your actual data.
 * Sylvia Vu
 * sav987
 * 16330
 * Spring 2020
 */



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class ClientMain_1 extends Application {

    public static Stage stage;
    public static int WIDTH = 600;
    public static int HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;                   // establish stage
        stage.setTitle("e-Hills Client 1");
        //stage.setResizable(false);
        GridPane display = new GridPane();      // create new GridPane
        startUI(display);

    }

    public static void startUI(GridPane grid){
        Scene s = new Scene(grid, WIDTH, HEIGHT);
        stage.setScene(s);      // set the scene on the stage
        stage.show();           // display the scene

        GridPane welcomePage = new GridPane();
        grid.add(welcomePage, 0, 0, WIDTH, HEIGHT);
        Welcome.welcomeUI(welcomePage);

    }


}
