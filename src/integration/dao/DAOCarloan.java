package integration.dao;


import integration.connector.ConnectorFactory;
import integration.connector.Connector;

public abstract class DAOCarloan<Data> implements DAO<Data> {
	
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carloan";
    private static final String DATABASE_USER = "CarloanUser";
    private static final String DATABASE_PASSWORD = "carloan15";
	protected Connector connection = ConnectorFactory.buildMySQLConnector(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

}


