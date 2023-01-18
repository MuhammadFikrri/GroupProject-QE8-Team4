package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PostTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Post create todos with valid json")
    public void postCreateUserWithValidJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPostTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with valid json")
    public void sendRequestPostTodosWithValidJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }


    @Then("Should return status code {int} Created")
    public void shouldReturnStatusCodeCreated(int ok)
    {
        SerenityRest.then().statusCode(ok);
    }

    @Given("Post create todos with blank parameter json")
    public void postCreateTodosWithBlankParameterJson()
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/BlankBodyTodos.json");
        todoAPI.setPostTodos(json);
    }

    @When("Send request post todos with blank parameter json")
    public void sendRequestPostTodosWithBlankParameterJson()
    {
        SerenityRest.when().post(TodoAPI.POST_CREATE_TODOS);
    }
}
