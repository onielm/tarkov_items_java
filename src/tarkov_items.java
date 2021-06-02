import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class tarkov_items {

    Color notFoundColor = new Color(255,51,51);
    Color inStashColor = new Color(255,255,51);
    Color turnedInColor = new Color(51,255,51);
    
	JPanel back_panel = new JPanel();

    JFrame frame = new JFrame();
	final JScrollPane scroll = new JScrollPane(back_panel);


    public tarkov_items() throws IOException, ParseException {
		Integer cardWidth = 350;
		Integer most_items = -1;
		Integer card_and_space_size_y = -1;
		Integer item_card_position_y = 70;

		back_panel.setBackground(new Color(0,0,0));
		back_panel.setLayout(null);
		back_panel.setPreferredSize(new Dimension(8*(cardWidth+40), 1000));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tarkov in Raid Items");
		frame.setLayout(null);
		frame.setLayout(new BorderLayout());
		frame.add(scroll, BorderLayout.CENTER);
		frame.setSize(1000, 600);
		

		
		///
		//load hashmap
		
		String map_file = "./tarkov_items_data.txt";
				
		Map<String, String> ldapContent = new HashMap<String, String>();
		Properties properties = new Properties();
		properties.load(new FileInputStream(map_file));

		for (String key : properties.stringPropertyNames()) {
		   ldapContent.put(key, properties.get(key).toString());
		}
		///
		
		
        System.out.println(ldapContent);

		String file = "images/data.json";

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
		JSONParser jsonParser = new JSONParser();
		JSONObject jo = (JSONObject)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));

        String[] traders = {"Prapor", "Therapist", "Fence", "Skier", 
        					"Peacekeeper","Mechanic","Ragman", "Jaeger"};
        Integer panel_x = 50;
        Integer panel_y = 50;
		for (String trader : traders) 
        { 

        

  			JPanel fence_panel = new JPanel();
  			Integer item_card_size_y = 100;
  			Integer item_card_space_y_after= 10;
  			Integer item_card_start_position_y = item_card_position_y;
  			card_and_space_size_y = item_card_size_y+item_card_space_y_after;
  			// while loop to create each item card for curent vendor panel
	        Map items = ((Map)jo.get(trader));

	        //System.out.println(items);
	        //System.out.println(items.size());
	        Iterator<Map.Entry> itr1 = items.entrySet().iterator();
	        while (itr1.hasNext()) {
	            Map.Entry pair = itr1.next();

	            
	            //System.out.println(pair.getKey() + " : " + pair.getValue());	            
	            JSONObject itemInfo = (JSONObject) pair.getValue();
	            
	            String item_name = (String) itemInfo.get("name");
	            String item_quantity = (String) itemInfo.get("quantity");
	            String item_kappa = (String) itemInfo.get("kappa");
	            String item_level = (String) itemInfo.get("level");
	            String item_crafting = (String) itemInfo.get("crafting");
	            //String item_status = (String) itemInfo.get("status"); //quizas para guardar data. me parece que no.
	            String item_image_name= (String) itemInfo.get("image");
	            //
	            
	  			String card_name = trader+"///"+item_name;

	  			
	        	// Buttons
	            JButton btnNotFound = new JButton("Not Found");
	            JButton btnInStash = new JButton("In Stash");
	            JButton btnTurnedIn = new JButton("Turned In");

	  			btnNotFound.setBackground(notFoundColor);
	  			btnNotFound.setBounds(5, 5, 100, 30);
	  			btnNotFound.addActionListener(new ActionListener() { 
		  			public void actionPerformed(ActionEvent e) { 
		  				try {
							SetItemStatus(btnNotFound);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} }
		  			public void SetItemStatus(Container container) throws FileNotFoundException, IOException {
	  		    		container.getParent().setBackground(notFoundColor);
	  		    		
		  		  		ldapContent.put(card_name, "0");
		  		  		properties.putAll(ldapContent);
	
		  		  		properties.store(new FileOutputStream(map_file), null);
	  			        //System.out.println(card_name);

		  				return;
		  			}
	  			} );
	  			btnNotFound.setLayout(null);
	  			
	  			btnInStash.setBackground(inStashColor);
	  			btnInStash.setBounds(5, 35, 100, 30);
	  			btnInStash.addActionListener(new ActionListener() { 
		  			public void actionPerformed(ActionEvent e) { 
	  					try {
							SetItemStatus(btnInStash);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} }
		  			public void SetItemStatus(Container container) throws FileNotFoundException, IOException {
	  		    		container.getParent().setBackground(inStashColor);
	  		    		
		  		  		ldapContent.put(card_name, "1");
		  		  		properties.putAll(ldapContent);
	
		  		  		properties.store(new FileOutputStream(map_file), null);
	  			        //System.out.println(card_name);

		  				return;
		  			}
	  			} );
	  			btnInStash.setLayout(null);

	  			btnTurnedIn.setBackground(turnedInColor);
	  			btnTurnedIn.setBounds(5, 65, 100, 30);
	  			btnTurnedIn.addActionListener(new ActionListener() { 
		  			public void actionPerformed(ActionEvent e) { 
		  				try {
							SetItemStatus(btnTurnedIn);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} }
		  			public void SetItemStatus(Container container) throws FileNotFoundException, IOException {
	  		    		container.getParent().setBackground(turnedInColor);
	  		    		
		  		  		///
		  		  		//save hashmap
//		  		  		Map<String, String> ldapContent = new HashMap<String, String>();
//		  		  		Properties properties = new Properties();
		  		  		ldapContent.put(card_name, "2");
		  		  		properties.putAll(ldapContent);
	
		  		  		properties.store(new FileWriter(map_file), null);
		  		  		///
		  		  		
	  			        //System.out.println(card_name);

		  				return;
		  			}
	  			} );
	  			btnTurnedIn.setLayout(null);
	  			
		        
	  			
	  			// item card panel
	  			JPanel item_card = new JPanel();
	  			item_card.setBounds(5, item_card_start_position_y, cardWidth, item_card_size_y);
	  			item_card.setLayout(null);
	  			item_card.setName(card_name);;
	  			
  		  		String status = ldapContent.get(card_name);

  		  		if(status != null && status.equals("1")) {
  		  			item_card.setBackground(inStashColor);
//  			        System.out.println(status);
  		  		}
  		  		else if(status != null && status.equals("2")) {
  		  			item_card.setBackground(turnedInColor);
//  			        System.out.println(status);
  		  		}
  		  		else {
  		  			item_card.setBackground(notFoundColor);
  		  		}
	        
	  			
	  			Integer itemImageSize = item_card.getHeight() - 10;
	  			String item_image = "images/"+trader+"/"+item_image_name;
		        //System.out.println(card_name);

	  			ImageIcon item_icon = LoadImageIcon(item_image,itemImageSize);
	  			JLabel itemImg = new JLabel();
	  			itemImg.setIcon(item_icon);
	  			itemImg.setBounds(btnTurnedIn.getWidth()+10,5, itemImageSize, itemImageSize);
	  			itemImg.setLayout(null);
	  			itemImg.setVisible(true);

	  			JLabel itemTextBox = new JLabel("<html>"+ item_quantity + "x<br>" + item_name +"</html>");
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
	  			JLabel craftImg = new JLabel();
//	  			String craft_image = "/tools.png";
//	  			ImageIcon craft_icon = LoadImageIcon(craft_image,craftIconSize);
//	  			craftImg.setIcon(craft_icon);
//	  			craftImg.setBounds(15+btnTurnedIn.getWidth()+itemImg.getWidth(),
//	  							11 + itemImg.getWidth()/3*2, 
//	  								craftIconSize, 
//	  								craftIconSize);
//	  			craftImg.setLayout(null);
//	  			craftImg.setBackground(new Color(81,81,81,155));
//	  			craftImg.setVisible(true);
	  			
	  		
	  			Integer kappaIconSize = item_card.getHeight()/3-9;
	  			JLabel kappaImg = new JLabel();
//	  			String kappa_image = "/not_kappa.png";
//	  			ImageIcon kappa_icon = LoadImageIcon(kappa_image,kappaIconSize);
//	  			kappaImg.setIcon(kappa_icon);
//	  			kappaImg.setBounds(cardWidth-5 - kappaIconSize,
//							11 + itemImg.getWidth()/3*2, 
//								kappaIconSize, 
//								kappaIconSize);
//	  			kappaImg.setLayout(null);
//	  			kappaImg.setVisible(true);
	            
	            //
	      		item_card.add(btnNotFound);
	      		item_card.add(btnInStash);
	      		item_card.add(btnTurnedIn);
	      		item_card.add(itemImg);
	      		item_card.add(itemTextBox);
	      		item_card.add(craftImg);
	      		item_card.add(kappaImg);
	      		fence_panel.add(item_card);
	      		
	      		item_card_start_position_y = item_card_start_position_y + card_and_space_size_y;
	        }

  			// JPanel
  			fence_panel.setBackground(new Color(51,51,51));
  			fence_panel.setBounds(panel_x, panel_y, cardWidth+10, item_card_position_y+(items.size() * (item_card_size_y + item_card_space_y_after)));
  			fence_panel.setLayout(null);
  			fence_panel.setPreferredSize(new Dimension(800, 600));
  			
  			if ( items.size() > most_items) {
  				most_items = items.size();
  			}
  			
  			//vendor image; goes over panel
  			Integer vendorImageSize = 60;
  			String vendor_image = "images/"+trader+"/"+trader+"_Portrait.jpg";
            //System.out.println(vendor_image);	            

  			ImageIcon vendor_icon = LoadImageIcon(vendor_image,vendorImageSize);
  			
  			JLabel vendorImg = new JLabel();
  			vendorImg.setIcon(vendor_icon);
  			vendorImg.setBounds(fence_panel.getWidth()-vendorImageSize-5, 5, vendorImageSize, vendorImageSize);
  			
  			vendorImg.setLayout(null);
  			vendorImg.setVisible(true);

  			JLabel vendorName = new JLabel(trader, SwingConstants.CENTER);
  			vendorName.setBounds(0,0, (fence_panel.getWidth()-vendorImageSize), 100);
  			vendorName.setFont(new Font("Arial", Font.PLAIN, 32));
  			vendorName.setForeground(new Color(255,255,255));
  			vendorName.setLayout(null);
  			vendorName.setVisible(true);

  			

  			
      		//add

      		fence_panel.add(vendorImg);
      		fence_panel.add(vendorName);
      		back_panel.add(fence_panel);
            panel_x = panel_x + cardWidth + 20;
        }
		back_panel.setPreferredSize(new Dimension(8*(cardWidth+40), (most_items+1)*card_and_space_size_y+panel_y+item_card_position_y));
		frame.setVisible(true);

    }

    //load an image and resize it
	protected ImageIcon LoadImageIcon(String path, Integer newSquareSize) {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(path));
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(newSquareSize, newSquareSize,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
	}
	
	public static void main(String[] args) throws IOException, ParseException {
        new tarkov_items();
    }
}
