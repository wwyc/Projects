package ca.ubc.cpsc210.pizza.model;

// Represent the cheese for a pizza

public class Cheese extends Ingredient {
    public static final String DESCRIPTOR = "cheese";
    //public String name;
    //public int cost;

	// EFFECTS: name is set to DESCRIPTOR, cost is set to given cost
	public Cheese(int cost) {
        // TODO: implement constructor
        super(DESCRIPTOR, cost);
       // this.name = DESCRIPTOR;
        //this.cost = cost;

	}

    // EFFECTS: name is set to cheeseName + " " + DESCRIPTOR, cost is set to given cost
    public Cheese(String cheeseName, int cost) {
        // TODO: implement constructor
        super((cheeseName + " " +  DESCRIPTOR), cost);
        //this.name = cheeseName + " " +  DESCRIPTOR;
        //this.cost = cost;
    }
}
