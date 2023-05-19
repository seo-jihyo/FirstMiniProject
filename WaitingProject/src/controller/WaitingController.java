package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbConn.util.ConnectionHelper;
import model.WaitingVO;

public class WaitingController extends JFrame implements ActionListener {

	public WaitingController() {
		connect();
	}

	private static WaitingController instance = new WaitingController();
	public static String result;

	public static WaitingController getInstance() {
		return instance;
	}

	Connection conn;
	Statement stmt;
	PreparedStatement pstmtInsert, pstmtSelect, pstmtTotal, pstmtTotalScroll, pstmtUpdate;

	private String sqlInsert = "INSERT INTO CCS VALUES(CCS_SEQUENCE.NEXTVAL, ?, ?, SYSDATE, DEFAULT)"; // 예약하기
	private String sqlSelect = "SELECT COUNT(CASE WHEN STATE='입장 대기' THEN 1 END) COUNT FROM CCS";
	private String sqlTotal = "SELECT * FROM CCS ORDER BY NO";
	private String sqlUpdate = "UPDATE CCS SET STATE=? WHERE NO = ?";
	private ResultSet rs;

	public int num;

	MyModel model;
	JTable table;

	// db 연결
	public void connect() {
		try {
			conn = ConnectionHelper.getConnection();
			pstmtInsert = conn.prepareStatement(sqlInsert); // 예약하기
			pstmtSelect = conn.prepareStatement(sqlSelect);
			pstmtTotal = conn.prepareStatement(sqlTotal);
			pstmtUpdate = conn.prepareStatement(sqlUpdate);

			pstmtTotalScroll = conn.prepareStatement(sqlTotal, ResultSet.TYPE_SCROLL_SENSITIVE, // 커서 이동을 자유롭게하고 업데이트
																								// 내용을 반영함
					ResultSet.CONCUR_UPDATABLE); // resultset object 변경이 가능<==> consur_read_only(읽기 전용, 변경 불가)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	// db에 넣기
	public void insert(String number, int people) throws SQLException {
		String phone2 = this.change(number); // 010-1111-1111 형식으로 바꾸기
		System.out.println(phone2);
		WaitingVO vo = new WaitingVO(phone2, people);
		try {
			pstmtInsert.setString(1, vo.getPhone());
			pstmtInsert.setInt(2, vo.getPeople());

			pstmtInsert.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select(JTable table) {
		try {
			ResultSet rs = pstmtTotal.executeQuery();
			ResultSet rsScroll = pstmtTotalScroll.executeQuery();

			if (model == null)
				model = new MyModel();

			model.getRowCount(rsScroll);
			model.setData(rs);

			table.setModel(new DefaultTableModel(model.data, model.columnName));
			table.updateUI();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectWait2(JTextField waitnum) throws SQLException {
		try {
			rs = pstmtSelect.executeQuery();
			rs.next();
			num = rs.getInt(1);

			waitnum.setText(Integer.toString(num));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int no, String state) {
		try {
			if (state.equals("입장 대기")) {
				pstmtUpdate.setString(1, "입장 완료");
				pstmtUpdate.setInt(2, no);
			}
			pstmtUpdate.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// phone형식에 맞게 바꾸기
	public String change(String number) {

		String num1 = number.substring(0, 3);

		String num2 = number.substring(3, 7);

		String num3 = number.substring(7, 11);

		return num1 + "-" + num2 + "-" + num3;
	}

}
