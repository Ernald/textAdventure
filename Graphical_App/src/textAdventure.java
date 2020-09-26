import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class textAdventure {
	JFrame window;
    Container con;
    JPanel titleNamePanel , startButtonPanel , mainTextPanel , choiceButtonPanel , playerPanel;
    JLabel titleNameLabel,hpLabel,hpLabelNumber,weaponLabel,weaponLabelName;
    Font titleFont = new Font("Times New Roman",Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman",Font.PLAIN, 30);
    JButton startButton ,choice1,choice2,choice3,choice4; 
    JTextArea mainTextArea;
    int playerHP;
    String weapon ,position;
    
    TitleScreenHandler tsHandler =new TitleScreenHandler();
    ChoiceHandler choiceHandler =new ChoiceHandler();
    
	public static void main(String[] args) {
		new textAdventure();
	}
	
	public textAdventure() {
		
		window = new JFrame("textAdventure");
		window.setSize(800, 650);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel= new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("textAdventure");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	//This is the main page for the Application
	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("_____________This is main Text__________");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapoon :");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
	}
	
	public void playerSetup() {
		weapon ="Knife";
		playerHP = 15;
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText(" "+ playerHP);
		
		townGate();
	}
	
	public void townGate() {
		position ="townGate";
		mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you.\nWhat do you do ?");
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position ="talkGuard";
		mainTextArea.setText("Guard : Hello stranger.\nI have never seen your face.\nIm sory but we cant let a stranger enter our town");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackGuard() {
		position ="attackGuard";
		mainTextArea.setText("Guard : Hey don't be stupid!\n\nThe guard fought back and hit you hard.\n(You receive 3 demage)");
		playerHP = playerHP -3;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void crossRoad(){
		position ="crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south,you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	
	public void north() {
		position ="north";
		mainTextArea.setText("There is a river.\nYou drink the water and rest at the riverside.\n\n(Your HP is recovered by 2)");
		playerHP = playerHP + 2;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void east() {
		position ="east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void west() {
		position ="east";
		mainTextArea.setText("You lost your Long Sword!!(Find it in east)");
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		choice1.setText("<<<");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1": talkGuard();break;
				case "c2":attackGuard();break;
				case "c3":crossRoad();break;
				}break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate();break;
				}break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1" : townGate();break;
				}break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1" :north();break;
				case "c2" :east();break;
				case "c3" :townGate();break;
				case "c4" :west();break;
				}break;
			case "north":
				switch(yourChoice) {
				case "c1":crossRoad();break;
				}break;
			case "east":
				switch(yourChoice) {
				case "c1":crossRoad();break;
				}break;
			case "west":
				switch(yourChoice) {
				case "c1":crossRoad();break;
				}
			}
		}
	}
	
	
	
	

}
