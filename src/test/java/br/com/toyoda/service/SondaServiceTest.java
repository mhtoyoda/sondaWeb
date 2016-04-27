package br.com.toyoda.service;

import static com.jayway.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.toyoda.SondaWebApplication;
import br.com.toyoda.direction.Direction;
import br.com.toyoda.model.ActionInput;
import br.com.toyoda.model.ActionInputModel;
import br.com.toyoda.model.Sonda;
import br.com.toyoda.parse.ParseUtil;

import com.google.common.collect.Lists;
import com.jayway.restassured.path.json.JsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SondaWebApplication.class)
public class SondaServiceTest {

	@Autowired
	private ParseUtil<ActionInputModel> parse;
	
	private String json;
	
	@Before
	public void init(){
		ActionInput actionInput = new ActionInput();
		actionInput.setInstructions("LMLMLMLMM");
		Sonda sonda = new Sonda(1, 2, Direction.N);
		actionInput.setSonda(sonda);
		
		ActionInput actionInputB = new ActionInput();
		actionInputB.setInstructions("MMRMMRMRRM");
		Sonda sondaB = new Sonda(3, 3, Direction.E);
		actionInputB.setSonda(sondaB);

		List<ActionInput> actionInputList = Lists.newArrayList(actionInput, actionInputB);
		
		ActionInputModel actionInputModel = new ActionInputModel();
		actionInputModel.setActionInputList(actionInputList);
		json = parse.toJson(actionInputModel);
	}
	
	@Test
	public void moveSondaTest(){
		JsonPath jsonRetorno = given()
        .header("Accept", "application/json")
        .contentType("application/json")
        .body(json)
        .expect()
        .statusCode(200)
        .when()
        .post("/planalto/5/5").andReturn().jsonPath();
		
		List<Integer> coordinatesX = jsonRetorno.get("coordinateX");
		List<Integer> coordinatesY = jsonRetorno.get("coordinateY");
		List<String> directions = jsonRetorno.get("direction");
		
		Assert.assertThat(coordinatesX, Matchers.hasItems(1,5));
		Assert.assertThat(coordinatesY, Matchers.hasItems(3,1));
		Assert.assertThat(directions, Matchers.hasItems(Direction.N.toString(), Direction.E.toString()));
	}
}
