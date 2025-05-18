package com.kuldeepkumar290497.level01;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionUtil {
    public static Double calculateTotalSpent(List<WebElement> transactions) {
        double spent = 0.0;
        for (WebElement txn : transactions) {
            String amount = txn.getText().replace("USD", "").replace(",", "").trim();
            if (!amount.isEmpty()) {
                double value = Double.parseDouble(amount.replace("-", "").replace("+", ""));
                if (txn.getText().contains("-")) {
                    spent += value;
                }
            }
        }
        return spent;
    }

    public static Double calculateTotalEarned(List<WebElement> transactions) {
        double earned = 0.0;
        for (WebElement txn : transactions) {
            String amount = txn.getText().replace("USD", "").replace(",", "").trim();
            if (!amount.isEmpty()) {
                double value = Double.parseDouble(amount.replace("-", "").replace("+", ""));
                if (txn.getText().contains("+")) {
                    earned += value;
                }
            }
        }
        return earned;
    }

    public static Double calculateNetTotal(List<WebElement> transactions) {
        double total = 0.0;
        for (WebElement txn : transactions) {
            String amount = txn.getText().replace("USD", "").replace(",", "").trim();
            if (!amount.isEmpty()) {
                double value = Double.parseDouble(amount.replace("-", "").replace("+", ""));
                total += value;
            }
        }
        return total;
    }
}
