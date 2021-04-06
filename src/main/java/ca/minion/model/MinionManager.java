package ca.minion.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class acts as a manager that is able to place
 * Minions into an array, it can then manage the array
 * of Minions by adding, removing, knowing the size of the array,
 * and their index position.
 */

public class MinionManager implements Iterable<Minion> {
    private List<Minion> minions = new ArrayList<>();

    public void add(Minion minion){
        minions.add(minion);
    }

    public int size(){
        return this.minions.size();
    }

    public Minion getIndex(int i){
        return minions.get(i);
    }

    public Minion remove(int i){
        return minions.remove(i);
    }

    @Override
    public Iterator<Minion> iterator() {
        return minions.iterator();
    }
}
