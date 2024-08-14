package org.academy;

import org.academy.codewars.configurations.StartupConfiguration;
import org.academy.codewars.controllers.UIController;

public class App {
    public static void main(String[] args){
        System.out.println("Welcome on board!");
        UIController ui = StartupConfiguration.initUIController();
        ui.start();
    }
}
