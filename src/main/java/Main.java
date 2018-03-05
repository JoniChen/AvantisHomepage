import com.codeborne.selenide.*;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class Main  {



    @Test
    public void test_01() throws IOException, SAXException, ParserConfigurationException {

        //Verify top logo visible and clickable
        HomePage.topLogo().shouldBe(visible);
        HomePage.topLogo().click();

        //Verify top page tabs are visible
        HomePage.aboutTab().shouldBe(visible);
        HomePage.visionTab().shouldBe(visible);
        HomePage.awesomenessTab().shouldBe(visible);
        HomePage.coolfactsTab().shouldBe(visible);
        HomePage.teamTab().shouldBe(visible);
        HomePage.innovateTab().shouldBe(visible);
        HomePage.socializeTab().shouldBe(visible);
        HomePage.contactTab().shouldBe(visible);

        //verify clicking on tab takes to correct location on page and verify UI
        HomePage.aboutTab().click();
        HomePage.aboutTab().shouldBe(focused);
        HomePage.adLogo().shouldBe(Condition.visible);

        HomePage.visionTab().click();
        HomePage.visionTab().shouldBe(focused);
        HomePage.visionLogo().shouldBe(visible);

        HomePage.awesomenessTab().click();
        HomePage.awesomenessTab().shouldBe(focused);

        HomePage.coolfactsTab().click();
        HomePage.coolfactsTab().shouldBe(focused);
        HomePage.coolFact1().shouldBe(visible);
        HomePage.coolFact2().shouldBe(visible);

        HomePage.teamTab().click();
        HomePage.teamTab().shouldBe(focused);
        HomePage.teamImg1().shouldBe(Condition.visible);
        HomePage.teamImg2().shouldBe(Condition.visible);

        HomePage.innovateTab().click();
        HomePage.innovateTab().shouldBe(focused);

        HomePage.socializeTab().click();
        HomePage.socializeTab().shouldBe(focused);

        HomePage.contactTab().click();
        HomePage.contactTab().shouldBe(focused);


    }

    @Test
    public void test_02() throws Exception{


        //verify contact us form - missing details
        HomePage.contactTab().click();
        HomePage.fillContactDetails("","","");
        HomePage.alert().shouldHave(text("Please fill in the required field."));

        //Verify contact us form - invalid email
        HomePage.fillContactDetails("Joni" ,"Joni" , "details");
        HomePage.alert().shouldHave(text("Email address seems invalid."));
        HomePage.yourName().clear();
        HomePage.yourEmail().clear();

        //Verify contact us form - valid details
        HomePage.fillContactDetails("Joni","joni@joni.joni","Hello");
        HomePage.thankYou().shouldBe(visible).shouldHave(text("THANK YOU "));

    }


    @Test
    public void test_03() throws Exception{

        //Verify social links from sidebar buttons

        //Twitter
        HomePage.twitterSidebar().click();
        String twitter = Selenide.switchTo().window(1).getCurrentUrl();
        Assert.assertTrue(twitter.contains("twitter.com"));
        Selenide.switchTo().window(1).close();
        Selenide.switchTo().window(0);
//      from socialize section
        HomePage.socializeTab().doubleClick();
        Thread.sleep(2000);
        HomePage.twitterButton().click();
        String twitter2 =  Selenide.switchTo().window("Avantis Team (@AvantisTeam) | Twitter").getCurrentUrl();
        Assert.assertTrue(twitter2.contains("https://twitter.com/AvantisTeam"));
        Selenide.switchTo().window(1).close();
        Selenide.switchTo().window(0);

        //Facebook
        HomePage.facebookSidebar().click();
        String facebook = Selenide.switchTo().window(1).getCurrentUrl();
        Assert.assertTrue(facebook.contains("facebook.com"));
        Selenide.switchTo().window(1).close();
        Selenide.switchTo().window(0);
//      from socialize section
        HomePage.socializeTab().doubleClick();
        Thread.sleep(2000);
        HomePage.facebookButton().click();
        String facebook2 =  Selenide.switchTo().window("Avantis - Home | Facebook").getCurrentUrl();
        Assert.assertTrue(facebook2.contains("https://www.facebook.com/avantisteam"));
        Selenide.switchTo().window(1).close();
        Selenide.switchTo().window(0);

        //verify join us page loads correctly
        HomePage.awesomenessTab().click();
        HomePage.seeOpeningsButton().click();
        String joinUs = Selenide.switchTo().window("Join Us | Avantis").getCurrentUrl();
        Assert.assertTrue(joinUs.contains("http://www.avantisteam.com/join-us/"));
        Selenide.switchTo().window(1).close();
        Selenide.switchTo().window(0);

    }

    @BeforeMethod
    public void openBrowser() {

        open(Configuration.baseUrl);
    }


    @BeforeClass(alwaysRun = true)
    public synchronized void setUp() throws Exception {
        //Firefox
//        Configuration.browser = "firefox";
        Configuration.baseUrl = "http://www.avantisteam.com/";
        Configuration.browser = "chrome";
        ChromeDriverManager.getInstance().setup();
//        open(Configuration.baseUrl);

    }


}
