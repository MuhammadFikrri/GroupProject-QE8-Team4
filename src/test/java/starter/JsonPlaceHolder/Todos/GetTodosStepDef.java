package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.JPHResponses;

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

    @When("Send request get list todos with selected id out of range")
    public void sendRequestGetListTodosWithIdOutOfRange()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_2);
    }

    @Then("Should return status code {int} ok")
    public void shouldReturnStatusCodeOk(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be id {int}")
    public void responseBodyPageShouldBeId(int id)
    {
        SerenityRest.then().body(JPHResponses.ID,equalTo(id));
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

    //test case negative
    @Given("Get todos with invalid parameter id {string} as string")
    public void getListTodosWithId(String id)
    {
        todoAPI.getListTodosInvalid(id);
    }

    @Then("Should return status code {int} Bad Request")
    public void shouldReturnStatusCodeBadRequest(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Get todos without id")
    public void getTodosWithoutId()
    {
    }

    @When("Send request get list todos without id")
    public void sendRequestGetListTodosWithoutId()
    {
        SerenityRest.when().get(TodoAPI.POST_TODOS);
    }

    @Given("Get todos with id {int} and modified parameter {string}")
    public void getTodosWithIdIdAndModifiedParameter(int id, String title)
    {
        todoAPI.setGetTodos3(id,title);
    }

    @When("Send request get todos with selected id and parameter")
    public void sendRequestGetTodosWithSelectedIdAndParameter()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_3);
    }

    @Given("Get todos with invalid id {string}")
    public void getTodosWithInvalidId(String id)
    {
        todoAPI.getListTodosInvalid(id);
    }

    @When("Send request get todos with selected id")
    public void sendRequestGetTodosWithSelectedId()
    {
        SerenityRest.when().get(TodoAPI.GET_TODOS_2);
    }
}
