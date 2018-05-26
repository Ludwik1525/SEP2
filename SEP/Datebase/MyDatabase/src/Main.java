
public class Main {
	public static void main(String[] args) throws Exception
	{	
		MyDatabase db = new MyDatabase();
		
		db.createSchema();
		db.createTable();
	}

}
