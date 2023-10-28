import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator {

    private JFrame frame;
    private JTextField displayField;
    private String input = "";
    private boolean isScientificMode = false;

    public ScientificCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(44, 62, 80)); // Dark Blue Background

        displayField = new JTextField();
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setBackground(new Color(189, 195, 199)); // Light Gray Background
        displayField.setForeground(Color.BLACK);
        displayField.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5)); // Grid Layout with gaps
        buttonPanel.setBackground(new Color(44, 62, 80)); // Dark Blue Background

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "√", "sin", "cos",
                "tan", "x^2", "exp", "MODE"
        };

        for (String label : buttonLabels) {
            JButton button = createButton(label);
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.setBackground(new Color(52, 152, 219)); // Blue Background
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 18));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185)); // Darker Blue on Hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219)); // Original Blue on Exit
            }
        });

        button.addActionListener(new CalculatorButtonListener());
        return button;
    }

    private class CalculatorButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if ("0123456789.".contains(command)) {
                input += command;
                displayField.setText(input);
            } else if ("+-*/".contains(command)) {
                input += " " + command + " ";
                displayField.setText(input);
            } else if ("=".equals(command)) {
                try {
                    String result = evaluateExpression(input);
                    displayField.setText(result);
                    input = result;
                } catch (Exception e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("C".equals(command)) {
                input = "";
                displayField.setText("");
            } else if ("√".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double sqrtResult = Math.sqrt(number);
                    displayField.setText(String.valueOf(sqrtResult));
                    input = String.valueOf(sqrtResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("sin".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double sinResult = Math.sin(Math.toRadians(number));
                    displayField.setText(String.valueOf(sinResult));
                    input = String.valueOf(sinResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("cos".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double cosResult = Math.cos(Math.toRadians(number));
                    displayField.setText(String.valueOf(cosResult));
                    input = String.valueOf(cosResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("tan".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double tanResult = Math.tan(Math.toRadians(number));
                    displayField.setText(String.valueOf(tanResult));
                    input = String.valueOf(tanResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("exp".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double expResult = Math.exp(number);
                    displayField.setText(String.valueOf(expResult));
                    input = String.valueOf(expResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("x^2".equals(command)) {
                try {
                    double number = Double.parseDouble(input);
                    double powerResult = Math.pow(number, 2);
                    displayField.setText(String.valueOf(powerResult));
                    input = String.valueOf(powerResult);
                } catch (NumberFormatException e) {
                    displayField.setText("Error");
                    input = "";
                }
            } else if ("MODE".equals(command)) {
                isScientificMode = !isScientificMode;
                displayField.setText("");
            }
        }
    }

    private String evaluateExpression(String expression) {
        String[] tokens = expression.split(" ");
        double result = Double.parseDouble(tokens[0]);
        char operator = ' ';
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                operator = token.charAt(0);
            } else {
                double number = Double.parseDouble(token);
                switch (operator) {
                    case '+':
                        result += number;
                        break;
                    case '-':
                        result -= number;
                        break;
                    case '*':
                        result *= number;
                        break;
                    case '/':
                        result /= number;
                        break;
                }
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ScientificCalculator());
    }
}
