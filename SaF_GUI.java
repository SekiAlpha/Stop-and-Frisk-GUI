import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;


public class SaF_GUI extends JFrame implements ActionListener{
    
    JPanel p; //panel
    JButton b; //test button
 	SFVisualizer s;

    public SaF_GUI()
    {
             

        super("Stop and Frisk GUI");
        
		s = null;
		p = new JPanel();
        //b = new JButton(" Test "); 
		b = new JButton(" Test ");  		
		b.addActionListener(this);	

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        
        p.add(b);
        add(p);
         
        setVisible(true);
    }
        
	public void actionPerformed(ActionEvent event) 
	{
        String cmd = event.getActionCommand().intern();
        if (cmd == " Test ") 
		{
			try{
				s = new SFVisualizer();
			} catch (IOException e) {
				System.out.println("IDK whats wrong");
			}
				
            s.filterByRace("A");
			s.drawData(StdDraw.BLACK, 2000);
		}

	}
	

	public static void main(String[] args) 
	{
		new SaF_GUI();
	}

}


