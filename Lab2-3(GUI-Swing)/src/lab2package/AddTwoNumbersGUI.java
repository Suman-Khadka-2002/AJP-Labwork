package lab2package;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddTwoNumbersGUI extends JFrame implements ActionListener {

    private JTextField num1TextField, num2TextField, resultTextField;
    private JButton addButton;

    public AddTwoNumbersGUI() {
        // Set up the frame
        setTitle("Add Two Numbers");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create components
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        resultTextField = new JTextField(10);
        resultTextField.setEditable(false); // Make result text field read-only

        setLayout(new GridLayout(5, 3));
        
        JLabel label1 = new JLabel("Number 1: ");
        JLabel label2 = new JLabel("Number 2: ");
        JLabel resultLabel = new JLabel("Result: ");
        
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        
        // Adding components to the frame
        add(label1);
        add(num1TextField);
        add(label2);
        add(num2TextField);
        add(resultLabel);
        add(resultTextField);
        add(new JLabel()); // empty label for spacing
        add(addButton);
        
        setVisible(true);

        // Make the window unresizable
        setResizable(false);
    }
    
    @Override
  public void actionPerformed(ActionEvent e) {
      try {
    	  // gets the number from text fields
    	  double num1 = Double.parseDouble(num1TextField.getText());
    	  double num2 = Double.parseDouble(num2TextField.getText());
    	  //perform addition
    	  double result = num1 + num2;
    	  
    	  // set the result in resultTextField
    	  resultTextField.setText(String.valueOf(result));
      } catch (NumberFormatException ex) { // handle error case for incorrect input
    	  	JOptionPane.showMessageDialog(this, "Enter valid number!", "Error", JOptionPane.ERROR_MESSAGE);
      }
  }

    public static void main(String[] args) {        
        AddTwoNumbersGUI calculator = new AddTwoNumbersGUI();       
    }
}
