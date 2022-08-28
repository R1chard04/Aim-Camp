package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	ImageIcon imageIcon;
	JLabel gameTitle;
	JButton btnStartGame;
	JTextField namefield;
	JLabel nameText;
	JLabel instructions;
	String instructionText = "<html> INTRUCTIONS: <br/>" 
							 + "Want to practice your aim? Well you've come to the right place. <br/>"
							 + "Once you start, five green targets will spawn randomly within this frame, one after another. <br/>"
							 + "Are you ready to take on this challenge? "
							 + "</html>";
	public String name;
	
	StartFrame(){
		
		//frame settings
		this.setTitle("Aim Camp");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0x6B5B95));
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//icon for jframe
		imageIcon = new ImageIcon("imageicon.png");
		this.setIconImage(imageIcon.getImage());
		
		//Game title
		gameTitle = new JLabel("AIM CAMP");
		gameTitle.setFont(new Font("MV Boli", Font.BOLD, 200));
		gameTitle.setForeground(Color.yellow);
		gameTitle.setBounds(250, 100, 1200, 400);
		this.add(gameTitle);
		
		//text field for player's name
		namefield = new JTextField();
		namefield.setPreferredSize(new Dimension(250, 40));
		namefield.setBounds(600, 450, 300, 50);
		namefield.setForeground(Color.black);
		namefield.setBackground(Color.green);
		namefield.setText("Player");
		this.add(namefield);
		
		//start button
		btnStartGame = new JButton("Start the Game!");
		btnStartGame.setFont(new Font("MV Boli", Font.BOLD, 80));
		btnStartGame.setBounds(300, 550, 900, 200);
		btnStartGame.addActionListener(this);
		btnStartGame.setOpaque(true);
		btnStartGame.setForeground(Color.orange);
		btnStartGame.setBackground(Color.black);
		btnStartGame.setHorizontalAlignment(JButton.CENTER);
		btnStartGame.setVerticalAlignment(JButton.CENTER);
		btnStartGame.setFocusable(false);
		btnStartGame.setBorder(BorderFactory.createEtchedBorder());
		this.add(btnStartGame);
		
		//text field for instructions
		instructions = new JLabel();
		instructions.setText(instructionText);
		instructions.setFont(new Font("MV Boli", Font.PLAIN, 20));
		instructions.setBounds(250, 800, 1200, 150);
		this.add(instructions);
		
		//text field prompting user for name
		nameText = new JLabel();
		nameText.setText("Enter player name:");
		nameText.setFont(new Font("MV Boli", Font.PLAIN, 20));
		nameText.setForeground(Color.black);
		nameText.setBounds(400, 450, 200, 50);
		this.add(nameText);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnStartGame) {
			name = namefield.getText();
			new GameFrame(name);
			
			btnStartGame.setEnabled(false);
			namefield.setEditable(false);
			this.dispose();
		}
	}

}
