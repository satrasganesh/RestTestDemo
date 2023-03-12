package restAssuredPackage;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Categories {

	/* Author: Ganesh Satras
	 * Date Created/Modified:12-3-2023 
	 * Function Name: getCategoryName()
	 * Description: Function to validate Categor Name Value.
	 */
	
	
	@Test
	public void categoryNameVerification() {
		given()
		.when()
		.get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("Name", equalTo( "Carbon credits"))
		.header("Content-Type","application/json");
	}

	/* Author: Ganesh Satras
	 * Date Created/Modified:12-3-2023 
	 * Function Name: getRelistFlag()
	 * Description: Function to validate CanRelist Value of the Category to check if it can be reslisted.
	 */
	
	@Test
	public void canRelistFlagCheck() {
		given()
		.when()
		.get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("CanRelist", equalTo(true))
		.header("Content-Type","application/json");
	}

	/* Author: Ganesh Satras
	 * Date Created/Modified:12-3-2023 
	 * Function Name: getDescription()
	 * Description: Function to validate Description Value of the Promotions.
	 */
	@Test 
	public void promotionsDescriptionVerification() { 

		Response res = given()
				.when()
				.get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false");

		//convert JSON to string
		JsonPath js = new JsonPath(res.asString());

		//length of JSON Promotions array
		int promLength = js.getInt("Promotions.size()");
		//System.out.println("Array size of Promotions: " + s);

		for(int i=0;i < promLength; i++) {
			if(js.getString("Promotions["+i+"].Name").equalsIgnoreCase("Gallery")) {
				Assert.assertEquals(js.getString("Promotions["+i+"].Description"),"Good position in category");
			};
		}
	}
}
