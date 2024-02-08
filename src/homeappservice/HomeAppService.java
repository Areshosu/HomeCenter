/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeappservice;

import Models.Database;
import Pages.MainMenuPage;

/**
 *
 * @author sphal
 */
public class HomeAppService {
    public static MainMenuPage mainPage;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database.read();
        mainPage = new MainMenuPage();
    }
    
}
