package org.java;

import java.util.ArrayList;
import java.util.Random;

import org.java.util.Constant;
import org.java.util.IllegalWeightException;

/**
 * Producer produces product with random weight.
 * <p>
 * {@link java.util.Random} is used, rather than {@link java.util.concurrent.ThreadLocalRandom}, in order to be able to set a specific seed. 
 * @author auzias
 */
public class Producer {
    private Random random;

    public Producer() {
	long seed = getRandomSeed();
	random = new Random(seed);
    }

    /**
     * Returns a new product.
     * @return the new, fresh, hand-made and organic product just produced!
     */
    public Product getNewProduct() {
	int weight = random.nextInt(Constant.PRODUCT_MAXIMAL_WEIGHT) + 1;
	Product p = null;
	try {
	    p = new Product(weight);
	} catch (IllegalWeightException e) {
	    // Very unlikely to happen
	    e.printStackTrace();
	}
	return p;
    }

    /**
     * Returns a given number of new products.
     * @param n the given number of products to returned.
     * @return the list of these new products.
     */

    public ArrayList<Product> getNProduct(int n) {
	ArrayList<Product> products = new ArrayList<>(n);
	for (int i = 0; i < n; i++) {
	    products.add(getNewProduct());
	}
	return products;
    }

    private long getRandomSeed() {
	// see https://www.xkcd.com/221/
	return 42;
    }
}
