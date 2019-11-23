package teaShop;

import ingredient.Ingredient;

/**
 * 奶茶店接口
 */
public interface Shop {
    public void stock(Ingredient ingredient);
    public void sell(String teaName, String ingredientName);
}
