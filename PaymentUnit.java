package ca.ubc.cs.cpsc210.machine.model;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Represents the payment unit in a vending machine.
 */
public class PaymentUnit {
    private int numLoonies;   // number of loonies banked in machine for making change
    private int numQuarters;  // number of quarters banked in machine for making change
    private int numDimes;     // number of dimes banked in machine for making change
    private int numNickels;   // number of nickels banked in machine for making change
    private List<Coin> currentTransaction;   // list of coins inserted into machine during current transaction

    // EFFECTS: constructs a payment unit with no banked coins and no coins inserted into the machine
    // as part of a payment
    public PaymentUnit() {
        //TODO: complete implementation
        clearCoinsBanked();
        this.currentTransaction = new ArrayList<Coin>();

    }

    // MODIFIES: this
    // EFFECTS: clears all the coins banked in the unit
    public void clearCoinsBanked() {
        //TODO: complete implementation
        this.numLoonies = 0;
        this.numQuarters = 0;
        this.numDimes = 0;
        this.numNickels = 0;
    }

    // REQUIRES: number > 0
    // MODIFIES: this
    // EFFECTS: adds number coins of type c to the banked coins in the unit
    public void addCoinsToBanked(Coin c, int number) {
        //TODO: complete implementation
        switch (c) {
            case LOONIE:
                numLoonies = number + numLoonies;
                break;

            case QUARTER:
                numQuarters += number;
                break;

            case DIME:
                numDimes += number;
                break;

            case NICKEL:
                numNickels += number;
                break;
        }
    }

    // EFFECTS: returns number of coins banked of the given type
    public int getNumberOfCoinsBankedOfType(Coin c) {
        //TODO: complete implementation
        switch (c) {
            case LOONIE:
                return numLoonies;

            case QUARTER:
                return numQuarters;

            case DIME:
                return numDimes;

            default:
                return numNickels;
        }
    }

    // EFFECTS: returns the total value of all coins banked in the unit
    public int getValueOfCoinsBanked() {
        //TODO: complete implementation
        return ((Coin.LOONIE.getValue() * (getNumberOfCoinsBankedOfType(Coin.LOONIE)))
                + (Coin.QUARTER.getValue() * getNumberOfCoinsBankedOfType(Coin.QUARTER))
                + (Coin.DIME.getValue() * getNumberOfCoinsBankedOfType(Coin.DIME))
                + (Coin.NICKEL.getValue() * getNumberOfCoinsBankedOfType(Coin.NICKEL)));
    }


    // MODIFIES: this
    // EFFECTS: adds coin c to the unit as a part of a transaction
    public void insertCoin(Coin c) {
        //TODO: complete implementation
        switch (c) {
            case LOONIE:
                currentTransaction.add(0, Coin.LOONIE);
                break;

            case QUARTER:
                currentTransaction.add(0, Coin.QUARTER);
                break;

            case DIME:
                currentTransaction.add(0, Coin.DIME);
                break;

            case NICKEL:
                currentTransaction.add(0, Coin.NICKEL);
                break;
        }
    }

    // EFFECTS: returns value of coins inserted for current transaction
    public int getValueOfCoinsInserted() {
        //TODO: complete implementation
        int total = 0;
        for (Coin c : currentTransaction) {
            total += c.getValue();
        }
        return total;
    }


    // MODIFIES: this
    // EFFECTS: coins inserted for current transaction are cleared; list of coins
    // inserted for current transaction is returned in the order in which they were inserted.
    public List<Coin> cancelTransaction() {
        //TODO: complete implementation
        List<Coin> insertedcoins = currentTransaction;
        currentTransaction = new ArrayList<Coin>();
        return insertedcoins;
    }

    // REQUIRES: cost <= total value of coins inserted as part of current transaction
    // MODIFIES: this
    // EFFECTS: adds coins inserted to coins banked in unit and returns list of coins that will be provided as change.
    // Coins of largest possible value are used when determining the change.  Change in full is not guaranteed -
    // will provide only as many coins as are banked in the machine, without going over the amount due.
    public List<Coin> makePurchase(int cost) {
        //TODO: complete implementation
        //add inserted coins to coins banked
        for (Coin c : currentTransaction) {
            addCoinsToBanked(c, 1);
        }

        List<Coin> coinsReturned = new ArrayList<Coin>();

        int amountChangeNeeded = getValueOfCoinsInserted() - cost;

        if (amountChangeNeeded > 0) {
            int numberLooniesReturned = Math.min(numLoonies, amountChangeNeeded / Coin.LOONIE.getValue());
            amountChangeNeeded -= (numberLooniesReturned * Coin.LOONIE.getValue());
            numLoonies -= numberLooniesReturned;

            for (int i = 0; i<numberLooniesReturned; i++)
            {coinsReturned.add(Coin.LOONIE);}

        }
        if (amountChangeNeeded > 0) {
            int numberQuartersReturned = Math.min(numQuarters, amountChangeNeeded / Coin.QUARTER.getValue());
            amountChangeNeeded -= (numberQuartersReturned * Coin.QUARTER.getValue());
            numQuarters -= numberQuartersReturned;

            for (int i = 0; i<numberQuartersReturned; i++)
            {coinsReturned.add(Coin.QUARTER);}
        }

        if (amountChangeNeeded > 0) {
            int numberDimesReturned = Math.min(numDimes, amountChangeNeeded / Coin.DIME.getValue());
            amountChangeNeeded -= (numberDimesReturned * Coin.DIME.getValue());
            numDimes -= numberDimesReturned;

            for (int i = 0; i<numberDimesReturned; i++)
            {coinsReturned.add(Coin.DIME);}
        }

        if (amountChangeNeeded > 0) {
            int numberNickelsReturned = Math.min(numNickels, amountChangeNeeded / Coin.NICKEL.getValue());
            amountChangeNeeded -= (numberNickelsReturned * Coin.NICKEL.getValue());
            numNickels -= numberNickelsReturned;

            for (int i = 0; i<numberNickelsReturned; i++)
            {coinsReturned.add(Coin.NICKEL);}
        };
        cancelTransaction();
        return coinsReturned;

    }

}
