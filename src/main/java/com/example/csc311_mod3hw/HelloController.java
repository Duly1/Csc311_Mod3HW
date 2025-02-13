package com.example.csc311_mod3hw;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField loanAmountTextField;
    @FXML
    private TextField interestRateTextField;
    @FXML
    private TextField yearsTextField;
    @FXML
    private TextField monthlyPaymentTextField;
    @FXML
    private TextField totalPaymentTextField;

    // Event handler for Calculate button click
    @FXML
    protected void onCalculateButtonClick() {
        try {
            // Get input values from the text fields
            double loanAmount = Double.parseDouble(loanAmountTextField.getText());
            double annualInterestRate = Double.parseDouble(interestRateTextField.getText()) / 100;
            int numberOfYears = Integer.parseInt(yearsTextField.getText());

            // Calculate monthly interest rate
            double monthlyInterestRate = annualInterestRate / 12;

            // Calculate number of payments
            int numberOfPayments = numberOfYears * 12;

            // Calculate monthly payment using the formula
            double monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

            // Calculate total payment
            double totalPayment = monthlyPayment * numberOfPayments;

            // Set values in the result fields
            monthlyPaymentTextField.setText(String.format("%.2f", monthlyPayment));
            totalPaymentTextField.setText(String.format("%.2f", totalPayment));

        } catch (NumberFormatException e) {
            // Show error if user inputs invalid data
            monthlyPaymentTextField.setText("Invalid input");
            totalPaymentTextField.setText("Invalid input");
        }
    }
}
