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
    private static final String[] paymentOptions = {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }
    
    
}
