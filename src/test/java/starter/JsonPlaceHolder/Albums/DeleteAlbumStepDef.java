package starter.JsonPlaceHolder.Albums;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceHolder.AlbumsAPI;

public class DeleteAlbumStepDef {
    @Steps
    AlbumsAPI albumsAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {albumsAPI.deleteAlbums(id);

    }

    @When("Send request delete album")
    public void sendRequestDeleteAlbum() {
        SerenityRest.when().delete(AlbumsAPI.DELETE_ALBUMS);
    }

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInValidId(int id) {albumsAPI.deleteAlbums(id);

    }

}
