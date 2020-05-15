package Kr;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;
import java.util.Map;


public class SaveDescription {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/aleksandr/Desktop/Programm/java/lesson_kpfu_2/myfile.txt")));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("Margarita/Margarita.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}


