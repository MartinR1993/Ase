package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/** @author Ronnie Dalsgaard */
public class connector {
	private final String HOST     = "ec2-52-30-89-247.eu-west-1.compute.amazonaws.com";
	private final int    PORT     = 3306;
	private final String DATABASE = "grp19";
	private final String USERNAME = "grp19"; 
	private final String PASSWORD = "hS#Vk94G";
	private Connection connection;

	public connector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Connection getConnection(){
		return connection;
	}

	public ResultSet doQuery(String query) throws SQLException{
		Statement stmt = connection.createStatement();
		ResultSet res = stmt.executeQuery(query);
		return res;
	}

	public void doUpdate(String query) throws SQLException{
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(query);
	}
	   
}