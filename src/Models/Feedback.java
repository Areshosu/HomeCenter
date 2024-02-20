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
public class Feedback {
    private String senderEmail;
    private String receiverEmail;
    private LocalDateTime createdDateTime;
    private double rating;
    private String message;
    
    public Feedback(String senderEmail,
                        String receiverEmail,
                        LocalDateTime createdDateTime,
                        double rating,
                        String message) {
        this.receiverEmail = receiverEmail;
        this.senderEmail = senderEmail;
        this.createdDateTime = createdDateTime;
        this.rating = rating;
        this.message = message;
    }
}
