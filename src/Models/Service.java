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
    private String technicianName;
    private String title;
    private String description;
    private double price;
    private String serviceArea;
    
    private static String[] areas = {
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

    public Service(String technicianName,
                    String title,
                    String description,
                    double price,
                    String serviceArea) {
        this.technicianName = technicianName;
        this.title = title;
        this.description = description;
        this.price = price;
        this.serviceArea = serviceArea;
    }
}
