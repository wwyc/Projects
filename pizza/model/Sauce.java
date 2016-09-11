package ca.ubc.cpsc210.pizza.model;

// Represents the sauce for the pizza

public class Sauce extends Topping {
    public static final String DESCRIPTOR = "sauce";
    //private String name;
    //private int cost;

	// EFFECTS: The name is set to sauce and cost to given cost
	public Sauce(int cost) {
        // TODO: implement constructor
        super(DESCRIPTOR, cost);
        //this.name = DESCRIPTOR;
        //this.cost = cost;

	}
}
