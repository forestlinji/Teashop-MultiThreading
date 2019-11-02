package ingredient;

import java.util.Calendar;

public class Coconut extends Ingredient{
    public Coconut(String name, Calendar productionDate) {
        super(name, productionDate, 5);
    }

    @Override
    public String toString() {
        return "Coconut{"+super.toString()+"}";
    }

}
