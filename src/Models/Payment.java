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
    private String senderEmail;
    private String receiverEmail;
    
    public Payment(double amount,
                    String paymentOption,
                    String senderEmail,
                    String receiverEmail) {
        this.amount = amount;
        this.paymentOption = paymentOption;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
    }
}
