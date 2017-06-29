package org.sarwar.becreative;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sarwar.becreative.rest.ResourceConstants;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringmvcRestAngular2Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserResourceTest {
	//private static final UUID EXPECTED_ITEM_ID_FOR_GET = UUID.fromString("deba3089-3feb-4974-8042-2c7c96c10aea");

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {

        RestAssured.port = Integer.valueOf(port);
        RestAssured.basePath = ResourceConstants.USER_MANAGEMENT_V1;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void getAvailableUsers() throws Exception {
        given().when().get("/" + "users").then()
                .statusCode(200);
    }

}
