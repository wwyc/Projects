package ca.ubc.cpsc210.pizza.model;

import java.util.ArrayList;
import java.util.List;

// Represents a pizza

public class Pizza {
    public static final int CRUSTCOST = 5;
    public static final String INGREDIENT_DESCRIPTOR = " topped by ";
    private Crust crust;
    private List<Ingredient> ingredientlist;

    // TODO: declare a field to store the crust (every pizza must have one crust)
    // TODO: declare ONE field to store the sauce, cheese, tomatoes, peppers and any future ingredients and toppings


    // EFFECTS: pizza has a crust and empty list of ingredients
    public Pizza() {
        this.crust = new Crust(CRUSTCOST);
        this.ingredientlist = new ArrayList<Ingredient>();
    }

    // REQUIRES: newIngredient is not null
    // MODIFIES: this
    // EFFECTS: newIngredient is added to end of list of ingredients
    public void addIngredient(Ingredient newIngredient) {
        ingredientlist.add(newIngredient);
    }

    // EFFECTS: the returned string starts with CRUST_DESCRIPTOR followed by
    // all ingredients in the order in which they were added,
    // with INGREDIENT_DESCRIPTOR between each ingredient
    public String ingredientsAsString() {
        // TODO: implement method
        StringBuilder accumulator = new StringBuilder();

        accumulator.append(Crust.DESCRIPTOR);

        for (Ingredient ingredient : ingredientlist)
        {accumulator.append(INGREDIENT_DESCRIPTOR + ingredient.getName());}

        return accumulator.toString();


    }

    // EFFECTS: Return the total cost of the pizza with crust and
    // all ingredients. Total cost >= CRUSTCOST.
    public int totalCost() {
        int totalcost = 0;

        for (Ingredient ingredient : ingredientlist)
        {totalcost += ingredient.getCost();}

        totalcost += CRUSTCOST;

        return totalcost;
    }
}
