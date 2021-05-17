import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.*;

public class tarkov_items {
	
    JButton btnNotFound = new JButton("Not Found");
    JButton btnInStash = new JButton("In Stash");
    JButton btnTurnedIn = new JButton("Turned In");

    Color notFoundColor = new Color(255,51,51);
    Color inStashColor = new Color(255,255,51);
    Color turnedInColor = new Color(51,255,51);
    

    public tarkov_items() throws IOException {
    	// Buttons
//        JButton btnNotFound = new JButton("Not Found");
        btnNotFound.setBackground(notFoundColor);
        btnNotFound.setBounds(5, 5, 100, 30);
        btnNotFound.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				SetItemStatus(btnNotFound); } } );
        btnNotFound.setLayout(null);
        
//        JButton btnInStash = new JButton("In Stash");
        btnInStash.setBackground(inStashColor);
        btnInStash.setBounds(5, 35, 100, 30);
        btnInStash.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
					SetItemStatus(btnInStash); } } );
        btnInStash.setLayout(null);

//        JButton btnTurnedIn = new JButton("TurnedIn");
        btnTurnedIn.setBackground(turnedInColor);
        btnTurnedIn.setBounds(5, 65, 100, 30);
        btnTurnedIn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				SetItemStatus(btnTurnedIn); } } );
        btnTurnedIn.setLayout(null);
        
        //vendor image
        

        
        
        
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
//        BufferedImage img = ImageIO.read(new File("src/images/fence/Fence_Portrait.webp"));
//        JLabel vendorImg = new JLabel(new ImageIcon(img));
//        btnTurnedIn.setBounds(5, 65, 50, 50);
//        btnTurnedIn.setLayout(null);

        
        //item image
        
        
        // item card panel
        Integer cardWidth = 300;
        JPanel item_card = new JPanel();
        item_card.setBackground(notFoundColor);
        item_card.setBounds(5, 70, cardWidth, 100);
        item_card.setLayout(null);
        item_card.setPreferredSize(new Dimension(800, 600));
        
        Integer itemImageSize = item_card.getHeight()-10;
        String item_image = "images\\fence\\Pestily_plague_mask.jpg";
        ImageIcon item_icon = LoadImageIcon(item_image,itemImageSize);
        

        JLabel itemImg = new JLabel();
        itemImg.setIcon(item_icon);
        itemImg.setBounds(btnTurnedIn.getWidth()+10,5, itemImageSize, itemImageSize);
        
        itemImg.setLayout(null);
        itemImg.setVisible(true);
        
        
        // JPanel
        JPanel fence_panel = new JPanel();
        fence_panel.setBackground(new Color(51,51,51));
        fence_panel.setBounds(50, 50, cardWidth+10, 300);
        fence_panel.setLayout(null);
        fence_panel.setPreferredSize(new Dimension(800, 600));
        
        //vendor image; goes over panel
        Integer vendorImageSize = 60;
        String vendor_image = "images\\fence\\Fence_Portrait.jpg";
        ImageIcon vendor_icon = LoadImageIcon(vendor_image,vendorImageSize);
        
        JLabel vendorImg = new JLabel();
        vendorImg.setIcon(vendor_icon);
        vendorImg.setBounds(fence_panel.getWidth()-vendorImageSize-5, 5, vendorImageSize, vendorImageSize);
        
        vendorImg.setLayout(null);
        vendorImg.setVisible(true);

        JLabel vendorName = new JLabel("Fence", SwingConstants.CENTER);
        vendorName.setBounds(0,0, (fence_panel.getWidth()-vendorImageSize), 100);
        vendorName.setFont(new Font("Arial", Font.PLAIN, 32));
        vendorName.setForeground(new Color(255,255,255));
        vendorName.setLayout(null);
        vendorName.setVisible(true);

        
        // 
        JPanel back_panel = new JPanel();
        back_panel.setBackground(new Color(0,0,0));
        back_panel.setLayout(null);
		back_panel.setPreferredSize(new Dimension(2500, 1000));

        
        final JScrollPane scroll = new JScrollPane(back_panel);

        
        // JFrame properties
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(2500, 1000);
        frame.setTitle("Tarkov in Raid Items");
//        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    	frame.setLayout(null);
    	
        frame.setLayout(new BorderLayout());
        frame.add(scroll, BorderLayout.CENTER);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        
        //add
    	item_card.add(btnNotFound);
    	item_card.add(btnInStash);
    	item_card.add(btnTurnedIn);
    	item_card.add(itemImg);
    	fence_panel.add(vendorImg);
    	fence_panel.add(vendorName);
//        item_card.add(itemImg);
        fence_panel.add(item_card);
        back_panel.add(fence_panel);
//        scroll.add(back_panel);
//        frame.add(scroll);
        
        
    }
    
	public void SetItemStatus(Container container) {
    	if(container == btnNotFound) {
    		container.getParent().setBackground(notFoundColor);
    	}
    	else if(container == btnInStash) {
    		container.getParent().setBackground(inStashColor);
    	}
    	else if(container == btnTurnedIn) {
    		container.getParent().setBackground(turnedInColor);
    	}
		return;
	}
	
	protected ImageIcon LoadImageIcon(String path, Integer newSquareSize) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(newSquareSize, newSquareSize,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
	}
	
//	protected ImageIcon createImageIcon(String path,
//            String description) {
//		java.net.URL imgURL = getClass().getResource(path);
//		if (imgURL != null) {
//			return new ImageIcon(imgURL, description);
//		} else {
//			System.err.println("Couldn't find file: " + path);
//			return null;
//		}
//	}
	public static void main(String[] args) throws IOException {
        new tarkov_items();
    }
}
