import java.util.*;

public class IDandPasswords {

	
	HashMap<String, String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("david", "1234");
		logininfo.put("claudiu", "abcd");
		logininfo.put("matei", "abc123");
		
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
	
}
