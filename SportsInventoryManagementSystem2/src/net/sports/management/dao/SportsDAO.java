package net.sports.management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sports.management.model.Sports;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table Sports in the database.
 * 
 * @author IIMD
 *
 */
public class SportsDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Root*12345";

	private static final String INSERT_USERS_SQL = "INSERT INTO Sports" + "  (productid, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select productid, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty from Sports where productid =?";
	private static final String SELECT_ALL_USERS = "select * from Sports";
	private static final String DELETE_USERS_SQL = "delete from Sports where productid = ?;";
	private static final String UPDATE_USERS_SQL = "update Sports set product= ?, model= ?, manufacturer= ?, typecode= ?, msrp= ?, unitcost= ?, discountrate= ?, stockqty= ? where productid = ?;";
	private static final String SEARCH_USERS_SQL = "select * from Sports where productid = ?;";

	public SportsDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Sports user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getproductid());
			preparedStatement.setString(2, user.getproduct());
			preparedStatement.setString(3, user.getmodel());
            preparedStatement.setString(4, user.getmanufacturer());
            preparedStatement.setString(5, user.gettypecode());
            preparedStatement.setDouble(6, user.getmsrp());
            preparedStatement.setDouble(7, user.getunitcost());
            preparedStatement.setDouble(8, user.getdiscountrate());
            preparedStatement.setInt(9, user.getstockqty());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Sports selectUser(String productid) {
		Sports user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, productid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String product = rs.getString("product");
                String model = rs.getString("model");
                String manufacturer = rs.getString("manufacturer");
                String typecode = rs.getString("typecode");
                Double msrp = rs.getDouble("msrp");
                Double unitcost = rs.getDouble("unitcost");
                Double discountrate = rs.getDouble("discountrate");
                int stockqty = rs.getInt("stockqty");
				user = new Sports(productid, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Sports> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Sports> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String productid = rs.getString("productid");
				String product = rs.getString("product");
                String model = rs.getString("model");
                String manufacturer = rs.getString("manufacturer");
                String typecode = rs.getString("typecode");
                Double msrp = rs.getDouble("msrp");
                Double unitcost = rs.getDouble("unitcost");
                Double discountrate = rs.getDouble("discountrate");
                int stockqty = rs.getInt("stockqty");
				users.add(new Sports(productid, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(String productid) throws SQLException {
		System.out.println(DELETE_USERS_SQL);
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, productid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Sports user) throws SQLException {
		System.out.println(UPDATE_USERS_SQL);
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {		
			statement.setString(1, user.getproduct());
			statement.setString(2, user.getmodel());
            statement.setString(3, user.getmanufacturer());
            statement.setString(4, user.gettypecode());
            statement.setDouble(5, user.getmsrp());
            statement.setDouble(6, user.getunitcost());
            statement.setDouble(7, user.getdiscountrate());
            statement.setInt(8, user.getstockqty());
            statement.setString(9, user.getproductid());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	/*
	 * public boolean searchUser(String productid) throws SQLException {
	 * System.out.println(SEARCH_USERS_SQL); boolean rowSearched; try (Connection
	 * connection = getConnection(); PreparedStatement statement =
	 * connection.prepareStatement(SEARCH_USERS_SQL);) { statement.setString(1,
	 * productid); rowSearched = statement.executeUpdate() > 0; } return
	 * rowSearched; }
	 */
	
	public List<Sports> searchUser(String productid) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Sports> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_SQL);) {
			preparedStatement.setString(1, productid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String productid_1 = rs.getString("productid");
				String product = rs.getString("product");
                String model = rs.getString("model");
                String manufacturer = rs.getString("manufacturer");
                String typecode = rs.getString("typecode");
                Double msrp = rs.getDouble("msrp");
                Double unitcost = rs.getDouble("unitcost");
                Double discountrate = rs.getDouble("discountrate");
                int stockqty = rs.getInt("stockqty");
				users.add(new Sports(productid_1, product, model, manufacturer, typecode, msrp, unitcost, discountrate, stockqty));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
