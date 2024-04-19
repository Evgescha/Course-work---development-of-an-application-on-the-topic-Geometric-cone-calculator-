package main.java;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Author extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Author() {
		setTitle("Про автора");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Runner.form.setVisible(true);
			}
		});

		JLabel lblImage = new JLabel("");
		lblImage.setBounds(10, 11, 239, 239);
		contentPane.add(lblImage);
		Image img2 = new ImageIcon(this.getClass().getResource("/img/author.png")).getImage();
		lblImage.setIcon(new ImageIcon(img2));

		String text = "I am an author!";

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(259, 11, 298, 239);
		textArea.setText(text);
		contentPane.add(textArea);

	}
}
