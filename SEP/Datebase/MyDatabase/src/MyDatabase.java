import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyDatabase {
	
	private String driver, url, username, password;
	private Connection connection;
	
	public MyDatabase()
	{
		try
		{
			driver = "org.postgresql.Driver";
			url = "jdbc:postgresql://localhost:5432/postgres";
			username = "cichoszept";
			password = "owd3sshp";
			Class.forName(driver);
			
			connection  = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void createSchema() 
	{
		try
		{
			PreparedStatement create = connection.prepareStatement(
					"CREATE SCHEMA \"SEP\"; \r\n" + 
					"SET search_path = 'SEP'; ");
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function complete.");
		}
	}
	
	public void createTable() 
	{
		try
		{
			PreparedStatement create = connection.prepareStatement(
					"CREATE TABLE IF NOT EXISTS WWW(id INTEGER NOT NULL, name VARCHAR(50), author VARCHAR(50), PRIMARY KEY(id));");
			create.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Function complete.");
		}
	}
	
}
