import via.domain.model.Member;

public class Database {
	
	private static Database instance;
	private QueueADT<Member> members;
	
	private Database()
	{
		
	}
	
	public static Database getInstance() 
	{
		if (instance == null) 
		{
			instance = new Database();
		}
		return instance;
	}

}
