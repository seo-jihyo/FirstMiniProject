package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.WaitingController;

public class Inwon extends JFrame implements ActionListener {
	WaitingController wc = WaitingController.getInstance();
	private JPanel contentPane;
	private JTextField textinwonnum;
	static String result;
	String peopleNum;
	public Frame[] w = Waiting.getFrames();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inwon frame = new Inwon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inwon() {

		setBounds(200, 200, 380, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel inwonguide = new JLabel("인      원");
		inwonguide.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonguide.setBounds(125, 5, 200, 70);
		contentPane.add(inwonguide);

		textinwonnum = new JTextField();
		textinwonnum.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		textinwonnum.setBounds(50, 70, 270, 70);
		contentPane.add(textinwonnum);
		textinwonnum.setColumns(10);

		// 1 ~ 0까지 배경
		JButton inwonb1 = new JButton("1");
		inwonb1.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // 글씨체
		inwonb1.setBackground(new Color(168, 218, 247)); // 버튼 배경색
		inwonb1.setBounds(50, 150, 70, 70); // 버튼 크기&위치
		contentPane.add(inwonb1);

		JButton inwonb2 = new JButton("2");
		inwonb2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb2.setBackground(new Color(168, 218, 247));
		inwonb2.setBounds(150, 150, 70, 70);
		contentPane.add(inwonb2);

		JButton inwonb3 = new JButton("3");
		inwonb3.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb3.setBackground(new Color(168, 218, 247));
		inwonb3.setBounds(250, 150, 70, 70);
		contentPane.add(inwonb3);

		JButton inwonb4 = new JButton("4");
		inwonb4.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb4.setBackground(new Color(168, 218, 247));
		inwonb4.setBounds(50, 250, 70, 70);
		contentPane.add(inwonb4);

		JButton inwonb5 = new JButton("5");
		inwonb5.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb5.setBackground(new Color(168, 218, 247));
		inwonb5.setBounds(150, 250, 70, 70);
		contentPane.add(inwonb5);

		JButton inwonb6 = new JButton("6");
		inwonb6.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb6.setBackground(new Color(168, 218, 247));
		inwonb6.setBounds(250, 250, 70, 70);
		contentPane.add(inwonb6);

		JButton inwonb7 = new JButton("7");
		inwonb7.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb7.setBackground(new Color(168, 218, 247));
		inwonb7.setBounds(50, 350, 70, 70);
		contentPane.add(inwonb7);

		JButton inwonb8 = new JButton("8");
		inwonb8.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb8.setBackground(new Color(168, 218, 247));
		inwonb8.setBounds(150, 350, 70, 70);
		contentPane.add(inwonb8);

		JButton inwonb9 = new JButton("9");
		inwonb9.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb9.setBackground(new Color(168, 218, 247));
		inwonb9.setBounds(250, 350, 70, 70);
		contentPane.add(inwonb9);

		JButton inwonbackspace = new JButton("◀");
		inwonbackspace.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonbackspace.setBackground(new Color(168, 218, 247));
		inwonbackspace.setBounds(50, 450, 70, 70);
		contentPane.add(inwonbackspace);

		JButton inwonb0 = new JButton("0");
		inwonb0.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		inwonb0.setBackground(new Color(168, 218, 247));
		inwonb0.setBounds(150, 450, 70, 70);
		contentPane.add(inwonb0);

		JButton inwonbok = new JButton("OK");
		inwonbok.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		inwonbok.setBackground(new Color(168, 218, 247));
		inwonbok.setBounds(250, 450, 70, 70);
		contentPane.add(inwonbok);

		setVisible(true);

		inwonb8.addActionListener(this);
		inwonb9.addActionListener(this);
		inwonb0.addActionListener(this);
		inwonb1.addActionListener(this);
		inwonb2.addActionListener(this);
		inwonb3.addActionListener(this);
		inwonb4.addActionListener(this);
		inwonb5.addActionListener(this);
		inwonb6.addActionListener(this);
		inwonb7.addActionListener(this);

		inwonbackspace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					result = result.substring(0, result.length() - 1);
					textinwonnum.setText(result);
				} catch (Exception e2) {

				}

			}
		});

		inwonbok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int people = Integer.parseInt(result);
					System.out.println("people: " + people);
					System.out.println("phone: ---------" + Waiting.result);
					wc.insert(Waiting.result, people);
					wc.selectWait2(Waiting.textinwon);
					
					JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.");

					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		result = textinwonnum.getText();
		result += e.getActionCommand();
		textinwonnum.setText(result);

	}
}
