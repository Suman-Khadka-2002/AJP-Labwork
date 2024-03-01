package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringOperationsGUI extends JFrame {

    private JTextField inputTextField;
    private JLabel outputLabel;
    private JButton palindromeButton, reverseButton, findVowelsButton;

    public StringOperationsGUI() {
        // Set up the frame
        setTitle("String Operations");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create components
        inputTextField = new JTextField(20);
        outputLabel = new JLabel("Input any string");

        palindromeButton = new JButton("Check Palindrome");
        reverseButton = new JButton("Reverse");
        findVowelsButton = new JButton("Find Vowels");

        // Register buttons for ActionListener
        palindromeButton.addActionListener(e -> checkPalindrome());
        reverseButton.addActionListener( e -> reverseString());
        findVowelsButton.addActionListener(e -> findVowels());

        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input:"));
        inputPanel.add(inputTextField);
        

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(palindromeButton);
        buttonPanel.add(reverseButton);
        buttonPanel.add(findVowelsButton);
        
        add(inputPanel, BorderLayout.NORTH);
        add(outputLabel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkPalindrome() {
        String input = inputTextField.getText().toLowerCase();
        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equals(reversed)) {
            outputLabel.setText("The input is a palindrome.");
        } else {
            outputLabel.setText("The input is not a palindrome.");
        }
    }

    private void reverseString() {
        String input = inputTextField.getText();
        String reversed = new StringBuilder(input).reverse().toString();
        outputLabel.setText("Reversed String: " + reversed);
    }

    private void findVowels() {
        String input = inputTextField.getText().toLowerCase();
        StringBuilder vowels = new StringBuilder();

        for (char c : input.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                vowels.append(c).append(" ");
            }
        }

        if (vowels.length() > 0) {
            outputLabel.setText("Vowels: " + vowels.toString().trim());
        } else {
            outputLabel.setText("No vowels found in the input.");
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(StringOperationsGUI::new);
    }
}
