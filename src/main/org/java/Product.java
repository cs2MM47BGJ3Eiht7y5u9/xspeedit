package org.java;

/**
 * A product is produced by a chain and weights between 1 and 9 weight-unit.
 * @author auzias
 *
 */
public class Product {
    private int weight;

    /**
     * Constructs a product with a given weight.
     * @param weight the given weight of the product.
     * @throws IllegalWeightException if the product weight is not compliant.
     */
    public Product(int weight) throws IllegalWeightException {
	WeightHelper.checkWeight(weight, Constant.PRODUCT_MAXIMAL_WEIGHT);
	this.weight = weight;
    }

    /**
     * Returns the weight of the product.
     * @return the weight of the product.
     */
    public int getWeight()  {
	return this.weight;
    }
}
