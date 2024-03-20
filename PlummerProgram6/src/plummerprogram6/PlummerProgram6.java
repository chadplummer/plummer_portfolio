/*
 * Chad Plummer
 * CSCI 2010
 * Program 6
 * This program takes the code from Lab 12 and adds a canvas to the grid
 * a house is drawn on the canvas using fillRect, fillPolygon, and fillOval
 * Five windows are drawn using the drawWindow method defined within the class
 */
package plummerprogram6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

/**
 *
 * @author chad.plummer
 */
public class PlummerProgram6 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //setting up the window, intializing the button and txt fields
      BorderPane root = new BorderPane();
      root.setPadding(new Insets(10, 10, 10, 10));
      Button calculate;
      TextField loan, interest, years, payments;
      Label monthlyPayment;
      
      
      monthlyPayment = new Label("");//creating the label at the bottom
      root.setBottom(monthlyPayment);//setting the bottom of the window to show what the monthly payment is
      GridPane center = new GridPane();//initializing the structure of our window
      center.setVgap(5);
      center.setHgap(5);
      loan = new TextField("0"); //sets the default value in the following textFields to 0
      loan.setPrefWidth(150);
      interest = new TextField("0");
      interest.setPrefWidth(150);
      years = new TextField("0");
      years.setPrefWidth(150);
      payments = new TextField("0");
      payments.setPrefWidth(150);
      center.add(new Label("Chad Plummer's Rate Calculator"), 0, 0); //adding the labels to the grid
      center.add(new Label("Loan Amount"), 0, 1);
      center.add(new Label("Annual Interest Rate"), 0, 2);
      center.add(new Label("Number of Years(Loan Term)"), 0, 3);
      center.add(new Label("Payments per Year"), 0, 4);
      center.add(loan, 1, 1);//adding text fields next to corresponding labels
      center.add(interest, 1, 2);
      center.add(years, 1, 3);
      center.add(payments, 1, 4);
      calculate = new Button("Calculate"); //setting up the button
      center.add(calculate, 1, 5);
      root.setCenter(center);
      
      //set up the right pane of the grid
      GridPane right = new GridPane();
      right.setVgap(5);
      right.setHgap(5);
      
      //set up the canvas that will be drawn to
      Group rootHouse = new Group();
      Scene sceneHouse = new Scene(rootHouse);
      Canvas canvas = new Canvas(150, 150);
      GraphicsContext gc = canvas.getGraphicsContext2D();
      gc.setFill(Color.WHITE);
      gc.fillRect(0, 0, 150, 150);
      
      //draw the house using fillRect
      gc.setStroke(Color.BLACK);
      gc.setFill(Color.PERU);
      gc.fillRect(0, 50, 150, 150);
      gc.strokeRect(0, 50, 150, 150);
      
      //Draw the triangle roof using fillPolygon
      gc.setFill(Color.LIGHTSLATEGRAY);
      gc.fillPolygon(new double[]{0, 75, 150}, new double[]{50, 0, 50}, 3);
      gc.strokePolygon(new double[]{0, 75, 150}, new double[]{50, 0, 50}, 3);
      
      //draws chimney
      gc.setFill(Color.ORANGE);
      gc.fillRect(110, 5, 18, 35);
      gc.setStroke(Color.BLACK);
      gc.strokeRect(110, 5, 18, 35);
      
      //draw door
      gc.fillRect(60, 100, 30, 50);
      gc.strokeRect(60, 100, 30, 50);
      
      //draw circle in door
      gc.setFill(Color.LIGHTBLUE);
      gc.fillOval(65, 105, 20, 20);
      gc.strokeOval(65, 105, 20, 20);
      
      //call method to draw window 5 times with different coordinates
      drawWindow(15, 60, gc);
      drawWindow(15, 100, gc);
      drawWindow(60, 60, gc);
      drawWindow(105, 60, gc);
      drawWindow(105, 100, gc);
      
      //display canvas
      rootHouse.getChildren().add(canvas);
      right.add(rootHouse, 1, 4);
      
      root.setRight(right);
      
      
      
      calculate.setOnAction(new EventHandler<ActionEvent>() //creating button functionality
      {
          @Override
          public void handle(ActionEvent event)
          {
              //(P*(r/n)*Math.pow((1+(r/n)),(n*t)))/ (Math.pow((1+(r/n)),(n*t))-1)
              /**p = loan
               * r = interest
               * t = years
               * n = payments
              **/
              double P = Double.parseDouble(loan.getText());
              double r = Double.parseDouble(interest.getText());
              double t = Double.parseDouble(years.getText());
              double n = Double.parseDouble(payments.getText());
              
              double total = (P*(r/n)*Math.pow((1+(r/n)),(n*t)))/ (Math.pow((1+(r/n)),(n*t))-1);
              double roundOff = Math.round(total * 100.0)/ 100.0;
              monthlyPayment.setText("The monthly payment is $" + roundOff);
          }
      }
     );
      
      Scene scene = new Scene(root, 500, 250);
      primaryStage.setTitle("Mortgage Calculator");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    //This is the method used to draw our windows
    public void drawWindow(int x, int y, GraphicsContext gc){
        
        gc.setFill(Color.LIGHTBLUE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(x, y, 30, 30);
        gc.strokeRect(x, y, 30, 30);
    }
}
