package db.mysql;

public class MySQLDBUtil {
	//private static final String HOSTNAME = "laidb.cyypzstmxlc7.us-east-1.rds.amazonaws.com";
	private static final String HOSTNAME = "localhost";
	private static final String PORT_NUM = "3306"; // change it to your mysql port number
	public static final String DB_NAME = "laiproject";
	//private static final String USERNAME = "running";
	//private static final String PASSWORD = "1355drake";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	public static final String URL = "jdbc:mysql://"
			+ HOSTNAME + ":" + PORT_NUM + "/" + DB_NAME
			+ "?user=" + USERNAME + "&password=" + PASSWORD
			+ "&autoReconnect=true&serverTimezone=UTC";
}
