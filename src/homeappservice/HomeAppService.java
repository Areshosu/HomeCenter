/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappservice;

import Models.Database;
import Pages.LoginPage;
import Pages.SplashScreen;

/**
 *
 * @author sphal
 */
public class HomeAppService {
    public static LoginPage loginPage;
    public static SplashScreen splashScreen;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database.read();
        loginPage = new LoginPage();
        splashScreen = new SplashScreen();
    }
    
}
