package Utilities;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {

    static String jsonFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.json";
    private List<Json> jsonList;

    public JsonDataReader(){
        jsonList= getJsonData();
    }

    private List<Json> getJsonData(){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(jsonFilePath));
            Json[] jsons = gson.fromJson(br,Json[].class);
            return Arrays.asList(jsons);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("Json data file not found at "+jsonFilePath);
        }
        finally {
            try {
                if(br!=null){
                    br.close();
                }
            }
            catch (IOException ignore){
            }
        }
    }

    public final Json getJsonByName(String jsonName){
        return jsonList.stream().filter(x -> x.testCaseName.equalsIgnoreCase(jsonName)).findAny().get();
    }
}
