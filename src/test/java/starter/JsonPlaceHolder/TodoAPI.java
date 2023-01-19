package starter.JsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.JsonPlaceHolder.Utils.Constant;

import java.io.File;

public class TodoAPI
{
    public static String GET_TODOS = Constant.BASE_URL + "/todos?id={id}";
    public static String POST_CREATE_TODOS = Constant.BASE_URL + "/todos";

    @Step("Get list todos")
    public void setGetListTodos(int id)
    {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post create todos")
    public void setPostCreateTodos(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}
