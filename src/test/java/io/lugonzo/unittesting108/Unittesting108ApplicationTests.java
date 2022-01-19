package io.lugonzo.unittesting108;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Unittesting108ApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;


	@Test
	void contextLoads() throws JSONException {
		String response = this.testRestTemplate.getForObject("/all-book-flight",String.class);

		JSONAssert.assertEquals("[{\"id\":\"1\",\"name\":\"Kel\",\"flightType\":\"PREMIUMECONOMY\",\"seatNo\":64323},{\"id\":\"2\",\"name\":\"Mel\",\"flightType\":\"BUSINESSCLASS\",\"seatNo\":98223},{\"id\":\"3\",\"name\":\"Sel\",\"flightType\":\"FIRSTCLASS\",\"seatNo\":98732},{\"id\":\"4\",\"name\":\"Zel\",\"flightType\":\"PREMIUMECONOMY\",\"seatNo\":92332}]",response,false);
	}

}
