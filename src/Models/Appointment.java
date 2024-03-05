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
    private String customerEmail;
    private String technicianEmail;
    private LocalDateTime startingDateTime;
    private LocalDateTime endingDateTime;
    private String status;
    
    public Appointment(String serviceName,
                        String customerEmail,
                        String technicianEmail,
                        LocalDateTime startingDateTime,
                        LocalDateTime endingDateTime,
                        String status) {
        this.serviceName = serviceName;
        this.customerEmail = customerEmail;
        this.technicianEmail = technicianEmail;
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getTechnicianEmail() {
        return technicianEmail;
    }

    public void setTechnicianEmail(String technicianEmail) {
        this.technicianEmail = technicianEmail;
    }

    public LocalDateTime getStartingDateTime() {
        return startingDateTime;
    }

    public void setStartingDateTime(LocalDateTime startingDateTime) {
        this.startingDateTime = startingDateTime;
    }

    public LocalDateTime getEndingDateTime() {
        return endingDateTime;
    }

    public void setEndingDateTime(LocalDateTime endingDateTime) {
        this.endingDateTime = endingDateTime;
    }
}
