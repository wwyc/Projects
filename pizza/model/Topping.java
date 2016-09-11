package ca.ubc.cpsc210.pizza.model;

// represents a topping on a pizza
public abstract class Topping extends Ingredient implements Surchargeable{
    private int surcharge;
    //private int cost;
    //private String name;

    // EFFECTS: topping has given name, cost and the surcharge is zero
    public Topping(String name, int cost) {
        // TODO: implement constructor
        super(name, cost);
        //this.name = name;
        surcharge = 0;
        //this.cost = cost;

    }

    @Override
    public void setSurcharge(int surcharge) {
        this.surcharge = surcharge;
    }

    // TODO: override getCost so that surcharge is added to basic cost

    public int getCost() {
        return super.getCost() + surcharge;
    }
}
