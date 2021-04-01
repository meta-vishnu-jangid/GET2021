package main;
import java.sql.*;

/**
 * Class For Connection and Querying To DATABASE
 * @author vishnu.jangid_metacu
 */
public class DBConnection {
	
	private Connection connection = null;
	private String host, dbName, user_id, password;
	
	/**
	 * Constructor to initialize database Connection
	 * @param host String, host
	 * @param dbName String, database Name
	 * @param user_id String, user id for database
	 * @param password String, password of user
	 * @throws SQLException, if there is an error in Connection
	 * @throws ClassNotFoundException, Drivers not found
	 */
	public DBConnection(String host, String dbName, String user_id, String password) throws ClassNotFoundException, SQLException {
		this.host = host;
		this.dbName = dbName;
		this.user_id = user_id;
		this.password = password;
		connect();
	}
	
	/**
	 * Connect to database
	 * @throws ClassNotFoundException, if Driver Classes Not Found
	 * @throws SQLException, if there is an error in connection
	 */
	private void connect() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String mysqlURL = this.host + this.dbName;
		
		this.connection = DriverManager.getConnection(mysqlURL,this.user_id, this.password);
			     
	}
	
	/**
	 * Get Connection object
	 * @return Connection
	 */
	public Connection getConnection(){
		return this.connection;
	}
	
	
	/**
	 * Reconnect to database
	 * @throws SQLException, if there is an error in connection
	 * @throws ClassNotFoundException, if Driver Classes Not Found 
	 */
	public void reconnect() throws ClassNotFoundException, SQLException{
		if(this.connection == null){
			connect();
		}
	}

	/**
	 * Close Database Connection
	 * @throws SQLException if error in CLosing Connection 
	 */
	public void close() throws SQLException{
		this.connection.close();
		this.connection = null;
	}
}
