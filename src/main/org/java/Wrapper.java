package org.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.java.util.IllegalWeightException;

/**
 * This wrapper creates its own producer. It can then wrap a given number of product.
 * <p>
 * To wrap a list of products, this wrapper first sorts these products from the heaviest to the lightest and then fills
 * each box with the maximum number of heavy products and then with the maximum of lightest products.
 * @author auzias
 */
public class Wrapper {
    private static final boolean HEAVY_PRODUCT = true;
    private static final boolean LIGHT_PRODUCT = false;
    private static final String SEPARATOR = "/";
    private Producer producer;

    public Wrapper() {
	this.producer = new Producer();
    }

    /**
     * Wraps a given number of product.
     * @param numberOfProduct
     * @throws IllegalWeightException 
     */
    public void wrap(int numberOfProduct) {
	if (numberOfProduct <= 0) throw new IllegalArgumentException("numberOfProduct must be stricly positive.");
	// Produce N products
	ArrayList<Product> products = this.producer.getNProduct(numberOfProduct);
	// Print these product as required
	printProducts(products);
	// sort the products from the heaviest to the lightest
	Collections.sort(products, new Comparator<Product>() {
	    @Override
	    public int compare(Product p1, Product p2) {
		return  p2.getWeight() - p1.getWeight();
	    }
	});

	// Guess the minimal number of boxes (if product could be cut so **all** boxes could be full).
	// This number is less than the optimized number of boxes.
	int guessedBoxesNumber = 0;
	for (Product product : products) {
	    guessedBoxesNumber += product.getWeight();
	}
	guessedBoxesNumber /= 10;

	// Initialization of the wrapping
	ArrayList<Box> boxes = new ArrayList<>();
	int boxIdx = -1;

	// Wrapping algorithm: a box is first filled with as many as heavy product and then with light product
	do {
	    boxes.add(new Box());
	    boxIdx++;
	    Box currentBox = boxes.get(boxIdx);
	    fillBox(products, currentBox, HEAVY_PRODUCT);
	    fillBox(products, currentBox, LIGHT_PRODUCT);
	} while (!products.isEmpty());

	// Print all boxes
	printBoxes(boxes, guessedBoxesNumber);
    }

    /**
     * Fill a box with heavy or light products.
     * @param products sorted list of products to wrap.
     * @param currentBox the current box to fill.
     * @param heavy true if the box shall be filled with heavy product, false otherwise.
     */
    private void fillBox(ArrayList<Product> products,
	    Box currentBox, boolean heavy) {
	// If the list of product is already empty, do nothing
	if (products.isEmpty()) return;
	
	// Set the idex of product to pick
	int productIdx = -1;
	if (heavy) {
	    productIdx = 0;
	} else {
	    productIdx = products.size() - 1;
	}

	boolean productedAdded = true;
	while (productedAdded && !products.isEmpty()) {
	    productedAdded = currentBox.addProduct(products.get(productIdx));
	    // Remove the product from the list if it has been added
	    if (productedAdded) {
		products.remove(productIdx);
		// Update the index of product (nothing to do if heavy)
		if (!heavy) {
		    productIdx = products.size() - 1;
		}
	    }
	}
    }

    private void printProducts(ArrayList<Product> products) {
	System.out.print("Product: ");
	for (Product product : products) {
	    System.out.print(product.getWeight());
	}
	System.out.println();
    }

    private void printBoxes(ArrayList<Box> boxes, int guessedBoxesNumber) {
	System.out.print("Boxes:\t ");
	for (Box box : boxes) {
	    for (Product product : box.getProducts()) {
		System.out.print(product.getWeight());
	    }
	    System.out.print(SEPARATOR);
	}
	System.out.println("\n" + boxes.size() + " boxes used (against " + guessedBoxesNumber + " guessed).");
    }
}
