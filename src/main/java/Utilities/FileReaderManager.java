package Utilities;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static JsonDataReader jsonDataReader;

    private FileReaderManager(){
    }

    public static FileReaderManager getInstance(){
        return  fileReaderManager;
    }

    public JsonDataReader getJsonDataReader(){

        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;

    }

}
