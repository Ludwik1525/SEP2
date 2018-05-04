package via.domain.model;

public class StarSign {
	
	public static final String[] LEGAL_NAMES =
		 { "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio",
		 "Sagittarius", "Capricorn", "Aquarius", "Pisces" };
	
	private String name;
	
	public StarSign(String name)
	 {
		this.name = name;
	 }
	public String getName() {
	    return this.name;
    }
	 
}