package main.java;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chooser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	public static Chooser form;
	private A_R a_R;
	private L_R l_R;
	private R_H h;
	private S_H h2;

	/**
	 * Create the frame.
	 */
	public Chooser() {
		form = this;
		setTitle("Выбор варианта решения");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 300);
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
		
		list = new JList();
		setOptionalList();
		list.setBounds(226, 56, 405, 136);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Подтвердить выбор");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseButton();
			}
		});
		btnNewButton.setBounds(226, 204, 405, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Выберите что хотите найти");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(315, 11, 316, 27);
		contentPane.add(lblNewLabel);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setBounds(-15, 11, 231, 239);
		Image img = new ImageIcon(this.getClass().getResource("/img/img.png")).getImage();
		imgLabel.setIcon(new ImageIcon(img));
		contentPane.add(imgLabel);
	}

	private void setOptionalList() {
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {
					"Объём конуса через площадь основания и высоту",
					"Объём конуса через образующую и радиус",
					"Объём конуса через радиус и высоту",
					"Объём конуса через угол раствора (α) и радиус"
			};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

	private void chooseButton() {
		switch (list.getSelectedIndex()) {
		case 0:
			form.setVisible(false);
			new S_H();
			break;
		case 1:
			form.setVisible(false);
			new L_R();
			break;
		case 2:
			form.setVisible(false);
			new R_H();
			break;
		case 3:
			form.setVisible(false);
			new A_R();
			break;
		default:
			JOptionPane.showMessageDialog(this, "Для подтверждения выберите один из вариантов");
		}
	}
}
