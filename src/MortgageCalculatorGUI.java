
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

public class MortgageCalculatorGUI extends JFrame {

    public MortgageCalculatorGUI() {
        setTitle("Monthly Mortgage Payment Calculator");

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); //spacing 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Principal row
        JLabel principalLabel = new JLabel("Principal (numbers only):");
        JTextField principalField = new JTextField(15); //Text field width
        // Label coordinates
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(principalLabel, gbc);
        // Text field coordinates
        gbc.gridx = 1;
        mainPanel.add(principalField, gbc);

        // Interest row
        JLabel interestLabel = new JLabel("Annual Interest (%):");
        JTextField interestField = new JTextField(15); //Text field width
        // Label coordinates
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(interestLabel, gbc);
        // Text field coordinates
        gbc.gridx = 1;
        mainPanel.add(interestField, gbc);

        // Mortgage Length row
        JLabel lengthLabel = new JLabel("Mortgage Length (years):");
        JTextField mortgageLengthField = new JTextField(15); //Text field width
        // Label coordinates
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(lengthLabel, gbc);
        // Text field coordinates
        gbc.gridx = 1;
        mainPanel.add(mortgageLengthField, gbc);

        // Calculate button row
        JButton calculateButton = new JButton("Calculate");
        // Grid coordinates
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(calculateButton, gbc);

        // Result field row
        JLabel resultLabel = new JLabel("Monthly Mortgage Payment:");
        JTextField resultField = new JTextField(15); //Text field width
        resultField.setEditable(false); // user cannot type in it
        // Label coordinates
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        mainPanel.add(resultLabel, gbc);
        gbc.gridx = 1;
        mainPanel.add(resultField, gbc);

        // Action listener
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int principal = Integer.parseInt(principalField.getText());
                    float annualInterest = Float.parseFloat(interestField.getText());
                    int years = Integer.parseInt(mortgageLengthField.getText());

                    float monthlyInterest = (annualInterest / 100) / 12;
                    int numPayments = years * 12;

                    BigDecimal payment = MortgageCalculator.calculateMortgage(principal, monthlyInterest, numPayments);
                    resultField.setText(MortgageCalculator.formatCurrency(payment));
                    // Validates input, if not a number throws an exception
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        });

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400)); //Window size
        pack();
        setLocationRelativeTo(null); // center
        setVisible(true);
    }

    public static void main(String[] args) {
        new MortgageCalculatorGUI();
    }
}
