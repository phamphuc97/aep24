package edu.berkeley.aep;

public class Bester {
    private final Bestable[] items;

    public Bester(Bestable... items) {
        this.items = items;
    }

    public Bestable best() {
        Bestable best = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i].isBetterThan(best)) {
                best = items[i];
            }
        }
        return best;
    }
}
