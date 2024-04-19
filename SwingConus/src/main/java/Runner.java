package main.java;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Runner extends JFrame {
	public static Runner form; 
	private Chooser chooser;
	private About about;
	private Author author;

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Runner window = new Runner();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Runner() {
		initialize();
		form = this;
	}

	/**
	 * Initialize the contents of the
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Геометрический калькулятор конуса");
		setResizable(false);

		setBounds(100, 100, 450, 300);

		getContentPane().setLayout(null);

		JButton btnStart = new JButton("Запуск");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startApplication();
			}
		});
		btnStart.setBounds(261, 66, 152, 49);
		getContentPane().add(btnStart);
		Image img = new ImageIcon(this.getClass().getResource("/img/preview.jpg")).getImage();
		
		JButton btnAuthor = new JButton("Об авторе");
		btnAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutAuthor();
			}
		});
		btnAuthor.setBounds(261, 126, 152, 49);
		getContentPane().add(btnAuthor);
				
				JButton btnAbout = new JButton("О программе");
				btnAbout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aboutApplication();
					}
				});
				btnAbout.setBounds(261, 186, 152, 49);
				getContentPane().add(btnAbout);
				
						JLabel backgroundLabel = new JLabel("");
						backgroundLabel.setBounds(0, 0, 434, 261);
						backgroundLabel.setIcon(new ImageIcon(img));
						getContentPane().add(backgroundLabel);

	}

	private void startApplication() {
		this.setVisible(false);
		new Chooser();
	}

	private void aboutApplication() {
		this.setVisible(false);
		new About();
	}

	private void aboutAuthor() {
		this.setVisible(false);
		new Author();
	}
}
