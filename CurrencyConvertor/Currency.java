import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Currency extends JFrame implements ActionListener {

    private static final String[] CURRENCIES = {"USD", "EUR", "GBP", "JPY", "CNY"};
    private static final double[] CONVERSION_RATES = {1.0, 0.91, 0.78, 110.11, 6.46};

    private JPanel mainPanel;
    private JLabel amountLabel;
    private JTextField amountTextField;
    private JLabel fromLabel;
    private JComboBox<String> fromComboBox;
    private JLabel toLabel;
    private JComboBox<String> toComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public Currency() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2));

        amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField();

        fromLabel = new JLabel("From:");
        fromComboBox = new JComboBox<>(CURRENCIES);
        fromComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        fromComboBox.setPreferredSize(new Dimension(150, 20));

        toLabel = new JLabel("To:");
        toComboBox = new JComboBox<>(CURRENCIES);
        toComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        toComboBox.setPreferredSize(new Dimension(150, 20));

        convertButton = new JButton("Convert");
        convertButton.setSize(10, 10);
        convertButton.addActionListener(this);

        resultLabel = new JLabel("");

        mainPanel.add(amountLabel);
        mainPanel.add(amountTextField);
        mainPanel.add(fromLabel);
        mainPanel.add(fromComboBox);
        mainPanel.add(toLabel);
        mainPanel.add(toComboBox);
        mainPanel.add(convertButton);
        mainPanel.add(resultLabel);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountTextField.getText());
            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();
            
            double fromRate = CONVERSION_RATES[fromIndex];
            double toRate = CONVERSION_RATES[toIndex];

            double result = amount * (toRate / fromRate);
            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, CURRENCIES[fromIndex], result, CURRENCIES[toIndex]));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        Currency converter = new Currency();
        converter.setVisible(true);
    }
}
