package test.three.stripes.page.store.sample;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.three.stripes.base.BasePage;

import static org.testng.Assert.assertEquals;
import static test.three.stripes.log.ExtentReportLog.logger;

/**
 * considering that only sample page is redirecting to this error page
 */
public class ErrorPage extends BasePage {

    public ErrorPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(body));
    }

    @FindBy(css = "body[id=error-page]")
    private WebElement body;

    @FindBy(css = "body[id=error-page] :nth-of-type(2)")
    private WebElement errorMsg;

    @FindBy(css = "body[id=error-page] :nth-of-type(4) a")
    private WebElement backLink;

    public SamplePage backToSamplePage(){
        backLink.click();
        return new SamplePage(driver);
    }

    public ErrorPage verifyInvalidEmail(){
        assertEquals(errorMsg.getText().trim(), "ERROR: please enter a valid email address." );
        logger.log(Status.PASS, MarkupHelper.createLabel("Error occurred as expected", ExtentColor.GREEN));
        return this;
    }
}
