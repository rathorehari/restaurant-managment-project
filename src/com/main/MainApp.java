package com.main;

import com.admin.MenuList;
import com.info.*;

public class MainApp {
    public static void main(String[] args) {
    	
    	Welcome w = new Welcome();
    	w.welcomePage();
        MenuList menu = new MenuList();
        menu.runMenu();
    }
}
