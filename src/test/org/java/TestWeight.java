package org.java;

import static org.junit.Assert.*;

import org.java.util.IllegalWeightException;
import org.junit.Test;

public class TestWeight {

    @Test
    public void boxTooHeavy() {
	Box box = new Box();
	Product p = null;
	try {
	    p = new Product(9);
	    boolean firstAttempt = box.addProduct(p);
	    assertTrue(firstAttempt);
	    boolean secondAttempt = box.addProduct(p);
	    assertFalse("Box shall be too heavy for the second product", secondAttempt);
	} catch (IllegalWeightException e) {
	}
    }

    @Test
    public void productTooHeavy() {
	boolean ex = false;
	try {
	    new Product(10);
	} catch (IllegalWeightException e) {
	    ex = true;
	}
	assertTrue("Product shall be created with weight over 10", ex);
    }

    @Test
    public void productTooLight() {
	boolean ex = false;
	try {
	    new Product(0);
	} catch (IllegalWeightException e) {
	    ex = true;
	}
	assertTrue("Product shall be created with weight under 0", ex);
    }
}
