package com.example.oop10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label calculatedIntervalValue;
    @FXML
    private Label calculatedTimeValue;
    @FXML
    private TextField intervalsCount;
    @FXML
    private TextField threadsCount;

    public void startCalculationHandler(ActionEvent actionEvent) {
        CalculatorInter cl = new CalculatorLogic();
        Result result = cl.calcIntegral(Integer.parseInt(intervalsCount.getText()),Integer.parseInt(threadsCount.getText()));
        calculatedIntervalValue.setText(String.valueOf(result.result()));
        calculatedTimeValue.setText(String.valueOf(result.time()));
    }
}