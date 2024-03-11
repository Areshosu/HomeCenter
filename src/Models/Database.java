/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Helper.SharedHelper;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author sphal
 */
public class Database {
    private static final String dirPrefix = "Databases/";
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Service> services = new ArrayList<Service>();
    private static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    private static ArrayList<Payment> payments = new ArrayList<Payment>();
    private static ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
    
    public static void read() {
        users.clear();
        services.clear();
        appointments.clear();
        payments.clear();
        feedbacks.clear();
        
        for (String dbname: new String[]{"users", "services", "appointments", "payments", "feedbacks"}) {
            try {
            Scanner input = new Scanner(new File(getDBFolder() + dbname + ".txt"));
            while (input.hasNext()) {
                if (dbname == "users") {
                    String userName = input.nextLine();
                    String password = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String emailAddress = input.nextLine();
                    String homeAddress = input.nextLine();
                    String role = input.nextLine();
                    users.add(new User(userName, password, phoneNumber, emailAddress, homeAddress, role));
                } else if (dbname == "services") {
                    String technicianEmail = input.nextLine();
                    String serviceTitle = input.nextLine();
                    String description = input.nextLine();
                    double price = Double.parseDouble(input.nextLine());
                    String serviceArea = input.nextLine();
                    services.add(new Service(technicianEmail, serviceTitle, description, price, serviceArea));
                } else if (dbname == "appointments") {
                    String serviceName = input.nextLine();
                    String customerEmail = input.nextLine();
                    String technicianEmail = input.nextLine();
                    LocalDateTime startingDateTime = SharedHelper.isValidDateTime(input.nextLine());
                    LocalDateTime endingDateTime = SharedHelper.isValidDateTime(input.nextLine());
                    String status = input.nextLine();
                    appointments.add(new Appointment(serviceName, customerEmail, technicianEmail, startingDateTime, endingDateTime,status));
                } else if (dbname == "payments") {
                    double amount = Double.parseDouble(input.nextLine());
                    String paymentOption = input.nextLine();
                    String senderEmail = input.nextLine();
                    String receiverEmail = input.nextLine();
                    LocalDateTime paymentCreatedAt = SharedHelper.isValidDateTime(input.nextLine());
                    payments.add(new Payment(amount, paymentOption, senderEmail, receiverEmail, paymentCreatedAt));
                } else if (dbname == "feedbacks") {
                    String senderEmail = input.nextLine();
                    String receiverEmail = input.nextLine();
                    LocalDateTime createdDate = LocalDateTime.parse(input.nextLine());
                    double rating = Double.parseDouble(input.nextLine());
                    String message = input.nextLine();
                    feedbacks.add(new Feedback(senderEmail, receiverEmail, createdDate, rating, message));
                }
                input.nextLine();
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in database " + ex.getMessage());
            System.exit(0);
        }
        }
    }
    
    private static String getDBFolder() {
        return System.getProperty("user.dir") + "/src/" + dirPrefix;
    }
    
    //payments
    public static Payment[] getPayments(){
        Payment[] arrayPayment = new Payment[] {};
        return payments.toArray(arrayPayment);
    }
    
    public static Payment[] getPaymentsCustomer(String email){
        
        
        List<Payment> customerPayments = new ArrayList<>();
        for(Payment payment: payments){
            if (payment.getSenderEmail().equals(email)){
                customerPayments.add(payment);
                
            }
        }
         Payment[] paymentArray = new Payment[customerPayments.size()];
         paymentArray = customerPayments.toArray(paymentArray);
    
         return paymentArray;
    }
    
    public static void addPayment(Payment payment){
        payments.add(payment);
    }
    
    public static void writeToPayments() {
        try {
            PrintWriter output = new PrintWriter(getDBFolder() + "payments.txt");
            for (Payment payment:payments) {
                output.println(payment.getAmount());
                output.println(payment.getPaymentOption());
                output.println(payment.getSenderEmail());
                output.println(payment.getReceiverEmail());              
                output.println();
            }
            output.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Error " + ex.getMessage());
        }
    }
    
    
    
    // users
    
    public static User[] getUsers() {
        User[] arrayUser = new User[] {};
        return users.toArray(arrayUser);
    }
    
    public static User findUser(String email) {
        for (User user: users) {
            if (user.getEmailAddress().equals(email)) {
                return user;
            }
        }
        return null;
    }
    
    public static void addUser(User user) {
        users.add(user);
    }
    
    public static void updateUser(User user, int index) {
        users.set(index, user);
    }
    
    public static void updateUser(User userToUpdate, String email) {
        for(User user : users){
            if(user.getEmailAddress().equals(email)){
                user = userToUpdate;
                return;
            }
        }
    }
    
    
    public static void removeUser(String emailAddress) {
        users.removeIf(user -> user.getEmailAddress().equals(emailAddress));
    }
    
    public static void writeToUsers() {
        try {
            PrintWriter output = new PrintWriter(getDBFolder() + "users.txt");
            for (User user: users) {
                output.println(user.getUserName());
                output.println(user.getPassword());
                output.println(user.getPhoneNumber());
                output.println(user.getEmailAddress());
                output.println(user.getHomeAddress());
                output.println(user.getRole());
                output.println();
            }
            output.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Error " + ex.getMessage());
        }
    }
    
    // Services
    public static Service[] getServices(){
        Service[] arrayService = new Service[] {};
        return services.toArray(arrayService);
    }
    
    
    public static Service findService(String title){
        for (Service service: services){
            if (service.getTitle().equals(title)){
                return service;
            }
        }
        return null;
    }

    public static void addService(Service service){
        services.add(service);
    }
    
    public static void updateService(Service service, int index) {
        services.set(index, service);
    }
    
    public static void removeService(String email){
        services.removeIf(service -> service.getTechnicianEmail().equals(email) );
    }
    
    public static void writeToServices(){
        try{
            PrintWriter output = new PrintWriter(getDBFolder()+"services.txt");
            for (Service service:services){
                output.println(service.getTechnicianEmail());
                output.println(service.getTitle());
                output.println(service.getDescription());
                output.println(service.getPrice());
                output.println(service.getServiceArea());
                output.println();
            }
            output.close();
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Database Error " + ex.getMessage());
        }
    }

    // feedbacks
    public static Feedback[] getFeedbacks() {
        Feedback[] arrayFeedbacks = new Feedback[] {};
        return feedbacks.toArray(arrayFeedbacks);
    }
    
    // appointments
    public static Appointment[] getAppointments() {
        Appointment[] arrayAppointments = new Appointment[] {};
        return appointments.toArray(arrayAppointments);
    }
    
    public static Appointment[] findAppointmentsCustomer(String email){
        
        List<Appointment> customerAppointments = new ArrayList<>();
        for(Appointment appointment: appointments){
            if (appointment.getCustomerEmail().equals(email)){
                customerAppointments.add(appointment);
                
            }
        }
         Appointment[] appointmentsArray = new Appointment[customerAppointments.size()];
         appointmentsArray = customerAppointments.toArray(appointmentsArray);
    
         return appointmentsArray;
    }
    
    public static Appointment[] findAppointmentsTechnician(String email){
        
        List<Appointment> technicianAppointments = new ArrayList<>();
        for(Appointment appointment: appointments){
            if (appointment.getTechnicianEmail().equals(email)){
                technicianAppointments.add(appointment);   
            }
        }
         Appointment[] appointmentsArray = new Appointment[technicianAppointments.size()];
         appointmentsArray = technicianAppointments.toArray(appointmentsArray);
         return appointmentsArray;
    }
    
    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    
    public static void updateAppointment(Appointment appointment, int index) {
        appointments.set(index, appointment);
    }
    
    public static void removeAppointment(int index) {
        appointments.remove(index);
    }
    
    public static void writeToAppointments() {
        try {
            PrintWriter output = new PrintWriter(getDBFolder() + "appointments.txt");
            for (Appointment appointment: appointments) {
                output.println(appointment.getServiceName());
                output.println(appointment.getCustomerEmail());
                output.println(appointment.getTechnicianEmail());
                output.println(SharedHelper.dateToString(appointment.getStartingDateTime()));
                output.println(SharedHelper.dateToString(appointment.getEndingDateTime()));
                output.println(appointment.getStatus());
                output.println();
            }
            output.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Error " + ex.getMessage());
        }
    }

    

}
