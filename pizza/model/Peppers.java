package ca.ubc.cpsc210.pizza.model;

// Represent peppers as a topping

public class Peppers extends Topping {
    public static final String DESCRIPTOR = "peppers";
   //private int cost;

	// EFFECTS: The name is set to peppers and cost to given cost
	public Peppers(int cost) {
        // TODO: implement constructor
        super(DESCRIPTOR, cost);
        //String name = DESCRIPTOR;
        //getCost();
	}

}
