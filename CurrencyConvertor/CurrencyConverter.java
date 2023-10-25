import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JLabel resultLabel;

    public CurrencyConverter() {
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();
        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "INR"});
        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY", "INR"});
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(fromCurrencyLabel);
        frame.add(fromCurrencyComboBox);
        frame.add(toCurrencyLabel);
        frame.add(toCurrencyComboBox);
        frame.add(convertButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    private void convertCurrency() {
        String apiKey = "YOUR_API_KEY"; // Replace with your API key from openexchangerates.org
        String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
        String toCurrency = toCurrencyComboBox.getSelectedItem().toString();
        String amountStr = amountField.getText();

        try {
            double amount = Double.parseDouble(amountStr);
            URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response to get exchange rates
            String jsonResponse = response.toString();
            double exchangeRateFrom = getExchangeRate(jsonResponse, fromCurrency);
            double exchangeRateTo = getExchangeRate(jsonResponse, toCurrency);

            // Perform currency conversion
            double result = (amount / exchangeRateFrom) * exchangeRateTo;
            resultLabel.setText("Converted Amount: " + String.format("%.2f", result) + " " + toCurrency);
        } catch (Exception e) {
            resultLabel.setText("Error occurred: " + e.getMessage());
        }
    }

    private double getExchangeRate(String jsonResponse, String currencyCode) {
        String rateKey = "\"" + currencyCode + "\":";
        int startIndex = jsonResponse.indexOf(rateKey) + rateKey.length();
        int endIndex = jsonResponse.indexOf(",", startIndex);
        String rateValue = jsonResponse.substring(startIndex, endIndex);
        return Double.parseDouble(rateValue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter();
            }
        });
    }
}
