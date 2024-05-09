// @author Maningas_Arnel
package orderingsystem;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import javax.swing.border.Border;

public class OrderingSystem {

    //Main Class
    public static void main(String[] args) {
       SupplyCatalog supply = new SupplyCatalog();
       //Calls on the LogIn frame with the supply class
       new LogIn(supply);
       //new MainPage(supply);
       //SupplyCatalog obj = new SupplyCatalog();
    }
    
}
