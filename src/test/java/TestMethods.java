import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestMethods extends Setup {


    public void TCLogin(ExtentTest test, Elements elements) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driverchrome, 10);
            driverchrome.findElement(elements.MyAccount).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(elements.login)).click();

            driverchrome.findElement(elements.email).click();
            driverchrome.findElement(elements.email).sendKeys(elements.loginEmailAddress);

            wait.until(ExpectedConditions.visibilityOfElementLocated(elements.password)).click();
            driverchrome.findElement(elements.password).sendKeys(elements.loginPassword);

            driverchrome.findElement(elements.loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(elements.titlemyAccount)).click();
            if (!driverchrome.findElement(elements.titlemyAccount).getText().equals(elements.hesabim)) {
                Assert.fail(" TCLogin case FAIL !!");
                test.log(Status.FAIL, "Login case failed");
            } else {
                test.log(Status.PASS, "Login is successfull");
                test.log(Status.PASS, "The User is at Home page");
            }
        } catch (Exception e) {
            String errorMessage = e.toString();
            test.log(Status.ERROR, "General error on TCLogin " + errorMessage);
        }
    }

    public void TCSearchProduct(ExtentTest test, Elements elements) throws Exception {
        try {

            driverchrome.findElement(elements.productSearch).click();
            driverchrome.findElement(elements.productSearch).sendKeys(elements.productName);
            driverchrome.findElement(elements.buttonProductSearch).click();

            JavascriptExecutor js = (JavascriptExecutor) driverchrome;
            WebElement elementProduct = driverchrome.findElement(elements.imageProduct);
            js.executeScript("arguments[0].scrollIntoView();", elementProduct);
            driverchrome.findElement(elements.imageProduct).click();

            if (!driverchrome.findElement(elements.deliverTodayimage).isDisplayed()) {
                Assert.fail(" DeliverToday case FAIL !!");
                test.log(Status.FAIL, "DeliverToday case failed");
            } else {
                test.log(Status.PASS, "DeliverToday is visible");
                test.log(Status.PASS, "Product can be delivered today");
            }
        } catch (Exception e) {
            String errorMessage = e.toString();
            test.log(Status.ERROR, "General error on TCSearchProduct " + errorMessage);
        }
    }

    public void TCAddToCart(ExtentTest test, Elements elements) throws Exception {
        try {

            if (!driverchrome.findElement(elements.myCartTitle).isDisplayed()) {
                Assert.fail(" DeliverToday case FAIL !!");
                test.log(Status.FAIL, "User is not in Cart page");
            } else if (!driverchrome.findElement(elements.imageProductCart).isDisplayed()) {
                test.log(Status.FAIL, "Product could not be added to cart");

            } else {
                driverchrome.findElement(elements.addToCart).click();
                test.log(Status.PASS, "Product is added to cart successfully");

            }
        } catch (Exception e) {
            String errorMessage = e.toString();
            test.log(Status.ERROR, "General error on TCAddtoCart " + errorMessage);
        }
    }



}
