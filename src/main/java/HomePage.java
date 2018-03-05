import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    public static SelenideElement topLogo() {

       return  $("div[class='headerLogotopDiv']");

    }


    public static SelenideElement aboutTab() {

        return $(By.linkText("ABOUT"));
    }

    public static SelenideElement visionTab() {

        return $(By.linkText("VISION"));
    }

    public static SelenideElement awesomenessTab() {

        return $(By.linkText("AWESOMENESS"));
    }

    public static SelenideElement coolfactsTab() {

        return $(By.linkText("COOL FACTS"));
    }

    public static SelenideElement teamTab() {

        return $(By.linkText("TEAM"));
    }

    public static SelenideElement innovateTab() {

        return $(By.linkText("INNOVATE"));
    }

    public static SelenideElement socializeTab() {

        return $(By.linkText("SOCIALIZE"));
    }

    public static SelenideElement contactTab() {

        return $(By.linkText("CONTACT"));
    }

    public static SelenideElement yourName() {

        return $(By.name("your-name"));

    }

    public static SelenideElement yourEmail() {

        return $(By.name("your-email"));

    }

    public static SelenideElement yourMessage() {

        return $(By.name("your-message"));

    }

    public static SelenideElement contactUsButton() {

        return $("input[type=submit]");

    }

    public static SelenideElement adLogo() {

        return $("div[class='leftFirst'] h1");

    }

    public static SelenideElement thankYou() {

        return $("div[class='thankYou']");

    }

    public static SelenideElement thankYouSubContent() {

        return $("div[class='thankYouSubContent']");

    }

    public static SelenideElement alert() {

        return $("span[role='alert']");

    }

    public static SelenideElement twitterSidebar() {

        return $("a[class='at-share-btn at-svc-twitter']");

    }

    public static SelenideElement twitterButton() {

        return $("a[class='social_twitter']");

    }

    public static SelenideElement facebookSidebar() {

        return $("a[class='at-share-btn at-svc-facebook at4-share-count-anchor']");

    }

    public static SelenideElement facebookButton() {

        return $("a[class='social_facebook']");

    }

    public static SelenideElement seeOpeningsButton() {

        return $("a[class='linkToScroll buttonForAllWhiteJoinUs']");

    }

    public static SelenideElement coolFact1() {

        return $("div[class='circle1 hidemeForFadeIn']");

    }

    public static SelenideElement coolFact2() {

        return $("div[class='circle2 hidemeForFadeIn']");

    }

    public static SelenideElement visionLogo() {

        return $("div[class='middleContainerFirst2'] h1");

    }

    public static SelenideElement teamImg1() {

        return $(By.id("wd-cl-img11"));

    }

    public static SelenideElement teamImg2() {

        return $(By.id("wd-cl-img18"));

    }

    public static void fillContactDetails(String name , String email , String details) {

        yourName().sendKeys(name);
        yourEmail().sendKeys(email);
        yourMessage().sendKeys(details);
        contactUsButton().submit();

    }

}
