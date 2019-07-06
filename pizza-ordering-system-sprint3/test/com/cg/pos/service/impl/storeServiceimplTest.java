package com.cg.pos.service.impl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.service.StoreService;

public class storeServiceimplTest {

	private StoreService storeService;

	@Before
	public void setUp() throws Exception {
		storeService = new StoreServiceImpl();
	}

	@Test(expected = StoreExceptions.class)
	public void testStoreNameNumber() throws StoreExceptions, SQLException {
		String actual = storeService.deleteStoreDetails(new StoreDetailsDTO(12345, "hello", "airoli", "#$F456789", "harry"));
		assertEquals("Enter Valid Store Name in alphabets within the length of 15 ", actual);
	}

	@Test(expected = StoreExceptions.class)
	public void testStoreNameSplChar() throws StoreExceptions, SQLException {
		String actual = storeService.viewStoreDetails("@#$%^&");
		assertEquals("Enter Valid Store Name in alphabets within the length of 15 ", actual);
	}

	@Test(expected = StoreExceptions.class)
	public void testStoreContactAlphabet() throws StoreExceptions, SQLException {
		String actual = storeService.modifyStore(new StoreDetailsDTO(12345, "hello", "airoli", "#$F456789", "harry"));
		assertEquals("enter valid contact number with only numbers", actual);
	}

	@Test(expected = StoreExceptions.class)
	public void testStoreContactSplChar() throws StoreExceptions, SQLException {
		String actual = storeService.modifyStore(new StoreDetailsDTO(12345, "hello", "airoli", "#$F456789", "harry"));
		assertEquals("enter valid contact number with only numbers", actual);
	}

	@Test(expected = StoreExceptions.class)
	public void testStoreNameNumbers() throws StoreExceptions, SQLException {
		boolean actual = storeService.addStoreDetails(new StoreDetailsDTO(12345, "2324", "airoli", "123456789", "harry"));
		assertEquals(true, actual);
	}
	
	@Test(expected = StoreExceptions.class)
	public void testStoreContactOnlyNumbers() throws StoreExceptions, SQLException {
		boolean actual = storeService.addStoreDetails(new StoreDetailsDTO(12345, "hello", "airoli", "#$F456789", "harry"));
		assertEquals(true, actual);
	}

	@Test(expected = StoreExceptions.class)
	public void testOwnerNameNumber() throws StoreExceptions, SQLException {
		boolean actual = storeService.addStoreDetails(new StoreDetailsDTO(12345, "hello", "airoli", "1234567890", "har534y"));
		assertEquals(true, actual);
	}
}
