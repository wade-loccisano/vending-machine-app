package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {

	@Test
	public void constructor_makes_new_VendingMachine() {
		List<Vendable> list = new ArrayList<Vendable>();
		BigDecimal bd = new BigDecimal(0.00);
	
		VendingMachine expected = new VendingMachine(new ArrayList<Vendable>(), new BigDecimal(0.00));
		VendingMachine actual = new VendingMachine(list, bd);
		
		Assert.assertEquals(expected.getBalance(), actual.getBalance());
		Assert.assertEquals(expected.getList(), actual.getList());
	}

	@Test
	public void dispenseProduct_decreases_quantity_by_1() throws FileNotFoundException {
		List<Vendable> list = new ArrayList<Vendable>();
		BigDecimal bd = new BigDecimal(1.00);
		Vendable gum = new Gum("TurboMint", new BigDecimal(0.00), "Gum", "A1", 5);
		list.add(gum);
	    VendingMachine v = new VendingMachine(list, bd);
	    v = VendingMachine.dispenseProduct(v, "A1");

	    assertEquals(v.getList().get(0).getQuantity(), 4);
	}

}
