package main.java;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class S_H extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JLabel lblAnswer;

	/**
	 * Create the frame.
	 */
	public S_H() {
		setVisible(true);

		setTitle("Решение");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Chooser.form.setVisible(true);
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 597, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFind = new JButton("Найти");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFind();
			}
		});
		btnFind.setBounds(392, 220, 170, 46);
		contentPane.add(btnFind);

		JLabel lblNewLabel = new JLabel("Объем конуса через площадь основания и высоту");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 485, 27);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/img/1_S_H_figure.png")).getImage();

		JButton btnClear = new JButton("Очистить");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClear();
			}
		});
		btnClear.setBounds(274, 220, 108, 46);
		contentPane.add(btnClear);

		JLabel ingForm = new JLabel("");
		ingForm.setBounds(383, 54, 196, 46);
		Image img2 = new ImageIcon(this.getClass().getResource("/img/1_S_H.png")).getImage();
		ingForm.setIcon(new ImageIcon(img2));
		contentPane.add(ingForm);

		JLabel lblNewLabel_1 = new JLabel("Формула");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(274, 62, 138, 31);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Sосн (см^2)");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(274, 110, 138, 31);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("h (см)");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(274, 152, 138, 31);
		contentPane.add(lblNewLabel_1_2);

		txt1 = new JTextField();
		txt1.setBounds(383, 117, 86, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(383, 159, 86, 20);
		contentPane.add(txt2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Ответ (см^3):");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2_1.setBounds(10, 243, 138, 31);
		contentPane.add(lblNewLabel_1_2_1);

		JLabel imgLabel = new JLabel("");
		imgLabel.setBounds(10, 11, 235, 239);
		imgLabel.setIcon(new ImageIcon(img));
		contentPane.add(imgLabel);

		lblAnswer = new JLabel("...");
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAnswer.setBounds(121, 243, 138, 31);
		contentPane.add(lblAnswer);
	}

	private void btnClear() {
		txt1.setText("");
		txt2.setText("");
		lblAnswer.setText("...");
	}

	private void btnFind() {
		if (!isFieldsBlank()) {

			try {
				double answer = solve();

				lblAnswer.setText(answer + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Для вычисления введите корректные значения.");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Сперва заполните все поля.");
		}
	}

	private double solve() {
		double s = Double.parseDouble(txt1.getText());
		double h = Double.parseDouble(txt2.getText());

		double answer = (s * h) / 3;
		return answer;
	}

	private boolean isFieldsBlank() {
		return txt1.getText().isBlank() || txt2.getText().isBlank();
	}
}
