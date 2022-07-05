import org.openqa.selenium.By;

public class amazonPage {

    protected webDriverActions actions;

    public static By searchTab = By.cssSelector("div.nav-search-field input");

    public static By searchBtn = By.cssSelector("input#nav-search-submit-button");

    public static By firstSearchResult = By.cssSelector("div[data-index='1'] span");

    public static By resultPageVerification = By.cssSelector("span[data-component-type='s-search-results']");

    public static By productPageTitle = By.id("title_feature_div");
    public static By productPageImage = By.cssSelector("div#imageBlock");
    public static By priceOnProductPage = By.xpath("//div[@class='a-section a-spacing-none aok-align-center']//span[@aria-hidden='true']");

    public static By addToCartBtn = By.cssSelector("input#add-to-cart-button");

    public static By addedToCartMsg = By.cssSelector("div#attachDisplayAddBaseAlert");

    public static By goToCartBtn = By.cssSelector("span#attach-sidesheet-view-cart-button");

    public static By cartPage = By.cssSelector("div#sc-active-cart");

    public static By priceOnCart = By.cssSelector("span#sc-subtotal-amount-buybox");

    public amazonPage(webDriverActions actions) {
        this.actions = actions;
    }

    public void searchProduct(String product) {
        actions.waitForElementToBePresent(searchTab);
        actions.type(searchTab, product);
        actions.sleep(2);
        actions.click(searchBtn);
    }

    public void clickFirstResult() {
        actions.waitForElementToBeVisible(resultPageVerification);
        actions.click(firstSearchResult);
    }

    public String getPriceFromProductPage() {
        actions.waitForElementToBeVisible(priceOnProductPage);
        return actions.getText(priceOnProductPage).trim();
    }

    public void clickAddCartButon() {
        actions.waitForElementToBeClickable(addToCartBtn);
        actions.click(addToCartBtn);
        actions.waitForElementToBeVisible(addedToCartMsg);
    }

    public void clickGoToCart(){
        actions.waitForElementToBeClickable(goToCartBtn);
        actions.click(goToCartBtn);
    }

    public void waitForCartPageToLoad(){
        actions.waitForElementToBeVisible(cartPage);
        actions.waitForElementToBeVisible(priceOnCart);
    }

    public String getPriceOnCart(){
        actions.waitForElementToBeVisible(priceOnCart);
        return actions.getText(priceOnCart).trim();
    }

    public void waitForProductPageToLoad(){
        actions.waitForElementToBeVisible(priceOnProductPage);
        actions.waitForElementToBeVisible(productPageImage);
        actions.waitForElementToBeVisible(productPageTitle);
    }

    public void waitForSearchPageToLoad(){
        actions.waitForElementToBeVisible(searchBtn);
        actions.waitForElementToBeVisible(searchTab);
    }







}
