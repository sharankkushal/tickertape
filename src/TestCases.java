import org.testng.annotations.Test;

public class TestCases {

	//Please update the path of the driver in webDriverActions class before running the test case

	@Test
	public void scenario1() {
		webDriverActions actions = new webDriverActions();
		flipkartModule flipkartModule = new flipkartModule(actions);
		actions.openURL("https://www.flipkart.com/");
		flipkartModule.closeLoginPopup();
		flipkartModule.searchProduct("iphone 12");
		flipkartModule.selectFirstSearchResult();
		actions.switchToWindow();
		flipkartModule.waitForProductPageToLoad();
		String priceOfOne = flipkartModule.getPriceFromProductPage();
		System.out.println("Price of 1 product = " + priceOfOne);
		flipkartModule.clickAdToCartBtn();
		flipkartModule.waitForCartToLoad();
		flipkartModule.increaseProductQuantity();
		if (priceOfOne.equals(flipkartModule.getUpdatedPriceFromCart()))
			actions.sleep(5);
		System.out.println("Price after increasing quantity = " + flipkartModule.getUpdatedPriceFromCart());
		actions.stopSelenium();

		}

		@Test
	public void scenario2(){
			webDriverActions actions = new webDriverActions();
			flipkartModule flipkartModule = new flipkartModule(actions);
			amazonModule amazonModule = new amazonModule(actions);
			actions.openURL("https://www.flipkart.com/");
			flipkartModule.closeLoginPopup();
			flipkartModule.searchProduct("iphone 12 Black");
			flipkartModule.selectFirstSearchResult();
			actions.switchToWindow();
			flipkartModule.waitForProductPageToLoad();
			String flipkartProductPagePrice = flipkartModule.getPriceFromProductPage();
			System.out.println("Flipkart's Price From Product Page = " + flipkartProductPagePrice);
			flipkartModule.clickAdToCartBtn();
			flipkartModule.waitForCartToLoad();
			String productName = flipkartModule.getProductTitleFromCart();
			String flipkartCartPagePrice = flipkartModule.getUpdatedPriceFromCart();
			System.out.println("Flipkart's Price From Cart = " + flipkartCartPagePrice);

			actions.openURL("https://www.amazon.in/");
			amazonModule.waitForSearchPageToLoad();
			amazonModule.searchProduct(productName);
			amazonModule.selectFirstSearchResult();
			actions.switchToWindow();
			amazonModule.waitForProductPageToLoad();
			String amazonProductPagePrice = amazonModule.getPriceFromProductPage();
			System.out.println("Amazon's Price From Product Page = " + amazonProductPagePrice.split("\n")[0]);
			amazonModule.clickAdToCartBtn();
			amazonModule.clickGoToCart();
			amazonModule.waitForCartPageToLoad();
			String amazonCartPagePrice = amazonModule.getPriceOnCart().split("\\.")[0];
			System.out.println("Amazon's Price From Cart = " + amazonCartPagePrice);

			int result = actions.compareTwoCurrencyString(flipkartCartPagePrice.replaceAll("[^0-9]", ""),amazonCartPagePrice.replaceAll("[^0-9]", ""));

			if (result == -1){
				System.out.println("Flipkart has the lower Price i.e " + flipkartCartPagePrice);
			}else if (result == 1){
				System.out.println("Amazon has the lower Price i.e " + amazonCartPagePrice);
			}else if (result == 0){
				System.out.println("Both the site has same price i.e " + flipkartCartPagePrice);
			}

			actions.stopSelenium();


		}




}
