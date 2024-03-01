package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculatorGridBagLayout extends JFrame {

    private JTextField principalField, rateField, timeField, resultField;

    public SimpleInterestCalculatorGridBagLayout() {
        setTitle("Simple Interest Calculator (GridBagLayout)");
        setSize(300, 250);
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
        calculateButton.addActionListener(e -> calculateSimpleInterest());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(principalLabel, gbc);

        gbc.gridx = 1;
        add(principalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(rateLabel, gbc);

        gbc.gridx = 1;
        add(rateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(timeLabel, gbc);

        gbc.gridx = 1;
        add(timeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(resultLabel, gbc);

        gbc.gridx = 1;
        add(resultField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateSimpleInterest() {
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
        SwingUtilities.invokeLater(SimpleInterestCalculatorGridBagLayout::new);
    }
}
