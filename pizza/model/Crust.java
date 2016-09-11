package ca.ubc.cpsc210.pizza.model;

// Represent the crust of the pizza

public class Crust extends Ingredient {
    public static final String DESCRIPTOR = "crust";
    //private String name;
    //private int cost;

	// EFFECTS: The name is set to crust and cost to given cost
	public Crust(int cost){
        // TODO: implement constructor
        super(DESCRIPTOR, cost);
        //this.name = DESCRIPTOR;
        //this.cost = cost;


    }

}
