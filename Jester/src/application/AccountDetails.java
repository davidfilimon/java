package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class AccountDetails {
	
	static HashMap<String, ArrayList<String>> logininfo = new HashMap<String,ArrayList<String>>();
	static LinkedList<String> accountinfo = new LinkedList<String>();
	
	
    public static void readLoginInfoFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> parts = new ArrayList<String>(Arrays.asList(line.split(", ")));
                if (parts.size() == 3) {
                	String email = parts.get(0);
                	String username = parts.get(1);
                	String password = parts.get(2);
                	
                	ArrayList<String> credentials = new ArrayList<>();
                    
                	credentials.add(username);
                	credentials.add(password);
                    
                    logininfo.put(email, credentials);
                    
                    	}
                    	
                    }
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        
    
    protected static HashMap<String, ArrayList<String>> getLoginInfo() {
        return logininfo;
    }
	
	
	
}
