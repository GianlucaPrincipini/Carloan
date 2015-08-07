package integration.connector;

public class ConnectorFactory {
	public static Connector buildMySQLConnector(String db, String user, String password) {
		return new MySQLConnector(db, user, password);
	}
}
