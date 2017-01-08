import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SaF_GUI extends JFrame{
    
    JPanel p;
    JButton b;

    public SaF_GUI()
    {
             

        super("Stop and Frisk GUI");
        
		p = new JPanel();
        b = new JButton(" Test "); 
  
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        
        p.add(b);
        add(p);
         
        setVisible(true);
    }
        
	public static void main(String[] args) //throws IOException
	{
		new SaF_GUI();
	}

}


