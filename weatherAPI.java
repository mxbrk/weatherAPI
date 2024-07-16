import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class weatherAPI {

  private static final String API_KEY = "";
  private static final String BASE_URL = "http://api.weatherapi.com/v1";

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Keine Stadt angegeben");
      return;
    }

    String city = args[0];
    String urlString = BASE_URL + "/current.json?key=" + API_KEY + "&q=" + city;

    try {
      URL url = new URL(urlString);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");

      BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream())
      );
      StringBuilder response = new StringBuilder();
      String line;

      while ((line = in.readLine()) != null) {
        response.append(line);
      }
      in.close();

      System.out.println(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
