package ohtu;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {

    App app;
    StubIO io;
    UserDao userDao = new InMemoryUserDao();
    AuthenticationService auth = new AuthenticationService(userDao);
    List<String> inputLines = new ArrayList<>();
    List<String> newInputLines = new ArrayList<>();
    List<String> thirdInputLines = new ArrayList<>();

    @Given("^command login is selected$")
    public void command_login_selected() throws Throwable {
        inputLines.add("login");
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void a_username_and_password_are_entered(String username, String password) throws Throwable {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("^system will respond with \"([^\"]*)\"$")
    public void system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^username \"([^\"]*)\" and wrong password \"([^\"]*)\" are entered$")
    public void a_username_and_a_wrong_password_are_entered(String username, String password) throws Throwable {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("^system will respond with no access \"([^\"]*)\"$")
    public void system_will_respond_with_no_access(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void nonexistent_username_and_password_are_entered(String username, String password) throws Throwable {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("system will grant no access and respond with \"([^\"]*)\"$")
    public void system_will_grant_no_access(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("^command new user is selected$")
    public void command_new_user_is_selected() throws Throwable {
        newInputLines.add("new");
    }

    @When("^valid username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void valid_username_and_password_are_entered(String username, String password) throws Throwable {
        newInputLines.add(username);
        newInputLines.add(password);

        io = new StubIO(newInputLines);
        app = new App(io, auth);
        app.run();
    }
    
    @Then("^system will respond with success message \"([^\"]*)\"$")
    public void system_will_respond_with_success_message(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^already taken username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void already_taken_username_and_password_are_entered(String username, String password) throws Throwable {
        newInputLines.add(username);
        newInputLines.add(password);

        io = new StubIO(newInputLines);
        app = new App(io, auth);
        app.run();
    }

    @Then("^system will inform \"([^\"]*)\"$")
    public void system_will_inform(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^too short username \"([^\"]*)\" and password \"([^\"]*)\" are entered$")
    public void too_short_username_and_password_are_entered(String username, String password) throws Throwable {
        newInputLines.add(username);
        newInputLines.add(password);

        io = new StubIO(newInputLines);
        app = new App(io, auth);
        app.run();        
    }

    @Then("^system says \"([^\"]*)\"$")
    public void system_says(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^valid username \"([^\"]*)\" and too short password \"([^\"]*)\" are entered$")
    public void valid_username_and_too_short_password_are_entered(String username, String password) throws Throwable {
        newInputLines.add(username);
        newInputLines.add(password);

        io = new StubIO(newInputLines);
        app = new App(io, auth);
        app.run();  
    }

    @Then("^system fails to create user \"([^\"]*)\"$")
    public void system_fails_to_create_user(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @When("^valid username \"([^\"]*)\" and password with only letters \"([^\"]*)\" are entered$")
    public void valid_username_and_password_with_only_letters_are_entered(String username, String password) throws Throwable {
        newInputLines.add(username);
        newInputLines.add(password);

        io = new StubIO(newInputLines);
        app = new App(io, auth);
        app.run();  
    }

    @Then("^system will say \"([^\"]*)\"$")
    public void system_will_say(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("^user \"([^\"]*)\" with password \"([^\"]*)\" is created$")
    public void user_with_password_is_created(String username, String password) throws Throwable {
        thirdInputLines.add("new");
        thirdInputLines.add(username);
        thirdInputLines.add(password);
        
        thirdInputLines.add("login");

        io = new StubIO(thirdInputLines);
        app = new App(io, auth);
        app.run(); 
    }

    @Then("^login is successful and system will respond with \"([^\"]*)\"$")
    public void login_is_successful_and_system_will_respond_with(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
}
