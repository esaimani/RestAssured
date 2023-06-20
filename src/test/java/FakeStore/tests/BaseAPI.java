package FakeStore.tests;

import utils.Jsonutils;

import java.io.IOException;
import java.util.Map;

public class BaseAPI {
    static Map<String,Object> dataFromJsonFile;

    static {
        String env = System.getProperty("env") == null ? "qa" :System.getProperty("env");
        try {
            dataFromJsonFile = Jsonutils.getJsonDataAsMap(env+"/fakestoredata.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
