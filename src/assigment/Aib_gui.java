package assigment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Aib_gui {

	private static JFrame frame;
	JLabel bank_title_label = new JLabel("");
	JLabel account_balance = new JLabel("empty");
	JLabel account_id = new JLabel("empty");
	JLabel account_name = new JLabel("empty");
	JCheckBox loan_check = new JCheckBox("Loan");
	JCheckBox credit_card_check = new JCheckBox("Credit Card");
	JCheckBox savings_acount_checkBox = new JCheckBox("Savings Account");
	JCheckBox transfer_check = new JCheckBox("Transfer State");
	JLabel gif_label = new JLabel();
	String accesDenied = "C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\accessDenied.gif";
	String moneyGif = "C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\cashgif.gif";
	String succesful = "C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\succesful.gif";
	String deleted = "C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\delete.gif";
	String created = "C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\created.gif";
	private static int index = 0;

	public Aib_gui() {

		initialize();
	}

	public static void setVisibe() {
		frame.setVisible(true);
	}

	private Account account;

	private BankModule boi = new BankModule("AIB Bank", "Ireland", addAccounts(), 1234);

	Functions mf = new Functions();

	public Account[] addAccounts() {
		Account[] list = { new Account("Karolis Valatka", "A00252699", 202.15),
				new Account("John Wick", "A0025888", 26787.25), new Account("Jackie Chan", "B1522362", 158569.89) };
		return list;
	}

	private void getInfo() {
		Iterator iterator = boi.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			account = (Account) iterator.next();
			if (i == index) {
				break;
			}
			i++;
		}
		mf.visit(account);
		account_name.setText(account.readAccountName());
		account_id.setText(account.readAcountNumber());
		account_balance.setText("€" + account.readBalance());
	}

	private void colorReset() {
		loan_check.setBackground(Color.gray);
		loan_check.setSelected(false);
		savings_acount_checkBox.setSelected(false);
		transfer_check.setSelected(false);
		credit_card_check.setBackground(Color.gray);
		credit_card_check.setSelected(false);
		savings_acount_checkBox.setBackground(Color.gray);
		transfer_check.setBackground(Color.gray);
		loan_check.setEnabled(true);
		credit_card_check.setEnabled(true);
		savings_acount_checkBox.setEnabled(true);
		transfer_check.setEnabled(true);
		gif_label.setVisible(false);
	}

	private void transferAnimation() {
		
	Thread t = new Thread() {
		  public void run(){
		    try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//Time in Milliseconds
		    gif_label.setVisible(false);
		  }
		};
		t.start();
	}
	private void setLabel(String icon) {
		gif_label.setIcon(new ImageIcon(icon));
		gif_label.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 102, 255));
		frame.setBounds(100, 100, 620, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		bank_title_label.setText(boi.getBankName());
		getInfo();
		gif_label.setVisible(false);

		bank_title_label.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		bank_title_label.setBounds(123, 34, 305, 39);
		frame.getContentPane().add(bank_title_label);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(
				new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\aib.png"));
		lblNewLabel_1.setBounds(449, 11, 101, 107);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bank_gui.setVisible();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setBounds(505, 364, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Account Name->");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 95, 101, 23);
		frame.getContentPane().add(lblNewLabel);

		account_name.setFont(new Font("Tahoma", Font.BOLD, 11));
		account_name.setBounds(153, 95, 101, 23);
		frame.getContentPane().add(account_name);

		JLabel lblAccountId = new JLabel("Account ID->");
		lblAccountId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAccountId.setBounds(10, 128, 101, 23);
		frame.getContentPane().add(lblAccountId);

		account_id.setFont(new Font("Tahoma", Font.BOLD, 11));
		account_id.setBounds(153, 128, 101, 23);
		frame.getContentPane().add(account_id);

		JLabel lblAccountBalance = new JLabel("Account Balance->");
		lblAccountBalance.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAccountBalance.setBounds(10, 162, 133, 23);
		frame.getContentPane().add(lblAccountBalance);

		account_balance.setFont(new Font("Tahoma", Font.BOLD, 11));
		account_balance.setBounds(153, 162, 101, 23);
		frame.getContentPane().add(account_balance);

		JButton back_button = new JButton("Previous");
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 0)
					index--;
				getInfo();
				colorReset();
			}
		});
		back_button.setBounds(21, 364, 89, 23);
		frame.getContentPane().add(back_button);

		JButton next_button = new JButton("Next");
		next_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < boi.getTotalAccount() - 1)
					index++;
				getInfo();
				colorReset();
			}
		});
		next_button.setBounds(123, 364, 89, 23);
		frame.getContentPane().add(next_button);

		JButton add_button = new JButton("Add New Account");
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("Please input a name:");
				String id = JOptionPane.showInputDialog("Please input an ID:");
				String balance = JOptionPane.showInputDialog("Please input a balance:");
				double newBalance = Double.parseDouble(balance);
				boi.addAccount(name, id, newBalance);
				index = boi.getTotalAccount() - 1;
				getInfo();
				colorReset();
				JOptionPane.showMessageDialog(frame, "Succesfully added.");
				setLabel(created);
				transferAnimation();
			}
		});
		add_button.setBackground(new Color(0, 128, 0));
		add_button.setBounds(433, 147, 133, 23);
		frame.getContentPane().add(add_button);

		JButton remove_button = new JButton("Delete Account");
		remove_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boi.remove(index);
				getInfo();
				colorReset();
				JOptionPane.showMessageDialog(frame, "The account was deleted.");
				setLabel(deleted);
				transferAnimation();
			}
		});
		remove_button.setBackground(new Color(220, 20, 60));
		remove_button.setBounds(433, 181, 133, 23);
		frame.getContentPane().add(remove_button);

		JButton loan_button = new JButton("Loan");
		loan_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = mf.canGetALoan();
				if (result) {
					JOptionPane.showMessageDialog(frame, "This account is eligible for a Loan!.");
					loan_check.setSelected(true);
					loan_check.setBackground(Color.green);
					setLabel(succesful);
					transferAnimation();
				} else {
					JOptionPane.showMessageDialog(frame, "This account is not eligible for a Loan!.", "Error",
							JOptionPane.ERROR_MESSAGE);
					loan_check.setBackground(Color.red);
					loan_check.setEnabled(false);
					setLabel(accesDenied);
					transferAnimation();
				}
			}
		});
		loan_button.setBackground(Color.GRAY);
		loan_button.setBounds(433, 215, 133, 23);
		frame.getContentPane().add(loan_button);
		loan_check.setBackground(Color.GRAY);

		loan_check.setBounds(10, 215, 133, 23);
		frame.getContentPane().add(loan_check);

		JButton credit_card = new JButton("Credit Card");
		credit_card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean result = mf.eligitableForCreditCard();
				if (result) {
					JOptionPane.showMessageDialog(frame, "This account is eligible for a Credit Card!.");
					credit_card_check.setSelected(true);
					credit_card_check.setBackground(Color.green);
					setLabel(succesful);
					transferAnimation();
				} else {
					JOptionPane.showMessageDialog(frame, "This account is not eligible for a Credit Card!.", "Error",
							JOptionPane.ERROR_MESSAGE);
					credit_card_check.setBackground(Color.red);
					credit_card_check.setEnabled(false);
					setLabel(accesDenied);
					transferAnimation();
				}
			}
		});
		credit_card.setBackground(Color.GRAY);
		credit_card.setBounds(433, 249, 133, 23);
		frame.getContentPane().add(credit_card);
		credit_card_check.setBackground(Color.GRAY);

		credit_card_check.setBounds(10, 249, 133, 23);
		frame.getContentPane().add(credit_card_check);

		JButton savings_button = new JButton("Savings Account");
		savings_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean result = mf.openSavingsAccount();
				if (result) {
					JOptionPane.showMessageDialog(frame, "This account is eligible for a Savings Account!.");
					savings_acount_checkBox.setSelected(true);
					savings_acount_checkBox.setBackground(Color.green);
					setLabel(succesful);
					transferAnimation();
				} else {
					JOptionPane.showMessageDialog(frame, "This account is not eligible for a Savings Account!.",
							"Error", JOptionPane.ERROR_MESSAGE);
					savings_acount_checkBox.setBackground(Color.red);
					savings_acount_checkBox.setEnabled(false);
					setLabel(accesDenied);
					transferAnimation();
				}
			}
		});
		savings_button.setBackground(Color.GRAY);
		savings_button.setBounds(433, 283, 133, 23);
		frame.getContentPane().add(savings_button);
		savings_acount_checkBox.setBackground(Color.GRAY);

		savings_acount_checkBox.setBounds(10, 283, 133, 23);
		frame.getContentPane().add(savings_acount_checkBox);

		JButton transfer_fund_button = new JButton("Transfer Funds");
		transfer_fund_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String balance = JOptionPane.showInputDialog("Please input a transfer amount:");
				double newBalance = Double.parseDouble(balance);

				boolean result = mf.transfer(newBalance);
				if (result) {
					JOptionPane.showMessageDialog(frame, "Funds Transfered");
					transfer_check.setSelected(true);
					transfer_check.setBackground(Color.green);
					getInfo();
					setLabel(moneyGif);
					transferAnimation();

				} else {
					JOptionPane.showMessageDialog(frame, "Funds not Transfered.", "Error", JOptionPane.ERROR_MESSAGE);
					transfer_check.setBackground(Color.red);
					transfer_check.setEnabled(false);
					setLabel(accesDenied);
					transferAnimation();
				}

			}
		});
		transfer_fund_button.setBackground(Color.GRAY);
		transfer_fund_button.setBounds(433, 317, 133, 23);
		frame.getContentPane().add(transfer_fund_button);
		transfer_check.setBackground(Color.GRAY);

		transfer_check.setBounds(10, 317, 133, 23);
		frame.getContentPane().add(transfer_check);

		gif_label.setIcon(
				new ImageIcon("C:\\Users\\karol\\Desktop\\final assigment software\\assigment\\img\\cashgif.gif"));
		gif_label.setBounds(190, 191, 216, 162);
		frame.getContentPane().add(gif_label);
	}
}
