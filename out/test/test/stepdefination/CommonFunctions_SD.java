package stepdefination;

import com.pages.CommonFunctions;
import io.cucumber.java.en.Given;

import java.util.Properties;

public class CommonFunctions_SD {
    private CommonFunctions commonFunctions;
    private Properties prop;

    public CommonFunctions_SD(){
        this.commonFunctions = new CommonFunctions();
    }

    @Given("^user logins using the pinid \"([^\"]*)\"$")
    public void userLoginsUsingThePinid(String pinId) throws Throwable {
    commonFunctions.loginInTotheApplication(pinId, prop.getProperty("password") );

    }
}
