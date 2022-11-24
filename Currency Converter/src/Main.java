
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private USD inputValue, outputValue;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        //Setting up the layout of the application through a grid pane
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(50));    //sets borders to the application window
        layout.setVgap(15);     //sets the vertical gap between elements
        layout.setHgap(50);     //sets the horizontal gap between elements

        //Adding the information labels
        Label lblFrom = new Label("Convert From:");
        GridPane.setConstraints(lblFrom,0,0);    //sets the position of the object within the grid pane
        Label lblTo = new Label("Convert To:");
        GridPane.setConstraints(lblTo, 2,0);
        Label lblInput = new Label("Amount:");
        GridPane.setConstraints(lblInput, 0,3);
        Label lblOutput = new Label("Amount:");
        GridPane.setConstraints(lblOutput, 2,3);

        layout.getChildren().addAll(lblFrom, lblTo, lblInput, lblOutput);

        //Adding the input and output text boxes
        TextField txtInput = new TextField("0.00");
        GridPane.setConstraints(txtInput, 0,4);
        TextField txtOutput = new TextField();
        txtOutput.setEditable(false);
        GridPane.setConstraints(txtOutput, 2,4);

        layout.getChildren().addAll(txtInput, txtOutput);

        //Adding the dropdown menus for selecting the currencies
        ComboBox<String> fromList =  new ComboBox<>();
        fromList.getItems().addAll("Bulgarian Leva","Chinese Yuan", "Euro",
                "Great Britain Pound", "Japanese Yen","Mexican Peso", "United States Dollar");
        GridPane.setConstraints(fromList,0,1);
        ComboBox<String> toList = new ComboBox<>();
        toList.getItems().addAll("Bulgarian Leva","Chinese Yuan", "Euro",
                "Great Britain Pound", "Japanese Yen","Mexican Peso", "United States Dollar");
        GridPane.setConstraints(toList,2,1);

        layout.getChildren().addAll(fromList, toList);

        //Adding the convert button
        Button button = new Button("Convert");
        GridPane.setConstraints(button,1,6);

        layout.getChildren().add(button);

        //Adding the event handler
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String fromCurrency = fromList.getValue();
                    String toCurrency = toList.getValue();
                    double amount = Double.parseDouble(txtInput.getText());   //converts input from string to double
                    txtOutput.setText(convert(fromCurrency, toCurrency, amount));
                }
                catch(NumberFormatException e){
                    alert("Enter a number!");
                }
                catch(NullPointerException e){
                    alert("Enter a value first!");
                }
            }
        });

        Scene scene = new Scene(layout, 580,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String convert(String fromCurrency, String toCurrency, double amount){
        if (fromCurrency == toCurrency) {
            switch (fromCurrency) {
                case "Great Britain Pound":
                    inputValue = (GBP) new GBP(amount);
                    break;
                case "Bulgarian Leva":
                    inputValue = (BGN) new BGN(amount);
                    break;
                case "Euro":
                    inputValue = (EUR) new EUR(amount);
                    break;
                case "Mexican Peso":
                    inputValue = (MXN) new MXN(amount);
                    break;
                case "Japanese Yen":
                    inputValue = (JPY) new JPY(amount);
                    break;
                case "Chinese Yuan":
                    inputValue = (CNY) new CNY(amount);
                    break;
                default:
                    inputValue = new USD(amount);
                    break;
            }
            return inputValue.toString();
        }
        else {
            switch (fromCurrency) {
                case "Great Britain Pound":
                    inputValue = (GBP) new GBP(amount);
                    break;
                case "Bulgarian Leva":
                    inputValue = (BGN) new BGN(amount);
                    break;
                case "Euro":
                    inputValue = (EUR) new EUR(amount);
                    break;
                case "Mexican Peso":
                    inputValue = (MXN) new MXN(amount);
                    break;
                case "Japanese Yen":
                    inputValue = (JPY) new JPY(amount);
                    break;
                case "Chinese Yuan":
                    inputValue = (CNY) new CNY(amount);
                    break;
                default:
                    inputValue = new USD(amount);
                    break;
            }

            inputValue.setAmountUSD(inputValue.toUSD());

            switch (toCurrency) {
                case "Great Britain Pound":
                    outputValue = (GBP) new GBP(inputValue.toGBP());
                    break;
                case "Bulgarian Leva":
                    outputValue = (BGN) new BGN(inputValue.toBGN());
                    break;
                case "Euro":
                    outputValue = (EUR) new EUR(inputValue.toEUR());
                    break;
                case "Mexican Peso":
                    outputValue = (MXN) new MXN(inputValue.toMXN());
                    break;
                case "Japanese Yen":
                    outputValue = (JPY) new JPY(inputValue.toJPY());
                    break;
                case "Chinese Yuan":
                    outputValue = (CNY) new CNY(inputValue.toCNY());
                    break;
                default:
                    outputValue = new USD(inputValue.toUSD());
                    break;
            }

            return outputValue.toString();
        }
    }

    //The method below displays a pop-up window in case the user enters incorrect input
    public void alert(String message){
        Stage alertBox = new Stage();

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(20));
        layout.setHgap(30);
        layout.setVgap(10);

        Label text = new Label(message);
        GridPane.setConstraints(text, 2,0);
        layout.getChildren().add(text);

        Scene scene = new Scene (layout, 250, 70);
        alertBox.setScene(scene);
        alertBox.show();
    }
}

