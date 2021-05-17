
//import java.awt.*;
//import javax.swing.*;
//
//public class main{
//    public static void main(String[] args) {
//    	
//        JButton b0 = new JButton("Not Found");     
//        JButton b1 = new JButton("In stash");     
//        JButton b2 = new JButton("Delivered");     
//        b0.setBackground(new Color(255,0,0));   
//        b1.setBackground(new Color(255,204,0));   
//        b2.setBackground(new Color(0,255,0));   
//       	
//	    JPanel item_card = new JPanel();  
//	    item_card.setBackground(new Color(255,255,255));  
//	    item_card.setSize(300,600);    
//	    item_card.setLayout(null);    
//    	item_card.add(b0,0,0);
//	    item_card.add(b1,0,1);
//	    item_card.add(b2,0,2);
//
//	    JPanel fence_container = new JPanel(); 
//	    JScrollPane fence_panel = new JScrollPane(fence_container);
//	    fence_panel.setBounds(40,80,200,600);    
//
//	    fence_panel.setBackground(new Color(51,51,51)); 
//	    
//	    fence_panel.add(item_card);
//	    
////        JButton b1 = new JButton("Button 1");     
////        b1.setBounds(50,100,80,30);    
////        b1.setBackground(Color.yellow);   
//        
////        JButton b2 = new JButton("Button 2");   
////        b2.setBounds(100,100,80,30);    
////        b2.setBackground(Color.green);  
//           	
////        JPanel panel = new JPanel();  
////        panel.setBounds(40,80,200,200);    
////        panel.setBackground(Color.gray);  
////        panel.add(b1); panel.add(b2);  
//        
//    	JFrame frame = new JFrame("Tarkov Items");    
//    	frame.add(fence_panel,0);  
//        frame.setSize(1000,800);    
//        frame.setLayout(null);    
//        frame.setVisible(true);
//        
//
//    }
//
//}

import java.awt.*;
import javax.swing.*;

public class main extends JFrame {

    // JPanel
    JPanel pnlButton = new JPanel();
    // Buttons
    JButton btnAddFlight = new JButton("Add Flight");

    public main() {
        // FlightInfo setbounds
        btnAddFlight.setBounds(60, 400, 220, 30);

        // JPanel bounds
        pnlButton.setBounds(800, 800, 200, 100);

        // Adding to JFrame
        pnlButton.add(btnAddFlight);
        add(pnlButton);

        // JFrame properties
        setSize(400, 400);
        setBackground(Color.BLACK);
        setTitle("Air Traffic Control");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new main();
    }
}
