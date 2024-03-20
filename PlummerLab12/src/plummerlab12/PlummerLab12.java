/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plummerlab12;
//These are all of the javafx features that this program utilizes
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

/**
 *
 * @author chad.plummer
 * CSCI 2011
 * LAB 12
 */
public class PlummerLab12 extends Application{

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
      
      Scene scene = new Scene(root, 450, 250);
      primaryStage.setTitle("Mortgage Calculator");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
