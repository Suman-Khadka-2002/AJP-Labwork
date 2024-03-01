package lab2package;

import java.awt.*; //BorderLayout, Dimension
import javax.swing.*;//JButton, JFrame is needed.

public class UseofBorderLayoutGUI extends JFrame{
	
	//constructor
	public UseofBorderLayoutGUI() {
		setTitle("BorderLayout Example");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton centerButton = new JButton("Center");
        
        setLayout(new BorderLayout());
        
     // Add buttons to the frame with specific regions
        add(northButton, BorderLayout.NORTH);
        add(southButton, BorderLayout.SOUTH);
        add(eastButton, BorderLayout.EAST);
        add(westButton, BorderLayout.WEST);
        add(centerButton, BorderLayout.CENTER);
        
//        centerButton.setPreferredSize(new Dimension(100,50));
//        JPanel panel = new JPanel();
//        panel.add(centerButton);
//        add(panel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
				
	}

	public static void main(String[] args) {
		UseofBorderLayoutGUI test = new UseofBorderLayoutGUI();

	}

}
