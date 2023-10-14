package ScientificCalculator1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScientificCalc extends JFrame implements ActionListener 
{
    // =======================Declaration of variable===============
    //----------Common keys---------------
    private JButton bOne = new JButton("1");
    private JButton bTwo = new JButton("2");
    private JButton bThree = new JButton("3");
    private JButton bFour = new JButton("4");
    private JButton bFive = new JButton("5");
    private JButton bSix = new JButton("6");
    private JButton bSeven = new JButton("7");
    private JButton bEight = new JButton("8");
    private JButton bNine = new JButton("9");
    private JButton bZero = new JButton("0");
    private JButton bMul = new JButton("\u00D7");
    private JButton bDiv = new JButton("\u00F7");
    private JButton bAdd = new JButton("+");
    private JButton bSub = new JButton("\u02D7");
    private JButton bEqual = new JButton("=");
    private JButton bPoint = new JButton(".");
    private JButton bDel = new JButton("DEL");
    private JButton bClear = new JButton("C");
    private JButton bSquare = new JButton("x\u00B2");
    private JButton bCube = new JButton("x\u00B3");
    private JButton bSqrt = new JButton("\u221A");
    private JButton bPercent = new JButton("%");
    private JButton bMod = new JButton("Mod");
    private JButton bOneByN = new JButton("1/n");
    private JButton bPlusMinus = new JButton("\u00B1");

    //----------Scientific keys---------------
    private JButton bSin = new JButton("sin");
    private JButton bCos = new JButton("cos");
    private JButton bTan = new JButton("tan");
    private JButton bAsin = new JButton("asin");
    private JButton bAcos = new JButton("acos");
    private JButton bAtan = new JButton("atan");
    private JButton bSinH = new JButton("sinh");
    private JButton bCosH = new JButton("cosh");
    private JButton bTanH = new JButton("tanh");
   
    
    public ScientificCalc() {
        setTitle("Scientific Calculator");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Set background color
        getContentPane().setBackground(new Color(255, 255, 255));
        
        // Set font for buttons
        Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        
        // Add common keys to panel
        JPanel commonKeysPanel = new JPanel();
        commonKeysPanel.setLayout(new GridLayout(6, 4, 5, 5));
        commonKeysPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        commonKeysPanel.setBackground(new Color(230, 230, 230));
        
        commonKeysPanel.add(bClear);
        commonKeysPanel.add(bDel);
        commonKeysPanel.add(bPercent);
        commonKeysPanel.add(bDiv);
        
        commonKeysPanel.add(bSeven);
        commonKeysPanel.add(bEight);
        commonKeysPanel.add(bNine);
        commonKeysPanel.add(bMul);
        
        commonKeysPanel.add(bFour);
        commonKeysPanel.add(bFive);
        commonKeysPanel.add(bSix);
        commonKeysPanel.add(bSub);
        
        commonKeysPanel.add(bOne);
        commonKeysPanel.add(bTwo);
        commonKeysPanel.add(bThree);
        commonKeysPanel.add(bAdd);
        
        commonKeysPanel.add(bPlusMinus);
        commonKeysPanel.add(bZero);
        commonKeysPanel.add(bPoint);
        commonKeysPanel.add(bEqual);
        
        // Add scientific keys to panel
        JPanel scientificKeysPanel = new JPanel();
        scientificKeysPanel.setLayout(new GridLayout(5, 4, 5, 5));
        scientificKeysPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scientificKeysPanel.setBackground(new Color(200, 200, 200));
        
        scientificKeysPanel.add(bSquare);
        scientificKeysPanel.add(bCube);
        scientificKeysPanel.add(bSqrt);
        scientificKeysPanel.add(bMod);
        
        scientificKeysPanel.add(bSin);
        scientificKeysPanel.add(bCos);
        scientificKeysPanel.add(bTan);
        scientificKeysPanel.add(bPowerOfTen);
        
        scientificKeysPanel.add(bAsin);
        scientificKeysPanel.add(bAcos);
        scientificKeysPanel.add(bAtan);
        scientificKeysPanel.add(bLog);
        
        scientificKeysPanel.add(bSinH);
        scientificKeysPanel.add(bCosH);
        scientificKeysPanel.add(bTanH);
        scientificKeysPanel.add(bLn);

        // Set font for all buttons
        Component[] components1 = commonKeysPanel.getComponents();
        Component[] components2 = scientificKeysPanel.getComponents();
        
        for (Component component : components1) {
            if (component instanceof AbstractButton) {
                ((AbstractButton) component).setFont(buttonFont);
            }
        }
        
        for (Component component : components2) {
            if (component instanceof AbstractButton) {
                ((AbstractButton) component).setFont(buttonFont);
            }
        }
        
        // Add panels to frame
        setLayout(new BorderLayout());
        add(commonKeysPanel, BorderLayout.CENTER);
        add(scientificKeysPanel, BorderLayout.SOUTH);

    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public static void main(String[] args) {
    	ScientificCalc calculator = new ScientificCalc();
    	calculator.setVisible(true);
    }
}
