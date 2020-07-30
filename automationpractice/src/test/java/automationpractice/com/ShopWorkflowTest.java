package automationpractice.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationpractice.com.pageObject.Cart;
import automationpractice.com.pageObject.Clothes;
import automationpractice.com.pageObject.ShoppingActions;

public class ShopWorkflowTest {

    private WebDriver driver;
    private Actions action;

    private Clothes clothes;
    private Cart cart;
    private ShoppingActions shoppingActions;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        action = new Actions(driver);
        clothes = new Clothes(driver);
        cart = new Cart(driver);
        shoppingActions = new ShoppingActions(driver);
        String baseUrl = "http://automationpractice.com/index.php";
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void closeAll() {
        driver.quit();
    }

    @Test(priority = 1)
    public void selectClothes() {
        Assert.assertTrue(clothes.getDressesBtn().isDisplayed());

        action.moveToElement(clothes.getDressesBtn()).perform();

        Assert.assertTrue(clothes.getSummerDressesBtn().isDisplayed());

        action.moveToElement(clothes.getSummerDressesBtn()).perform();
        clothes.getSummerDressesBtn().click();

        Assert.assertTrue(clothes.getSummerDressProduct(1).isDisplayed());
        Assert.assertTrue(clothes.getSummerDressProduct(2).isDisplayed());
        Assert.assertTrue(clothes.getSummerDressProduct(3).isDisplayed());
        Assert.assertEquals(clothes.getDressesCount().size(), 3);

        action.moveToElement(clothes.getSummerDressProduct(1)).perform();
        action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

        Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

        action.click(shoppingActions.getAddToCartBtn()).build().perform();
        action.click(shoppingActions.getContinueShopingBtn()).build().perform();

        Assert.assertTrue(shoppingActions.getContinueShopingBtn().isDisplayed());

        action.moveToElement(cart.getCartTab()).perform();

        Assert.assertEquals(cart.getCartProductsQty().size(), 1);

    }

}
