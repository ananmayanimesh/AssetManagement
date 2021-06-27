package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static Connection connection = null;

	private ConnectionManager() {

	}

	public static Connection getConnection() {
		if (connection == null) {

			try {
				Properties props = new Properties();

				FileInputStream fis = new FileInputStream("C:/Database.properties");
				props.load(fis);

				String driver = props.getProperty("jdbc.driver");
				String url = props.getProperty("jdbc.url");
				Class.forName(driver);
				connection = DriverManager.getConnection(url);

			} catch (IOException | ClassNotFoundException | SQLException e1) {

				System.out.println("Exception while creating connection from db\n ");
				e1.printStackTrace();
			}

		}

		return connection;

	}

}
