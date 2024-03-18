package edu.berkeley.aep;

public class Chance implements Bestable{
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Chance)) return false;
        return Double.compare(((Chance) other).probability, probability) == 0;
    }

    // Always override hashCode if overriding equals
    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    // Implement complement rule in accordance to the axiom of probability
    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance other) {
        return new Chance(probability * other.probability);
    }

    // Use DeMorgan's Law
    public Chance or(Chance other) {
        Chance andOfNots = not().and(other.not());
        return andOfNots.not();
    }

    @Override
    public boolean isBetterThan(Bestable other) {
        Chance otherChance = (Chance) other;
        return otherChance.probability < this.probability;
    }
}
