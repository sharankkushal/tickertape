import org.openqa.selenium.By;

public class flipkartPage{

	
	protected webDriverActions actions;
	public static By loginCloseButton = By.xpath("//div[@class='_2QfC02']//button[@class='_2KpZ6l _2doB4z']");
	public static By loginpopup = By.xpath("//div[@class='_2MlkI1']//span[@class='_36KMOx']");
	public static By searchBar = By.xpath("//input[@title='Search for products, brands and more']");
	public static By firstSearchResult = By.xpath("//div[@class='_2kHMtA']//div[@class='_4rR01T']");
	public static By resultPrice = By.xpath("//div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']");
	public static By productPrint = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	public static By addToCartBtn = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	public static By searchPageVerification = By.xpath("//div[@class='W_R1IA']");
	public static By productTitle = By.xpath("//span[@class='B_NuCI']");
	public static By myCartText = By.xpath("//div[@class='_3g_HeN']");
	public static By cartProductTitle = By.xpath("//a[@class='_2Kn22P gBNbID']");
	public static By cartTotalAmount = By.xpath("//div[@class='_3LxTgx']//div[@class='_1dqRvU']//div[@class='Ob17DV _3X7Jj1']//span");
	public static By cartQuantityIncrease = By.xpath("//div[@class='_3dY_ZR']//button[@class='_23FHuj'][text()='+']");
	
	public flipkartPage(webDriverActions actions) {
		this.actions = actions;
	}
	
	
	public void closeLoginPopUp() {
		actions.waitForElementToBeVisible(loginpopup);
		actions.click(loginCloseButton);
	}
	
	public void searchProduct(String product) {
		actions.waitForElementToBePresent(searchBar);
		actions.type(searchBar, product);
		actions.enter(searchBar);
	}
	
	public void clickFirstResult() {
		actions.waitForElementToBeVisible(searchPageVerification);
		actions.click(firstSearchResult);
	}
	
	public String getPriceFromProductPage() {
		actions.waitForElementToBeVisible(productPrint);
		return actions.getText(productPrint);
	}
	
	public void clickAddCartButon() {
		actions.waitForElementToBeClickable(addToCartBtn);
		actions.click(addToCartBtn);
	}
	
	public void clickIncreaseQuantity() {
		actions.moveToBottom();
		actions.waitForElementToBeClickable(cartQuantityIncrease);
		actions.click(cartQuantityIncrease);
	}
	
	public String getPriceFromCart() {
		actions.waitForElementToBeVisible(cartTotalAmount);
		return actions.getText(cartTotalAmount);
	}
	
	
	public String getFirstProductTitle() {
		actions.waitForElementToBeVisible(firstSearchResult);
		return actions.getText(firstSearchResult);
	}

	public String getProductTitleFromCart(){
		actions.waitForElementToBeVisible(cartProductTitle);
		return actions.getText(cartProductTitle);
	}
	public void waitForProductPageToLoad(){
		actions.waitForElementToBeVisible(productPrint);
		actions.waitForElementToBeVisible(addToCartBtn);
		actions.waitForElementToBeVisible(productTitle);
	}

	public void waitForCartToLoad(){
		actions.waitForElementToBeVisible(myCartText);
		actions.waitForElementToBeVisible(cartProductTitle);
		actions.waitForElementToBeVisible(cartProductTitle);
	}
	
	
}
