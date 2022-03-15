import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import java.net.URI;
import java.net.URISyntaxException;

public class OwnwaySearch implements ActionListener{
    
    JFrame f;
    JTextField tf;
    JButton[] FunctionButtons = new JButton[5]; 
    JButton b1,b2;
    JRadioButton r1,r2,r3;
    JPanel p;
    private String message1, message2, message3;
    Font myFont = new Font("Arial",Font.BOLD,20);   
    
    OwnwaySearch(){
        
        f = new JFrame("Help in Search");
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.WHITE);
        
        tf = new JTextField();        
        tf.setBounds(50,25,400,100);
	tf.setFont(myFont);
	tf.setEditable(true);
        tf.setBackground(Color.WHITE);
        tf.setForeground(Color.DARK_GRAY);
        
        b1 = new JButton("Go");        
        b1.setForeground(Color.DARK_GRAY);
        b1.setBackground(Color.WHITE);
        
        b2 = new JButton("Clear Field");
        b2.setForeground(Color.DARK_GRAY);
        b2.setBackground(Color.WHITE);
        
        r1 = new JRadioButton("Google");
        r2 = new JRadioButton("Youtube");
        r3 = new JRadioButton("Wikipedia");
        r1.setBounds(70,140,150,50);
        r1.setForeground(Color.DARK_GRAY);
        r1.setBackground(Color.WHITE);
        
	r2.setBounds(70,190,150,50);
        r2.setForeground(Color.DARK_GRAY);
        r2.setBackground(Color.WHITE);
        
        r3.setBounds(70,240,150,50);        
        r3.setForeground(Color.DARK_GRAY);
        r3.setBackground(Color.WHITE);
        
        f.setLayout(null);
        f.setVisible(true);
        
        ButtonGroup group = new ButtonGroup();
	group.add(r1);
	group.add(r2);
        group.add(r3);           
	r1.addActionListener(this);		
	r2.addActionListener(this);
        r3.addActionListener(this);              
        f.add(r1);
        f.add(r2);
        f.add(r3);
        
        FunctionButtons[0] = b1;
        FunctionButtons[1] = b2;                
        
        for(int i=0; i<2; i++){
            
            FunctionButtons[i].addActionListener(this);
            FunctionButtons[i].setFont(myFont);
            FunctionButtons[i].setFocusable(true);
        }
        
        b1.setBounds(250,140,150,50);
        b2.setBounds(250,200,150,50);        
        p = new JPanel();
        p.setBackground(Color.WHITE);
        p.add(b1);
        p.add(b2);        
        f.add(p);
        f.add(b1);
        f.add(b2);        
        f.add(tf);
        f.setVisible(true);       
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(r2.isSelected() && ae.getSource() == b1){                        
            try {                
                playtoolone();
            } catch (IOException ex) {
                
            } catch (URISyntaxException ex) {
                
            }
        }
        
        if(r1.isSelected() && ae.getSource() == b1){            
            try {
                playtooltwo();
            } catch (URISyntaxException ex) {
                
            } catch (IOException ex) {
                
            }
        }
        
        if(r3.isSelected() && ae.getSource() == b1){            
            try {
                playtoolthree();
            } catch (URISyntaxException ex) {
                
            } catch (IOException ex) {
                
            }
        }
        
        if(ae.getSource() == b2){
            tf.setText("");
        }
    }
    
    public static void main(String args[]){
        
        OwnwaySearch vs = new OwnwaySearch();
    }

    private void playtoolone() throws IOException, URISyntaxException {
        
        Desktop d1 = Desktop.getDesktop();
        message1 = tf.getText();
        char ch = '+';
        message1 = message1.replace(' ', ch);
        d1.browse(new URI("https://www.youtube.com/results?search_query="+message1));
                
    }

    private void playtooltwo() throws URISyntaxException, IOException {
        
        Desktop d2 = Desktop.getDesktop();
        message2 = tf.getText();
        char ch = '+';
        message2 = message2.replace(' ', ch);
        d2.browse(new URI("https://www.google.com/search?q="+message2));
    }

    private void playtoolthree() throws URISyntaxException, IOException{
        
        Desktop d3 = Desktop.getDesktop();
        message3 = tf.getText();                
        message3 = message3.replace(' ', '_');
        d3.browse(new URI("https://en.wikipedia.org/wiki/"+message3));
    }    
}

// Created by Abdul Latif