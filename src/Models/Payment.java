/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author sphal
 */
public class Payment {
    private static String[] paymentOptions = {
        "Paypal",
        "Online banking fpx",
        "AloyPay",
        "Credit card",
        "Cash"
    };
    
    private double amount;
    private String paymentOption;
    private String senderName;
    private String receiverName;
    
    public Payment(double amount,
                    String paymentOption,
                    String senderName,
                    String receiverName) {
        this.amount = amount;
        this.paymentOption = paymentOption;
        this.senderName = senderName;
        this.receiverName = receiverName;
    }
}
