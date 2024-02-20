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
public class Service {
    private String technicianEmail;
    private String title;
    private String description;
    private double price;
    private String serviceArea;
    
    private static final String[] areas = {
        "Kuala Lumpur",
        "Ipoh",
        "Malacca",
        "Kuantan",
        "Kota Bharu",
        "Putrajaya",
        "Petaling Jaya",
        "Subang Jaya",
        "Shah Alam",
        "Kuala Terengganu",
        "Kuching"
    };

    public Service(String technicianEmail,
                    String title,
                    String description,
                    double price,
                    String serviceArea) {
        this.technicianEmail = technicianEmail;
        this.title = title;
        this.description = description;
        this.price = price;
        this.serviceArea = serviceArea;
    }

    public String getTechnicianEmail() {
        return technicianEmail;
    }

    public void setTechnicianEmail(String technicianEmail) {
        this.technicianEmail = technicianEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }
    
    @Override
    public String toString() {
        return this.title;
    }
}
