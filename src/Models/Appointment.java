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
public class Appointment {
    private String serviceName;
    private LocalDateTime startingDateTime;
    private LocalDateTime endingDateTime;
    
    public Appointment(String serviceName,
                        LocalDateTime startingDateTime,
                        LocalDateTime endingDateTime) {
        this.serviceName = serviceName;
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
    }
}
