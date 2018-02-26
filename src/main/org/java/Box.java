package org.java;

import java.util.ArrayList;

import org.java.util.Constant;

/**
 * A box represents a cardboard box that can be filled up with a specific number of product, see {@link Product}.
 * A box can contain up to 10, inclusive, weight-unit product. 
 * 
 * @author auzias
 *
 */
public class Box {
    private ArrayList<Product> products;

    /**
     * Constructs an empty Box.
     */
    public Box() {
	this.products = new ArrayList<>(); 
    }

    /**
     * Adds a product if the box supports it and returns true if the product was added.
     * @param p product to add to a box.
     * @return true if the product was added.
     */
    public boolean addProduct(Product p) {
	boolean ret = false;
	int productWeight = p.getWeight();
	int currentWeight = this.getTotalWeight();
	int futureWeight = currentWeight + productWeight;
	if (futureWeight <= Constant.BOX_MAXIMAL_WEIGHT) {
	    this.products.add(p);
	    currentWeight = this.getTotalWeight();
	    ret = true;
	}
	return ret;
    }

    /**
     * Returns the total weight of products contained in the box (the weight box is considered neglectable).
     * @return
     */
    public int getTotalWeight() {
	int summedWeight = 0;
	for (Product p : this.products) {
	    summedWeight += p.getWeight();
	}
	return summedWeight;
    }

    public ArrayList<Product> getProducts() {
	return this.products;
    }
}
