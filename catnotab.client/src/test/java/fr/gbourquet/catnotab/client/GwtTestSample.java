package fr.gbourquet.catnotab.client;

import com.google.gwt.junit.client.GWTTestCase;

public class GwtTestSample extends GWTTestCase {

	public String getModuleName() {
		return "fr.gbourquet.catnotab.Catnotab";
	}

	public void testSomething() {
		// Not much to actually test in this sample app
		// Ideally you would test your Controller here (NOT YOUR UI)
		// (Make calls to RPC services, test client side model objects, test
		// client side logic, etc)
		//Assert.assertTrue(true);
	}
}