package model;

import java.io.Serializable;

/**
 * Represents a set of options for a PizzaConfig.
 * Uses a partially-filled array to manage Option objects.
 */
public class OptionSet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Option[] options;
    private int optionCount; // Tracks the number of Option objects added

    /**
     * Constructor to initialize OptionSet with a name and maximum number of options.
     *
     * @param name        the name of the option set
     * @param maxOptions  the maximum number of Option entries allowed
     */
    public OptionSet(String name, int maxOptions) {
        this.name = name;
        this.options = new Option[maxOptions];
        this.optionCount = 0;
    }

    // Getter and setter for name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the Option at the specified index.
     *
     * @param index the index of the Option
     * @return the Option object, or null if index is invalid
     */
    public Option getOption(int index) {
        if (index >= 0 && index < optionCount) {
            return options[index];
        }
        return null;
    }

    /**
     * Adds an Option to the OptionSet.
     *
     * @param option the Option object to add
     * @return true if added successfully, false if the array is full
     */
    public boolean addOption(Option option) {
        if (optionCount < options.length) {
            options[optionCount++] = option;
            return true;
        }
        return false;
    }

    /**
     * Finds an Option by name.
     *
     * @param name the name of the Option
     * @return the Option if found; otherwise, null.
     */
    public Option findOption(String name) {
        for (int i = 0; i < optionCount; i++) {
            if (options[i].getName().equalsIgnoreCase(name)) {
                return options[i];
            }
        }
        return null;
    }

    /**
     * Updates an Option's price by its name.
     *
     * @param name     the name of the Option to update
     * @param newPrice the new price for the Option
     * @return true if update was successful; false otherwise
     */
    public boolean updateOption(String name, double newPrice) {
        Option opt = findOption(name);
        if (opt != null) {
            opt.setPrice(newPrice);
            return true;
        }
        return false;
    }

    /**
     * Deletes an Option by name.
     *
     * @param name the name of the Option to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteOption(String name) {
        for (int i = 0; i < optionCount; i++) {
            if (options[i].getName().equalsIgnoreCase(name)) {
                // Shift remaining elements left
                for (int j = i; j < optionCount - 1; j++) {
                    options[j] = options[j + 1];
                }
                options[--optionCount] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Prints the details of the OptionSet and its Options.
     */
    public void print() {
        System.out.println("\tOption Set: " + name);
        for (int i = 0; i < optionCount; i++) {
            System.out.println("\t\t" + options[i]);
        }
    }

    /**
     * The inner class representing an individual Option.
     */
    public class Option implements Serializable {

        private static final long serialVersionUID = 1L;

        private String name;
        private double price;

        /**
         * Constructor to initialize an Option with a name and price.
         *
         * @param name  the name of the option
         * @param price the additional price for the option
         */
        public Option(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Getters and setters for Option properties

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Option[name=" + name + ", price=" + price + "]";
        }
    }
}
