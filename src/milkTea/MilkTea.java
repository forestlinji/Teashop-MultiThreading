package milkTea;

import ingredient.Ingredient;

public class MilkTea {
    private String name;
    private Ingredient ingredient;

    public MilkTea() {
    }

    public MilkTea(String name, Ingredient ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "MilkTea{" +
                "name='" + name + '\'' +
                ", ingredient=" + ingredient +
                '}';
    }
}
