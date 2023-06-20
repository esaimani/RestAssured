package FakeStore.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;

public class ProductAPI {

    @Test
    public void createNewProduct() throws IOException {

        String endPoint = (String) BaseAPI.dataFromJsonFile.get("fakestoreBaseURL");
        String payload = "{\n" +
                "                    \"title\": \"test product 008\",\n" +
                "                    \"price\": 13.5,\n" +
                "                    \"description\": \"lorem ipsum set\",\n" +
                "                    \"image\": \"https://i.pravatar.cc\",\n" +
                "                    \"category\": \"electronic\"\n" +
                "                }";
        Response response = RestUtils.performPost(endPoint,payload,new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);

    }
}
