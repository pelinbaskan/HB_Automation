import org.openqa.selenium.By;

public class Elements {

    //Login
    By MyAccount = By.id("MyAccount");
    By login = By.id("login");
    By email = By.id("email");
    String loginEmailAddress = "test@gmail.com";
    By password = By.id("password");
    String loginPassword = "1234";
    By loginButton = By.cssSelector("#form-login > div.form-actions > button");
    By titlemyAccount = By.cssSelector("#myAccount > a:nth-child(1)");
    String hesabim = "Hesabım";

    //Search
    By productSearch = By.id("productSearch");
    By buttonProductSearch = By.id("buttonProductSearch");

    String productName = "Asus Vivobook X542UR-GQ029T";
    By imageProduct = By.cssSelector("#aa663c3d-86a5-4280-93b5-8e7c7f75dd05 > div > div > ul > li > div > a > div > h3");

//deliver today and add to cart
    By deliverTodayimage = By.cssSelector("#badges > div > a:nth-child(1) > span > img");
    By addToCart = By.id("addToCart");

    //add to cart
    By myCartTitle = By.cssSelector("#cart-container > section > div:nth-child(3) > header > h1");
    By imageProductCart = By.cssSelector("#form-item-list > ul > li:nth-child(1) > div > div.product-detail > h4 > a");
}
