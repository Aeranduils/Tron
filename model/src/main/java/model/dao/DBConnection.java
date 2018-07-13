package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author flori
 *
 */
public final class DBConnection {

	/** The instance. */
	private static DBConnection INSTANCE = null;

	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new DB connection.
	 */
	private DBConnection() {
		this.open();
	}

	/**
	 * Fill the database with data
	 * 
	 * @param player
	 * @param temps
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet fillDatabase(String player, long temps) throws SQLException {

		final String sql = "INSERT INTO Data (Nom_Gagnant, Duree_Partie) VALUES(' " + player + "',  " + temps + ")";

		final java.sql.PreparedStatement pstmt = this.getConnection().prepareStatement(sql);
		pstmt.execute();

		return pstmt.getResultSet();

	}

	/**
	 * Gets the single instance of DBConnection.
	 *
	 * @return single instance of DBConnection
	 */
	public static synchronized DBConnection getInstance() {
		if (DBConnection.INSTANCE == null) {
			DBConnection.INSTANCE = new DBConnection();
		}
		return DBConnection.INSTANCE;
	}

	/**
	 * Open.
	 *
	 * @return the boolean
	 */
	private Boolean open() {
		final DBProperties dbProperties = new DBProperties();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out
					.println("Connecting database url: " + dbProperties.getUrl() + " user: " + dbProperties.getLogin());
			this.connection = DriverManager.getConnection(dbProperties.getUrl(), dbProperties.getLogin(),
					dbProperties.getPassword());
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return this.connection;
	}

}
