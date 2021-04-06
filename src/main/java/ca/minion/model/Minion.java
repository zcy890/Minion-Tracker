package ca.minion.model;

/**
 * The Class is a template to constructing each Minion,
 * can also be used to manage their individual history
 * of Evil Deed(s)
 */
public class Minion {
    private String name;
    private double height;
    private int num_of_evil_deeds;

    public Minion(String name, double height) {
        this.name = name;
        this.height = height;
        this.num_of_evil_deeds = 0;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getNum_of_evil_deeds() {
        return num_of_evil_deeds;
    }

    public void addEvilDeeds(){
        this.num_of_evil_deeds++;
        System.out.println(this.name + " has now down " + this.num_of_evil_deeds + " evil deed(s)!");
    }

    @Override
    public String toString() {
        return  getClass().getName() +
                "[Name:" + name + ", " +
                "Evil deeds:" + num_of_evil_deeds + ", " +
                "Height:" + height + "]";
    }
}
