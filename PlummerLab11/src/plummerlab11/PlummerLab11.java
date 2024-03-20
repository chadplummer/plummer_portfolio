/*
 * Chad Plummer
 * CSCI 2011
 * This class sets up a canvas and draws out a soccer field. 
 */
package plummerlab11;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
/**
 *
 * @author chad.plummer
 */
public class PlummerLab11 extends Application {

    
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(450, 350);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Sets the background to orange
        gc.setFill(Color.ORANGE);
        gc.fillRect(0, 0, 450, 350);
        
        //Sets the lines to be white and slightly more thick for visibility
        gc.setLineWidth(2);
        gc.setStroke(Color.WHITE);
        
        //Draws a light green rectangle representing the soccer field
        gc.strokeRect(25, 25, 394, 295);
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(25, 25, 394, 295);
        
        //draws the lines on the field
        gc.strokeLine(225, 25, 225, 320);
        gc.strokeOval(175, 130, 100, 100);
        gc.strokeRect(25, 106.5, 54, 132);
        gc.strokeRect(365, 106.5, 54, 132);
        
        //draws the arcs for the penalty box
        gc.strokeArc(54, 121, 50, 100, 90, -180, ArcType.OPEN);
        gc.strokeArc(340, 121, 50, 100, 90, 180, ArcType.OPEN);
        
        //sets the text to white and writes out "Soccer Field" above the soccer field
        gc.setFill(Color.WHITE);
        gc.fillText("Soccer Field", 195, 20, 100);
        
        root.getChildren().add(canvas);
        primaryStage.setTitle("Soccer Field: Plummer: Lab 11: CSCI 2011");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
}
