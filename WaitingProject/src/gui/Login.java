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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField pwText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);// 중앙 정렬
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 아이디 텍스트
		idText = new JTextField();
		idText.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		idText.setBounds(190, 41, 218, 42);
		contentPane.add(idText);
		idText.setColumns(10);
		// 패스워드 텍스트
		pwText = new JPasswordField();
		pwText.setColumns(10);
		pwText.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		pwText.setBounds(190, 111, 218, 42);
		contentPane.add(pwText);

		// 로그인 버튼
		JButton login = new JButton("로그인");
		login.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		login.setBackground(new Color(168, 218, 247));
		login.setBounds(30, 177, 378, 62);
		contentPane.add(login);

		// ID 라벨
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		idLabel.setBounds(42, 41, 136, 42);
		contentPane.add(idLabel);
		// PW 라벨
		JLabel pwLabel = new JLabel("비밀번호");
		pwLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		pwLabel.setBounds(42, 111, 136, 42);
		contentPane.add(pwLabel);

		setVisible(true);
		
		// 로그인 버튼 액션
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {

					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요.");
					return;
				}
				if (id.equals("abc") && pw.equals("123")) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					new Manager();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 다시 확인하세요.");
				}
			}

		});

	}

}
