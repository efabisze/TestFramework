import main.java.Pages.LandingPage;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EndToEndTest extends MainBeforeAfter{

    @Test
    public void fillOutBasicInfo() {
        JSONParser parser = new JSONParser();

        try {
                String path = System.getProperty("user.dir");
                Object obj = parser.parse(new FileReader(path+"\\src\\test\\resources\\TylorMayfield.json"));
                JSONObject jsonObject =  (JSONObject) obj;

                JSONObject consumerAddress = jsonObject.getJSONObject("ConsumerAddress");

                LandingPage LandingPage = new LandingPage(driver);

                LandingPage
                        .clickGetQuotes()
                        .enterFirstName((String) jsonObject.get("ConsumerFirstName"))
                        .enterLastName((String) jsonObject.get("ConsumerLastName"))
                        .clickContinue()
                        .clickGenderButton((String) jsonObject.get("ConsumerGender"))
                        .enterDateOfBirth((String) jsonObject.get("ConsumerLastName"))
                        .clickContinue()
                        .enterHomeAddress((String) consumerAddress.get("ConsumerStreetAddress"), "", (String)consumerAddress.get("ConsumerCity"), (String)consumerAddress.get("ConsumerState"), (String)consumerAddress.get("ConsumerZipCode"))
                        .clickContinue()
                        .clickOwnOption((String) consumerAddress.get("Rent"))
                        .clickNoClaimOption()
                        .clickAddViolationTicketOption()
                        .selectRandomDetails()
                        .clickNoTicketOption()
                        .clickInsuredOption("no")
                        .clickActiveOption("never")
                        .enterYear("2016")
                        .enterMake("Honda")
                        .enterModel("Civic");

            }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}