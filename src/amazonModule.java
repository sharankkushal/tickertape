public class amazonModule {

    amazonPage amazonPage;
    amazonModule(webDriverActions actions){
        amazonPage = new amazonPage(actions);
    }

    public void waitForSearchPageToLoad(){
        amazonPage.waitForSearchPageToLoad();
    }
    public void searchProduct(String product) {
        amazonPage.searchProduct(product);
    }

    public void selectFirstSearchResult() {
        amazonPage.clickFirstResult();
    }

    public String getPriceFromProductPage(){
        return amazonPage.getPriceFromProductPage();
    }

    public void waitForProductPageToLoad(){
        amazonPage.waitForProductPageToLoad();
    }

    public void clickAdToCartBtn(){
        amazonPage.clickAddCartButon();
    }

    public void clickGoToCart(){
        amazonPage.clickGoToCart();
    }

    public void waitForCartPageToLoad(){
        amazonPage.waitForCartPageToLoad();
    }

    public String getPriceOnCart(){
        return amazonPage.getPriceOnCart();
    }



}
