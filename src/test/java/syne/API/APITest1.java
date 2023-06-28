package syne.API;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.*;
import io.restassured.path.json.JsonPath;

public class APITest1 {

	@Test(description = "first api test")
	public void test1() throws IOException {

		// File newFile = new File("");
		// File newFile = new File("");
		// String json = FileUtils.readFileToString(newFile, "UTF-8");

		// JsonParser jparse = new JsonParser().parse(json);

		// Response resp1 = given().queryParam("page",
		// 2).when().get("https://reqres.in/api/users");
		Response resp2 = given().when().get(
				"https://raw.githubusercontent.com/eesur/country-codes-lat-long/master/country-codes-lat-long-alpha3.json");

	//	JSONObject obj= new JSONObject();
		
		
		
		JsonPath extractor = resp2.jsonPath();
		//String s= extractor.get("fname");
		

		List<Map<String, Object>> list = extractor.getList("ref_country_codes");

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> mapt = list.get(i);
			Object lat = mapt.get("latitude");
			Object longi = mapt.get("longitude");

			System.out.print("latitude-->" + lat);
			System.out.print("  longitude-->" + longi);
			if (lat == longi)
				System.out.println("both are equal----------------------------------------------------------------");

			System.out.println();
		}

	}
}
