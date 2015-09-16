package integration.connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Connector {

    public abstract ResultSet executeReadQuery(String query);
    public abstract ResultSet executeUpdateQuery(String query);

    public void finalize() throws SQLException;
}