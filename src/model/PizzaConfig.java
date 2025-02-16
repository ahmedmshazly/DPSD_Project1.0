package model;

import java.io.Serializable;

/**
 * Represents a Pizza Configuration.
 * Holds a base price and an array of OptionSet objects.
 * Implements Serializable for archiving purposes.
 */
public class PizzaConfig implements Serializable {

    // Recommended: include a serialVersionUID for Serializable classes.
    private static final long serialVersionUID = 1L;

    private String name;
    private double basePrice;
    private OptionSet[] optionSets;
    private int optionSetCount;  // Tracks the number of OptionSet objects added

    /**
     * Constructor to initialize PizzaConfig with a name and maximum number of OptionSets.
     *
     * @param name          the name of the pizza configuration
     * @param maxOptionSets the maximum number of OptionSet entries allowed
     */
    public PizzaConfig(String name, int maxOptionSets) {
        this.name = name;
        this.basePrice = 0.0; // Default base price, can be updated later
        this.optionSets = new OptionSet[maxOptionSets];
        this.optionSetCount = 0;
    }

    // Getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Returns the OptionSet at a specified index.
     *
     * @param index the index of the OptionSet
     * @return the OptionSet object
     */
    public OptionSet getOptionSet(int index) {
        if (index >= 0 && index < optionSetCount) {
            return optionSets[index];
        }
        return null; // Alternatively, you could throw an exception for an invalid index.
    }

    /**
     * Adds an OptionSet to the PizzaConfig.
     *
     * @param optionSet the OptionSet object to add
     * @return true if added successfully, false if the array is full
     */
    public boolean addOptionSet(OptionSet optionSet) {
        if (optionSetCount < optionSets.length) {
            optionSets[optionSetCount++] = optionSet;
            return true;
        }
        return false;
    }

    /**
     * Finds an OptionSet by name.
     *
     * @param name the name of the OptionSet
     * @return the OptionSet if found; otherwise, null.
     */
    public OptionSet findOptionSet(String name) {
        for (int i = 0; i < optionSetCount; i++) {
            if (optionSets[i].getName().equalsIgnoreCase(name)) {
                return optionSets[i];
            }
        }
        return null;
    }

    /**
     * Updates an existing OptionSet with new data.
     *
     * @param name      the name of the OptionSet to update
     * @param newOptionSet the new OptionSet data
     * @return true if the update was successful, false otherwise
     */
    public boolean updateOptionSet(String name, OptionSet newOptionSet) {
        for (int i = 0; i < optionSetCount; i++) {
            if (optionSets[i].getName().equalsIgnoreCase(name)) {
                optionSets[i] = newOptionSet;
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes an OptionSet by name.
     *
     * @param name the name of the OptionSet to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteOptionSet(String name) {
        for (int i = 0; i < optionSetCount; i++) {
            if (optionSets[i].getName().equalsIgnoreCase(name)) {
                // Shift remaining elements to the left
                for (int j = i; j < optionSetCount - 1; j++) {
                    optionSets[j] = optionSets[j + 1];
                }
                optionSets[--optionSetCount] = null; // Clear the last element
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the details of the PizzaConfig.
     */
    public void print() {
        System.out.println("Pizza Configuration: " + name);
        System.out.println("Base Price: " + basePrice);
        System.out.println("Option Sets:");
        for (int i = 0; i < optionSetCount; i++) {
            optionSets[i].print();
        }
    }
}
