package serenity_test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FinalTestPage extends PageObject {

    @FindBy(css = "#content > div > h3")
    public WebElementFacade title;

    @FindBy(css = "#content > div > p")
    public WebElementFacade descriptionParagraph;

    @FindBy(css = "div:nth-child(2) div div div div div:nth-child(1) a:nth-child(1)")
    public WebElementFacade blueButton;

    @FindBy(css = "div:nth-child(2) div div div div div:nth-child(1) a:nth-child(3)")
    public WebElementFacade redButton;

    @FindBy(css = "div:nth-child(2) div div div div div:nth-child(1) a:nth-child(5)")
    public WebElementFacade greenButton;

    @FindBy(css = "tbody tr")
    public List<WebElementFacade> rows;

    //css = "#page-footer > div > div > a"
    @FindBy(linkText = "Elemental Selenium")
    public WebElementFacade redirectElementalSeleniumLink;

    @FindBy(css = "body > div:nth-child(2) > a > img")
    public WebElementFacade redirectForkMeOnGitLink;

}