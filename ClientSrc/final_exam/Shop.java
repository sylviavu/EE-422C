package final_exam;
/*
 * EE422C Final Project submission by
 * Replace <...> with your actual data.
 * Sylvia Vu
 * sav987
 * 16330
 * Spring 2020
 */

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Shop {

    public Shop(Button b, GridPane pane){

        pane.getChildren().clear();
        pane.setOnMouseEntered(value ->{
            pane.setStyle(Style.LIGHT_YELLOW);
        });
        pane.setOnMouseExited(value ->{
            pane.setStyle(Style.TAN);
        });

        GridPane itemListPane = new GridPane();


    }
}
