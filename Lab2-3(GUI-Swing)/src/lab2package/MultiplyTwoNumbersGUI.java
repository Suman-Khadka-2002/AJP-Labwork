package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplyTwoNumbersGUI extends JFrame implements ActionListener {

    private JTextField num1TextField, num2TextField, resultTextField;
    private JButton multiplyButton;

    public MultiplyTwoNumbersGUI() {
        // Set up the frame
        setTitle("Multiply Two Numbers");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create components
        num1TextField = new JTextField(10);
        num2TextField = new JTextField(10);
        resultTextField = new JTextField(10);
        resultTextField.setEditable(false); // Make result text field read-only

        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(this); // Registering the button for ActionListener

        setLayout(new GridLayout(5, 3));
        
        JLabel label1 = new JLabel("Number 1: ");
        JLabel label2 = new JLabel("Number 2: ");
        JLabel resultLabel = new JLabel("Result: ");
        
        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(this);
        
        
        // Adding components to the frame
        add(label1);
        add(num1TextField);
        add(label2);
        add(num2TextField);
        add(resultLabel);
        add(resultTextField);
        add(new JLabel()); // empty label for spacing
        add(multiplyButton);
        
        setVisible(true);
        // Make the window unresizable
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button click event
        try {
            // Get the numbers from the text fields
            double num1 = Double.parseDouble(num1TextField.getText());
            double num2 = Double.parseDouble(num2TextField.getText());

            // Perform the multiplication
            double result = num1 * num2;

            // Display the result in the result text field
            resultTextField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            // Handle the case where the user enters invalid input (non-numeric)
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
    	MultiplyTwoNumbersGUI calculator = new MultiplyTwoNumbersGUI();
    }
}
