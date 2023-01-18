package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Get todos with id {int}")
    public void getListTodosWithId(int id)
    {
        todoAPI.setGetListTodos(id);
    }

    @When("Send request get list todos with selected id")
    public void sendRequestGetListTodosWithId()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS);
    }

    @Then("Should return status code {int} ok")
    public void shouldReturnStatusCodeOk(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be id {int}")
    public void responseBodyPageShouldBeId(int id)
    {
        SerenityRest.then().body(JsonPHResponses.ID,equalTo(id));
//        SerenityRest.then().body("id", equalTo(id));
//        int actualId = JsonPath.from(SerenityRest.then().extract().asString()).getInt("id");
//        Assertions.assertThat(actualId).isEqualTo(id);
    }

    @And("Validate json schema list todos")
    public void validateJsonSchemaListTodos()
    {
        File jsonSchema = new File(ConstantJPH.JSON_SCHEMA+"/GetTodosSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
