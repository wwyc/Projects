package ca.ubc.cpsc210.pizza.model;

// Represents tomatoes as a topping
public class Tomatoes extends Topping {
    public static final String DESCRIPTOR = "tomatoes";
    //private int cost;
    //private String name;

	// EFFECTS: name is set to tomatoes and cost to given cost
	public Tomatoes(int cost) {
        // TODO: implement constructor
        super(DESCRIPTOR, cost);
        //this.name = DESCRIPTOR;
        //setCost(cost);
	}
}
