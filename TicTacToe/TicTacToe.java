import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {
	// using random to select turn of player on random bases
	Random random=new Random();
	JFrame frame=new JFrame(); //Frame of Javagui
	JPanel title_panel=new JPanel();  //For Title of the program
	JPanel button_panel=new JPanel();// For buttons which will 0 and X
	JLabel textfield=new JLabel(); //For Displaying result
	JButton[] buttons=new JButton[9];// Buttons that of the java program
	boolean player1_turn=true;
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setForeground(new Color(30,150,150));
		for(int i=0;i<9;i++) {
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
			
			
		}
		
		title_panel.add(textfield);
		
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		firstturn();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textfield.setText("0 turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("0");
						player1_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}
		}
		
	}
	//To Determine Firsat turn
	public void firstturn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
		}
		else{
			player1_turn=false;
			textfield.setText("0 turn");
		}
		
	}
	// TO check the winn
	public void check() {
		if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")   {
			xwins(0,1,2);
		}
		if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")   {
			xwins(3,4,5);
		}
		if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")   {
			xwins(6,7,8);
		}
		if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")   {
			xwins(0,4,8);
		}
		if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")   {
			xwins(2,4,6);
		}
		if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")   {
			xwins(0,3,6);
		}
		if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")   {
			xwins(1,4,7);
		}
		if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")   {
			xwins(2,4,6);
		}
		if(buttons[0].getText()=="0" && buttons[1].getText()=="0" && buttons[2].getText()=="0")   {
			owins(0,1,2);
		}
		if(buttons[3].getText()=="0" && buttons[4].getText()=="0" && buttons[5].getText()=="0")   {
			owins(3,4,5);
		}
		if(buttons[6].getText()=="0" && buttons[7].getText()=="0" && buttons[8].getText()=="0")   {
			owins(6,7,8);
		}
		if(buttons[0].getText()=="0" && buttons[4].getText()=="0" && buttons[8].getText()=="0")   {
			owins(0,4,8);
		}
		if(buttons[2].getText()=="0" && buttons[4].getText()=="0" && buttons[6].getText()=="0")   {
			owins(2,4,6);
		}
		if(buttons[0].getText()=="0" && buttons[3].getText()=="0" && buttons[6].getText()=="0")   {
			owins(0,3,6);
		}		
		if(buttons[1].getText()=="0" && buttons[4].getText()=="0" && buttons[7].getText()=="0")   {
			owins(1,4,7);
		}		
		if(buttons[2].getText()=="0" && buttons[5].getText()=="0" && buttons[8].getText()=="0")   {
			owins(2,5,7);
		}
		checkdraw();
	}
	//condiion for O wins
	public void owins(int a,int b,int c) {
		buttons[a].setBackground(Color.black);
		buttons[b].setBackground(Color.black);
		buttons[c].setBackground(Color.green);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false); 
		}
		textfield.setText("0 wins");
		//reset();
	
	}
	//condition for xwins
	public void xwins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false); 
		}
		textfield.setText("X wins");
		//reset();
	}
	public void checkdraw() {
		boolean draw=true;
		for(int i=0;i<9;i++) {
			if(buttons[i].getText().equals("")) { 
			draw=false;
			break;
			}	
		}
		if(draw) {
			textfield.setText("It's Draw");
		}
		//reset();
	}
	public void reset() {
	    for (int i = 0; i < 9; i++) {
	        buttons[i].setEnabled(true);
	        buttons[i].setText("");
	        buttons[i].setBackground(Color.ORANGE);
	    }
	}

	
}
