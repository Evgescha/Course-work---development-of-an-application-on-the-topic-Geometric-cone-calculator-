package main.java;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public About() {
		setResizable(false);
		setVisible(true);
		setTitle("О программе");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(SystemColor.desktop);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(0, 0, 434, 261);
		contentPane.add(textArea);
		
		String labelText = "Конус - это геометрическая фигура, полученная объединением всех лучей, исходящих из одной вершины конуса и проходящих через плоскую поверхность. Основными математическими характеристиками конуса являются радиус основания и высота.\r\n"
				+ "\r\n"
				+ "Объем конуса - это количественная характеристика этой фигуры в пространстве."
				+ "\r\n"
				+ "Данная программа поможет найти это значение через различные параметры.";
		
		textArea.setText(labelText);
	}
}
