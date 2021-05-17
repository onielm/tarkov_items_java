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

    Color notFoundColor = new Color(255,51,51);
    Color inStashColor = new Color(255,255,51);
    Color turnedInColor = new Color(51,255,51);
    
	JPanel back_panel = new JPanel();

    JFrame frame = new JFrame();
	final JScrollPane scroll = new JScrollPane(back_panel);


    public tarkov_items() throws IOException {
			Integer cardWidth = 350;
			
		back_panel.setBackground(new Color(0,0,0));
		back_panel.setLayout(null);
		back_panel.setPreferredSize(new Dimension(8*(cardWidth+40), 1000));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(2500, 1000);
		frame.setTitle("Tarkov in Raid Items");
//		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setLayout(new BorderLayout());
		frame.add(scroll, BorderLayout.CENTER);
		frame.setSize(1000, 600);
		
        String[] traders = {"Prapor", "Therapist", "Fence", "Skier", 
        					"Peacekeeper","Mechanic","Ragman", "Jaeger"};
        Integer panel_x = 50;
        Integer panel_y = 50;
        for (String trader : traders) 
        { 
        	// Buttons
//  			JButton btnNotFound = new JButton("Not Found");
        	
            JButton btnNotFound = new JButton("Not Found");
            JButton btnInStash = new JButton("In Stash");
            JButton btnTurnedIn = new JButton("Turned In");

  			btnNotFound.setBackground(notFoundColor);
  			btnNotFound.setBounds(5, 5, 100, 30);
  			btnNotFound.addActionListener(new ActionListener() { 
	  			public void actionPerformed(ActionEvent e) { 
	  				SetItemStatus(btnNotFound); }
	  			public void SetItemStatus(Container container) {
  		    		container.getParent().setBackground(notFoundColor);
	  				return;
	  			}
  			} );
  			btnNotFound.setLayout(null);
  			
//  			JButton btnInStash = new JButton("In Stash");
  			btnInStash.setBackground(inStashColor);
  			btnInStash.setBounds(5, 35, 100, 30);
  			btnInStash.addActionListener(new ActionListener() { 
	  			public void actionPerformed(ActionEvent e) { 
  					SetItemStatus(btnInStash); }
	  			public void SetItemStatus(Container container) {
  		    		container.getParent().setBackground(inStashColor);
	  				return;
	  			}
  			} );
  			btnInStash.setLayout(null);

//  			JButton btnTurnedIn = new JButton("TurnedIn");
  			btnTurnedIn.setBackground(turnedInColor);
  			btnTurnedIn.setBounds(5, 65, 100, 30);
  			btnTurnedIn.addActionListener(new ActionListener() { 
	  			public void actionPerformed(ActionEvent e) { 
	  				SetItemStatus(btnTurnedIn); }
	  			public void SetItemStatus(Container container) {
  		    		container.getParent().setBackground(turnedInColor);
	  				return;
	  			}
  			} );
  			btnTurnedIn.setLayout(null);
  			
  			//vendor image
  			

  			
  			
  			
//  			System.out.println("Working Directory = " + System.getProperty("user.dir"));
//  			BufferedImage img = ImageIO.read(new File("src/images/fence/Fence_Portrait.webp"));
//  			JLabel vendorImg = new JLabel(new ImageIcon(img));
//  			btnTurnedIn.setBounds(5, 65, 50, 50);
//  			btnTurnedIn.setLayout(null);

  			
  			//item image
  			
  			
  			// item card panel
  			JPanel item_card = new JPanel();
  			item_card.setBackground(notFoundColor);
  			item_card.setBounds(5, 70, cardWidth, 100);
  			item_card.setLayout(null);
  			item_card.setPreferredSize(new Dimension(800, 600));
  			
  			Integer itemImageSize = item_card.getHeight() - 10;
  			String item_image = "/images/fence/Pestily_plague_mask.jpg";
  			ImageIcon item_icon = LoadImageIcon(item_image,itemImageSize);
  			JLabel itemImg = new JLabel();
  			itemImg.setIcon(item_icon);
  			itemImg.setBounds(btnTurnedIn.getWidth()+10,5, itemImageSize, itemImageSize);
  			itemImg.setLayout(null);
  			itemImg.setVisible(true);

  			Integer itemAmount = 1;
  			JLabel itemTextBox = new JLabel("<html>"+ itemAmount.toString() + "x<br>Pestily plague mask" +"</html>");
  			itemTextBox.setBounds(15+btnTurnedIn.getWidth()+itemImg.getWidth(),
  									5, 
  									cardWidth - 20 - btnTurnedIn.getWidth() - itemImg.getWidth(),
  									2*item_card.getHeight()/3-5);
  			itemTextBox.setFont(new Font("Arial", Font.PLAIN, 12));
  			itemTextBox.setForeground(new Color(255,255,255));
  			itemTextBox.setOpaque(true);
  			itemTextBox.setBackground(new Color(81,81,81,155));
  			itemTextBox.setLayout(null);
  			itemTextBox.setVisible(true);
  			
  			//craft label
  			Integer craftIconSize = item_card.getHeight()/3-9;
  			String craft_image = "/images/tools.png";
  			ImageIcon craft_icon = LoadImageIcon(craft_image,craftIconSize);
  			JLabel craftImg = new JLabel();
  			craftImg.setIcon(craft_icon);
  			craftImg.setBounds(15+btnTurnedIn.getWidth()+itemImg.getWidth(),
  							11 + itemImg.getWidth()/3*2, 
  								craftIconSize, 
  								craftIconSize);
  			craftImg.setLayout(null);
  			craftImg.setBackground(new Color(81,81,81,155));
  			craftImg.setVisible(true);
  			//craft text
  			JLabel craftableLabel = new JLabel("<html><b><span style='text-align: center;'>"
  											+ "CRAFTABLE</span></b></html>");
  			craftableLabel.setBounds(15+btnTurnedIn.getWidth()+itemImg.getWidth()+craftIconSize,
  								11 + itemImg.getWidth()/3*2, 
  								30+(cardWidth - 20 - btnTurnedIn.getWidth() - itemImg.getWidth())/3,
  								item_card.getHeight()/3-9);
  			craftableLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			craftableLabel.setForeground(new Color(255,255,255));
			craftableLabel.setOpaque(true);
  			craftableLabel.setBackground(new Color(81,81,81,155));
  			craftableLabel.setLayout(null);
			craftableLabel.setVisible(true);
  			
  		
  			//kappa label
//  			JLabel kappaLabel = new JLabel("<html><b><span style='text-decoration: line-through;text-align: center;'>"
//  								+ "KAPPA</span></b></html>");
//  			kappaLabel.setBounds(20+btnTurnedIn.getWidth()+itemImg.getWidth()+craftableLabel.getWidth(),
//  								11 + itemImg.getWidth()/3*2, 
//  								(cardWidth - 20 - btnTurnedIn.getWidth() - itemImg.getWidth())/3,
//  								item_card.getHeight()/3-9);
//  			kappaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
//  			kappaLabel.setForeground(new Color(255,255,255));
//  			kappaLabel.setOpaque(true);
//  			kappaLabel.setBackground(new Color(81,81,81,155));
//  			kappaLabel.setLayout(null);
//  			kappaLabel.setVisible(true);
  			Integer kappaIconSize = item_card.getHeight()/3-9;
  			String kappa_image = "/images/not_kappa.png";
  			ImageIcon kappa_icon = LoadImageIcon(kappa_image,kappaIconSize);
  			JLabel kappaImg = new JLabel();
  			kappaImg.setIcon(kappa_icon);
  			kappaImg.setBounds(cardWidth-5 - kappaIconSize,
  							11 + itemImg.getWidth()/3*2, 
  								kappaIconSize, 
  								kappaIconSize);
  			kappaImg.setLayout(null);
  			kappaImg.setVisible(true);
  			// JPanel
  			JPanel fence_panel = new JPanel();
  			fence_panel.setBackground(new Color(51,51,51));
  			fence_panel.setBounds(panel_x, panel_y, cardWidth+10, 300);
  			fence_panel.setLayout(null);
  			fence_panel.setPreferredSize(new Dimension(800, 600));
  			
  			//vendor image; goes over panel
  			Integer vendorImageSize = 60;
  			String vendor_image = "/images/fence/Fence_Portrait.jpg";
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

  			

  			

  			
      		//add
      		item_card.add(btnNotFound);
      		item_card.add(btnInStash);
      		item_card.add(btnTurnedIn);
      		item_card.add(itemImg);
      		item_card.add(itemTextBox);
      		item_card.add(craftImg);
      		item_card.add(kappaImg);
      		fence_panel.add(vendorImg);
      		fence_panel.add(vendorName);
      		fence_panel.add(item_card);
      		back_panel.add(fence_panel);
            panel_x = panel_x + cardWidth + 20;
        }
        
		frame.setVisible(true);

    }
    
//	public void SetItemStatus(Container container) {
//    	if(container == btnNotFound) {
//    		container.getParent().setBackground(notFoundColor);
//    	}
//    	else if(container == btnInStash) {
//    		container.getParent().setBackground(inStashColor);
//    	}
//    	else if(container == btnTurnedIn) {
//    		container.getParent().setBackground(turnedInColor);
//    	}
//		return;
//	}
	
	//load an image and resize it
	protected ImageIcon LoadImageIcon(String path, Integer newSquareSize) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(newSquareSize, newSquareSize,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
	}
	
//	protected ImageIcon createImageIcon(String path,
//    			String description) {
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
