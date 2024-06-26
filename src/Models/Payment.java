/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDateTime;

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
    private LocalDateTime paymentCreatedAt;
    
    public Payment(double amount,
                    String paymentOption,
                    String senderEmail,
                    String receiverEmail,
                    LocalDateTime paymentCreatedAt) {
        this.amount = amount;
        this.paymentOption = paymentOption;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.paymentCreatedAt = paymentCreatedAt;
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

    public LocalDateTime getPaymentCreatedAt() {
        return paymentCreatedAt;
    }

    public void setPaymentCreatedAt(LocalDateTime paymentCreatedAt) {
        this.paymentCreatedAt = paymentCreatedAt;
    }
}
