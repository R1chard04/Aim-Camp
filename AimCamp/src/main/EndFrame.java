package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class EndFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public static final DecimalFormat df = new DecimalFormat("0.00");
	ImageIcon imageIcon;
	JLabel gameTitle;
	JLabel scoreMessage;
	public String name;
	JButton btnStartGame;
	double totalTime;
	double finalScore;
	
	
	EndFrame(String name, double totalTime, double finalScore){
		
		this.totalTime = totalTime;
		this.finalScore = finalScore;
		this.name = name;
		
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
		
		//message stating score
		String scoreMessageText = "<html>"
				  + name + ", <br/>"
				  + "you finished your aim training in " + df.format(totalTime) + " seconds. <br/>"
				  + "Thus, you've achieved a final score of... " + Math.round(finalScore) + "! <br/>"
				  + "Let's see if you can beat that! "
				  + "</html>";
		scoreMessage = new JLabel(scoreMessageText);
		scoreMessage.setBounds(300, 200, 1200, 400);
		scoreMessage.setFont(new Font("MV Boli", Font.PLAIN, 30));
		this.add(scoreMessage);
		
		//button to restart game
		btnStartGame = new JButton("Let's go again!");
		btnStartGame.setFont(new Font("MV Boli", Font.BOLD, 50));
		btnStartGame.setBounds(520, 600, 500, 100);
		btnStartGame.addActionListener(this);
		btnStartGame.setOpaque(true);
		btnStartGame.setForeground(Color.orange);
		btnStartGame.setBackground(Color.black);
		btnStartGame.setHorizontalAlignment(JButton.CENTER);
		btnStartGame.setVerticalAlignment(JButton.CENTER);
		btnStartGame.setFocusable(false);
		btnStartGame.setBorder(BorderFactory.createEtchedBorder());
		this.add(btnStartGame);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStartGame) {
			new GameFrame(this.name);
			
			btnStartGame.setEnabled(false);
			this.dispose();
		}
		
	}
}
