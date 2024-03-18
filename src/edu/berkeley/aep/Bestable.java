package edu.berkeley.aep;

public interface Bestable<T extends Bestable<T>>  {
    boolean isBetterThan(T other);
}
