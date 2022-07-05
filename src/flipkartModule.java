
public class flipkartModule {

	flipkartPage flipkartpage;
	flipkartModule(webDriverActions actions){
		flipkartpage = new flipkartPage(actions);
	}
	
	
	public void closeLoginPopup() {
		flipkartpage.closeLoginPopUp();
	}
	
	public void searchProduct(String product) {
		flipkartpage.searchProduct(product);
	}
	
	public void selectFirstSearchResult() {
		flipkartpage.clickFirstResult();
	}

	public String getPriceFromProductPage(){
		return flipkartpage.getPriceFromProductPage();
	}

	public void waitForProductPageToLoad(){
		flipkartpage.waitForProductPageToLoad();
	}

	public void clickAdToCartBtn(){
		flipkartpage.clickAddCartButon();
	}

	public void waitForCartToLoad(){
		flipkartpage.waitForCartToLoad();
	}

	public void increaseProductQuantity(){
		flipkartpage.clickIncreaseQuantity();
		flipkartpage.waitForCartToLoad();
	}
	public String getUpdatedPriceFromCart(){
		return flipkartpage.getPriceFromCart();
	}

	public String getProductTitleFromCart(){
		return flipkartpage.getProductTitleFromCart();
	}

}
