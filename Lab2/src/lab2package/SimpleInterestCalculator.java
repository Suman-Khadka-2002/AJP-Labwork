package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculator extends JFrame implements ActionListener {

    private JTextField principalField, rateField, timeField, resultField;

    public SimpleInterestCalculator() {
        setTitle("Simple Interest Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principalField = new JTextField(10);
        rateField = new JTextField(10);
        timeField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JLabel principalLabel = new JLabel("Principal Amount:");
        JLabel rateLabel = new JLabel("Interest Rate (%):");
        JLabel timeLabel = new JLabel("Time (years):");
        JLabel resultLabel = new JLabel("Simple Interest:");

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        setLayout(new GridLayout(5, 2));
        add(principalLabel);
        add(principalField);
        add(rateLabel);
        add(rateField);
        add(timeLabel);
        add(timeField);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // Empty label for spacing
        add(calculateButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double time = Double.parseDouble(timeField.getText());

            double simpleInterest = (principal * rate * time) / 100;

            resultField.setText(String.valueOf(simpleInterest));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleInterestCalculator::new);
    }
}

