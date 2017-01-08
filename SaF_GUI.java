import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.JFrame;
//import javax.swing.JComboBox;


public class SaF_GUI extends JFrame implements ActionListener{
    
    JPanel p; //panel
    JButton b; //test button
 	SFVisualizer s; 
	JComboBox d; //drop down button

    public SaF_GUI()
    {
             

        super("Stop and Frisk GUI");
        
		try{
			s = new SFVisualizer();
		} 
		catch (IOException e) {
			System.out.println("IDK whats wrong");
		}

		p = new JPanel();
        //b = new JButton(" Test "); 
		b = new JButton(" Test ");  		
		b.addActionListener(this);	
		
		String[] testArray = {" a ", " b ", " c "};
		d = new JComboBox(testArray);
		d.setSelectedIndex(testArray.length - 1);
		//d.setEditable(true);
		//System.out.println(d);
		d.addActionListener(this);

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        
        p.add(b);
		p.add(d);

        add(p);
         
        setVisible(true);
    }
        
	public void actionPerformed(ActionEvent event) 
	{
		String abc = "";
		String cmd = "";
		try{
			abc = (String)((JComboBox)event.getSource()).getSelectedItem();
		}
		catch (ClassCastException e){
       		cmd = event.getActionCommand().intern();
		}

		


        if (cmd == " Test ") 
		{
			
			//s.filterByBorough("MANHATTAN");
			//s.filterByRace("B");	
            s.drawData(StdDraw.BLUE, 2000);
			
			
			
		} else if (abc == " a ") 
		{
			
			//s.filterByBorough("MANHATTAN");
            s.filterByRace("B");
			
			
		} else if (abc == " b ") 
		{
			
				
            s.filterByBorough("MANHATTAN");
			
			
		} else if (abc == " c ") 
		{
			
				
            s.filterByRace("B");
			
			
		} 

	}
	

	public static void main(String[] args) 
	{
		new SaF_GUI();
	}

}

