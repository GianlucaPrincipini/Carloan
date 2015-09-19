package integration.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector implements Connector {

	/**
	 * Connessione con il database
	 */
    private Connection connection;
    
    /**
     * Imposta il Driver del connettore
     * @param url
     * @param user
     * @param password
     */
    public MySQLConnector(String url, String user, String password) {
    	try {
			Class.forName("org.gjt.mm.mysql.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				finalize();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    
    public void finalize() throws SQLException {
    	connection.close();
    }
    
    /**
	 * Esegue una query di lettura
	 * @param query
	 * @return Risultato della query
	 */
	@Override
	public ResultSet executeReadQuery(String query) {
		ResultSet queryResult = null;
		try {
	        Statement statement = connection.createStatement();
            queryResult = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryResult;
	}

	/**
	 * Esegue una query di modifica
	 * @param query
	 * @return Risultato della query
	 */
	@Override
	public ResultSet executeUpdateQuery(String query) {
        ResultSet queryUpdateResult = null;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            queryUpdateResult = statement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return queryUpdateResult;
	}

}
