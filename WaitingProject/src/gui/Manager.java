package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.WaitingController;

public class Manager extends JFrame {
	public WaitingController wc = new WaitingController();
	private JPanel contentPane;
	JTable table2;
	public static int no;
	public static String phone, state;

	// 테이블의 파라미터

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);// 중앙 정렬

		// 새로고침 버튼
		JButton brefresh = new JButton("새로고침");
		brefresh.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		brefresh.setBackground(new Color(168, 218, 247));
		brefresh.setBounds(45, 354, 162, 68);
		contentPane.add(brefresh);

		// 상태변경 버튼
		JButton bupdate = new JButton("상태변경");
		bupdate.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		bupdate.setBackground(new Color(168, 218, 247));
		bupdate.setBounds(295, 354, 162, 68);
		contentPane.add(bupdate);

		// 종료버튼
		JButton bexit = new JButton("종료하기");
		bexit.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		bexit.setBackground(new Color(168, 218, 247));
		bexit.setBounds(544, 354, 168, 68);
		contentPane.add(bexit);

		// 예약정보 창
		JScrollPane rvdata = new JScrollPane(table2 = new JTable());
		wc.select(table2);
//		rvdata.setBackground(Color.white); // 배경색상
		rvdata.setBounds(45, 59, 665, 280);
		contentPane.add(rvdata);

		// 테이블 바를 선택했을 때 마우스 액션
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == table2) {
					int row = table2.getSelectedRow();
					phone = table2.getValueAt(row, 1).toString();
					no = Integer.parseInt(table2.getValueAt(row, 0).toString());
					state = table2.getValueAt(row, 4).toString();

				}
			}
		});

		// 예약정보 라벨
		JLabel datalabel = new JLabel("예 약 정 보");
		datalabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		datalabel.setBounds(314, 10, 129, 39);
		contentPane.add(datalabel);

		setVisible(true);

		// 새로고침 버튼 액션
		brefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				wc.select(table2);
			}
		});

		// 상태 변경 버튼 액션
		bupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (state.equals("입장 대기")) {
						wc.update(no, state);
						wc.select(table2);
						wc.selectWait2(Waiting.textinwon);
					} else {
						JOptionPane.showMessageDialog(null, "입장 대기 목록을 선택해주세요.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		// 종료 버튼시 창 닫기
		bexit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
