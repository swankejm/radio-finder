import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import javax.net.ssl.HttpsURLConnection;

/*
 * created by Mike Swanke 3/20/19
 */

public class SteamRequest{
    	private static final String URL_1 = "http://api.steampowered.com/IPlayerService/GetOwnedGames/v0001/?key=";
	private static final String API_KEY = "A35D8F6190E8FEFE935865D4D563F0BC";
	private static final String URL_2 = "&steamid=";
	private static final String URL_3 = "&include_appinfo=1&format=json";
	public static void main(String args[]) throws IOException{
    		String s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter player number:");
		s = sc.nextLine();
		
		System.out.println("you entered string " + s);
		String urlLink = URL_1 + API_KEY + URL_2 + s + URL_3;
		URL url = new URL(urlLink);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;

		while((line = in.readLine()) != null){
    		    sb.append(line);
		}
		in.close();
		System.out.println(sb.toString());
		                   
	}
	
}
