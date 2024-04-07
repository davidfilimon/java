package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AccountDetails {

	
	static HashMap<String, String> logininfo = new HashMap<String,String>();

    public static void readLoginInfoFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String email = parts[0];
                    String password = parts[1];
                    logininfo.put(email, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected static HashMap<String, String> getLoginInfo() {
        return logininfo;
    }
	
	
	
}
