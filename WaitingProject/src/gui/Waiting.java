package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class Waiting extends JFrame implements ActionListener {
	static String result;
	private JPanel contentPane;
	public static JTextField textinwon;
	private JTextField textphone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Waiting frame = new Waiting();
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
	public Waiting() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 855);
//		contentPane = new JPanel();
		WaitingController wc = new WaitingController();

		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 247, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 버튼 1 ~ 0
		JButton b1 = new JButton("1");
		b1.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b1.setBackground(new Color(168, 218, 247));
		b1.setBounds(455, 313, 110, 105);
		contentPane.add(b1);

		JButton b2 = new JButton("2");
		b2.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b2.setBackground(new Color(168, 218, 247));
		b2.setBounds(580, 313, 110, 105);
		contentPane.add(b2);

		JButton b3 = new JButton("3");
		b3.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b3.setBackground(new Color(168, 218, 247));
		b3.setBounds(701, 313, 110, 105);
		contentPane.add(b3);

		JButton b4 = new JButton("4");
		b4.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b4.setBackground(new Color(168, 218, 247));
		b4.setBounds(455, 428, 110, 105);
		contentPane.add(b4);

		JButton b5 = new JButton("5");
		b5.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b5.setBackground(new Color(168, 218, 247));
		b5.setBounds(580, 428, 110, 105);
		contentPane.add(b5);

		JButton b6 = new JButton("6");
		b6.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b6.setBackground(new Color(168, 218, 247));
		b6.setBounds(701, 428, 110, 105);
		contentPane.add(b6);

		JButton b7 = new JButton("7");
		b7.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b7.setBackground(new Color(168, 218, 247));
		b7.setBounds(455, 543, 110, 105);
		contentPane.add(b7);

		JButton b8 = new JButton("8");
		b8.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b8.setBackground(new Color(168, 218, 247));
		b8.setBounds(580, 543, 110, 105);
		contentPane.add(b8);

		JButton b9 = new JButton("9");
		b9.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b9.setBackground(new Color(168, 218, 247));
		b9.setBounds(701, 543, 110, 105);
		contentPane.add(b9);

		JButton b0 = new JButton("0");
		b0.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		b0.setBackground(new Color(168, 218, 247));
		b0.setBounds(580, 658, 110, 105);
		contentPane.add(b0);

		JButton bback = new JButton("◀");
		bback.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		bback.setBackground(new Color(168, 218, 247));
		bback.setBounds(455, 658, 110, 105);
		contentPane.add(bback);

		JButton bok = new JButton("OK");
		bok.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		bok.setBackground(new Color(168, 218, 247));
		bok.setBounds(701, 658, 110, 105);
		contentPane.add(bok);

		// 관리자 설정 / 종료
		JButton bmanager = new JButton("관리자 설정");
		bmanager.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		bmanager.setBackground(new Color(140, 194, 225));
		bmanager.setBounds(455, 19, 170, 70);
		contentPane.add(bmanager);

		JButton bexit = new JButton("종료");
		bexit.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		bexit.setBackground(new Color(140, 194, 225));
		bexit.setBounds(639, 19, 170, 70);
		contentPane.add(bexit);

		// 텍스트 입력창(웨이팅 수, 전화번호)
		textinwon = new JTextField();
		textinwon.setFont(new Font("맑은 고딕", Font.BOLD, 100));
		textinwon.setBounds(54, 567, 215, 196);
		contentPane.add(textinwon);
		textinwon.setColumns(10);
		wc.selectWait2(textinwon);

		textphone = new JTextField();
		textphone.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		textphone.setBounds(455, 211, 354, 90);
		contentPane.add(textphone);
		textphone.setColumns(10);

		// 라벨 설정
		JLabel nowwaiting = new JLabel("현재 웨이팅");
		nowwaiting.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		nowwaiting.setBounds(54, 514, 171, 43);
		contentPane.add(nowwaiting);

		JLabel team = new JLabel("팀");
		team.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		team.setBounds(281, 709, 40, 54);
		contentPane.add(team);

		JLabel phonetext = new JLabel("휴대폰 번호를 입력해주세요");
		phonetext.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		phonetext.setBounds(471, 157, 321, 34);
		contentPane.add(phonetext);

		JLabel guide1 = new JLabel("대보 식당");
		guide1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		guide1.setBounds(54, 157, 300, 100);
		contentPane.add(guide1);

		bback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					result = result.substring(0, result.length() - 1);
					textphone.setText(result);
				} catch (Exception e2) {

				}

			}
		});
		b9.addActionListener(this);
		b8.addActionListener(this);
		b7.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b3.addActionListener(this);
		b2.addActionListener(this);
		b1.addActionListener(this);
		b0.addActionListener(this);

		// 종료 버튼 클릭시 종료
		bexit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		bmanager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();

			}
		});
		// ok 눌렀을때 인원 입력 창 출력
		bok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (result == null) {
					JOptionPane.showMessageDialog(null, "연락처를 입력하세요.");
				} else if (result.length() != 11) {
					JOptionPane.showMessageDialog(null, "11글자로 입력하세요.");
				} else {
					try {
						new Inwon();
					} catch (Exception e2) {

					}
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		result = textphone.getText();
		result += e.getActionCommand();
		textphone.setText(result);

	}

}
