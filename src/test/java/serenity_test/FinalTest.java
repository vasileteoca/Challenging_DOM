package serenity_test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity_test.steps.FinalTestSteps;


@Story(FinalTest.class)
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WithTag("Smoke")
public class FinalTest {

    @Managed(uniqueSession = false)
    public WebDriver webDriver;

    @Steps
    private FinalTestSteps finalTestSteps;


    @Before
    public void init() {
        finalTestSteps.open("https://the-internet.herokuapp.com/challenging_dom");
    }

    @Test
    @WithTag("Final Test")
    @Title("The 6 steps to verify for final test")
    public void FinalTest() {
        finalTestSteps.verifyTitle();
        finalTestSteps.verifyParagraph();
        finalTestSteps.clickBlueButton();
        finalTestSteps.clickRedButton();
        finalTestSteps.clickGreenButton();
        finalTestSteps.elementalSeleniumRedirectsVerification();
        finalTestSteps.gitRedirectVerification();
    }
}