package starter.JsonPlaceHolder.Todos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.TodoAPI;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class PutTodosStepDef
{
    @Steps
    TodoAPI todoAPI;

    @Given("Put update todos with valid json body and id {int}")
    public void putUpdateTodosWithValidJson(int id)
    {
        File json = new File(Constant.TODO_JSON_REQUEST+"/ValidPutTodos.json");
        todoAPI.setPutUpdateTodos(id,json);
    }

    @When("Send request put update todos")
    public void sendRequestPutUpdateTodos()
    {
        SerenityRest.when().put(TodoAPI.PUT_UPDATE_TODOS);
    }
}
