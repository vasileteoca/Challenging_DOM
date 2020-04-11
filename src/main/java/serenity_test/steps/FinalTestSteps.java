package serenity_test.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import serenity_test.pages.FinalTestPage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertTrue;

public class FinalTestSteps extends ScenarioSteps {

    private FinalTestPage finalTestPage;

    @Step("Open page")
    public void open(String url) {
        getDriver().manage().window().maximize();
        getDriver().navigate().to(url);
    }

    @Step("Verify Title")
    public void verifyTitle() {
        Assert.assertTrue(finalTestPage.title.getText().equals("Challenging DOM"));
    }

    @Step("Verify Paragraph")
    public void verifyParagraph() {
        Assert.assertTrue(!finalTestPage.descriptionParagraph.getText().isEmpty());
    }

    @Step("Click Blue Button")
    public void clickBlueButton() {
        finalTestPage.blueButton.click();
        Assert.assertTrue(!finalTestPage.blueButton.getText().isEmpty());
        tableVerification();
        canvasNumbersVerification();

    }

    @Step("Click Red Button")
    public void clickRedButton() {
        finalTestPage.redButton.click();
        Assert.assertTrue(!finalTestPage.redButton.getText().isEmpty());
        // tableVerification();
        canvasNumbersVerification();
    }

    @Step("Click Green Button")
    public void clickGreenButton() {
        finalTestPage.greenButton.click();
        Assert.assertTrue(!finalTestPage.greenButton.getText().isEmpty());
        //tableVerification();
        canvasNumbersVerification();
    }

    @Step("Verify the Elemental Selenium redirect")
    public void elementalSeleniumRedirectsVerification() {
        WebDriverWait wait = new WebDriverWait(finalTestPage.getDriver(), 10);
        String expectedURL="http://elementalselenium.com/";
        finalTestPage.redirectElementalSeleniumLink.click();
        ArrayList<String> tabs = new ArrayList<String> (finalTestPage.getDriver().getWindowHandles());
        finalTestPage.getDriver().switchTo().window(tabs.get(1));
        String redirectURL=finalTestPage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL,redirectURL);
        finalTestPage.getDriver().switchTo().window(tabs.get(0));
    }

    @Step("Verify the git redirect")
    public void gitRedirectVerification(){
        WebDriverWait wait = new WebDriverWait(finalTestPage.getDriver(), 10);
        String expectedURL2= "https://github.com/tourdedave/the-internet";
        finalTestPage.redirectForkMeOnGitLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-of-content")));
        String redirectURL2=finalTestPage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL2,redirectURL2);
        finalTestPage.getDriver().navigate().back();
    }

    @Step("Verify the whole table")
    public void tableVerification() {
        int m = 10;
        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("Iuvaret");
        expectedValues.add("Apeirian");
        expectedValues.add("Adipisci");
        expectedValues.add("Definiebas");
        expectedValues.add("Consequuntur");
        expectedValues.add("Phaedrum");
        for (int i = 0; i < m; i++) {
            List<WebElement> cells = finalTestPage.rows.get(i).findElements(By.cssSelector("td"));
            for (int j = 0; j < expectedValues.size(); j++) {
                System.out.print(cells.get(j).getText() + " ");
                Assert.assertEquals(cells.get(j).getText(), expectedValues.get(j) + i);
            }
            System.out.println();
        }

    }

    @Step("Canvas Numbers Verification")
    public void canvasNumbersVerification() {

        WebElement canvasNumbers = (getDriver().findElement(By.cssSelector("#content script")));
        // System.out.println(canvasNumbersTwo.getText());
        String scriptToParse = canvasNumbers.getAttribute("innerText");
        System.out.println(canvasNumbers.getAttribute("innerText"));
        Pattern pattern = Pattern.compile("Answer:\\s(\\d+)");
        Matcher matcher = pattern.matcher(scriptToParse);

        Assert.assertTrue(matcher.find());


        System.out.println(matcher.group(1));

    }
}