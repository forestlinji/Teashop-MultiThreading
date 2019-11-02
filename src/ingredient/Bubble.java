package ingredient;

import java.util.Calendar;

public class Bubble extends Ingredient{
    public Bubble(String name, Calendar productionDate) {
        super(name, productionDate, 7);
    }

    public String toString() {
        return "Bubble{"+super.toString()+"}";
    }

}
