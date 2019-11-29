package teaShop;

public interface Shop {
    public void stock(Ingredient ingredient);
    public void sell(String teaName, String ingredientName);
}
