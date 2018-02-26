package org.java;

public class Launcher {

    public static void main(String[] args) {
	if (args.length == 0) {
	    System.out.println("Usage: java -jar xspeedit numberOfProductToWrap");
	    System.out.println("\t numberOfProductToWrap: integer, strictly positive.");
	    return;
	}
	int numberOfProductToWrap = Integer.parseInt(args[0]);
	Wrapper wrapper = new Wrapper();
	wrapper.wrap(numberOfProductToWrap);
    }
}
