package assigment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class Bank_gui {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank_gui window = new Bank_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bank_gui() {
		initialize();
	}
	
	public static void setVisible() {
		frame.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 602, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button_boi = new JButton("Bank Of Ireland");
		button_boi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankOfIreland_gui window = new bankOfIreland_gui();
				window.setVisibe();
				frame.setVisible(false);
			}
		});
		button_boi.setIcon(new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\boi1.png"));
		button_boi.setBounds(44, 101, 230, 115);
		frame.getContentPane().add(button_boi);
		
		JButton button_loyds = new JButton("Lloyds Bank");
		button_loyds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lloyds_gui window = new Lloyds_gui();
				window.setVisibe();
				frame.setVisible(false);
			}
		});
		button_loyds.setIcon(new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\loyds1.png"));
		button_loyds.setBounds(304, 101, 230, 115);
		frame.getContentPane().add(button_loyds);
		
		JButton button_aib = new JButton("AIB Bank");
		button_aib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aib_gui window = new Aib_gui();
				window.setVisibe();
				frame.setVisible(false);
			}
		});
		button_aib.setIcon(new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\aib.png"));
		button_aib.setBounds(44, 227, 230, 115);
		frame.getContentPane().add(button_aib);
		
		JButton button_ulster = new JButton("Ulster Bank");
		button_ulster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ulster_gui window = new Ulster_gui();
				window.setVisibe();
				frame.setVisible(false);
			}
		});
		button_ulster.setIcon(new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\ulster.jpeg"));
		button_ulster.setBounds(304, 227, 230, 115);
		frame.getContentPane().add(button_ulster);
		
		JLabel title_label = new JLabel("Choose your bank!");
		title_label.setBackground(Color.GRAY);
		title_label.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		title_label.setBounds(150, 11, 272, 57);
		frame.getContentPane().add(title_label);
		
		JMenuBar menuBar_1 = new JMenuBar();
		frame.setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Options");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
	}
}
