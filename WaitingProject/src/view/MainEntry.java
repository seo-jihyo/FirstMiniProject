package view;

import controller.WaitingController;
import dbConn.util.ConnectionHelper;
import gui.Waiting;

public class MainEntry {
	public static void main(String[] args) {
		
		ConnectionHelper.getConnection();
		
		Waiting.main(args);
	}
	
}
