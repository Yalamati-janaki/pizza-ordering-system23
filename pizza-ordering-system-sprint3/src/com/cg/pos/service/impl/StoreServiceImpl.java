package com.cg.pos.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.pos.dao.StoreDao;
import com.cg.pos.dao.StoreDaoImpl;
import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.service.StoreService;
import com.cg.pos.utility.ExceptionMessages;
import com.cg.pos.utility.ValidateStoreDetails;

/**
 * class for adding, deleting, viewing, modifying the store details.
 * 
 * @author trainee
 *
 */
public class StoreServiceImpl implements StoreService {

	StoreDetailsDTO storeDetailEntity = new StoreDetailsDTO();
	ArrayList<StoreDetailsDTO> list1;

	/**
	 * method for adding store details to list.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	@Override
	public boolean addStoreDetails(StoreDetailsDTO storeDetailEntity) throws StoreExceptions {

		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
		String storeName = storeDetailEntity.getStoreName();
		boolean validatedStorename = validateStoreDetails.isValidName(storeName);

		String storeContact = storeDetailEntity.getStoreContact();
		boolean validatedStoreContact = validateStoreDetails.isValidStoreContact(storeContact);

		String storeAddress = storeDetailEntity.getStoreAddress();
		boolean validatedStoreAddress = validateStoreDetails.isValidStoreAddress(storeAddress);

		String ownerName = storeDetailEntity.getOwnerName();
		boolean validatedOwnerName = validateStoreDetails.isValidName(ownerName);
		boolean addDetails = false;
		if (validatedStorename && validatedStoreContact && validatedStoreAddress && validatedOwnerName) {

			StoreDao storeDao = new StoreDaoImpl();
			addDetails = storeDao.addStore(storeDetailEntity);
			if (!addDetails) {
				throw new StoreExceptions(ExceptionMessages.STORE_NAME_EXISTS);
			}
		}
		return addDetails;
	}

	/**
	 * Method for deleting store details from list.
	 * 
	 * @throws InValidStoreNameException
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
//	@Override
//	public String deleteStoreDetails(String storeName) throws StoreExceptions {
//
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidStoreName(storeName);
//		StoreDao storeDao = new StoreDaoImpl();
//		boolean deleteDetails = storeDao.deleteStore(storeName);
//		if (!deleteDetails) {
//			throw new StoreExceptions(ExceptionMessages.STORE_NAME_NOT_EXISTS);
//		}
//		return deleteDetails + " is deleted ";
//	}

	/**
	 * method for viewing store details.
	 * 
	 * @throws InValidStoreNameException
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	@Override
	public String viewStoreDetails(String storeName) throws StoreExceptions {

		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
		validateStoreDetails.isValidName(storeName);

		StoreDao storeDao = new StoreDaoImpl();
		StoreDetailsDTO viewDetails = storeDao.viewStore(storeName);
		if (viewDetails.getStoreName() == null) {
			throw new StoreExceptions(ExceptionMessages.STORE_NAME_NOT_EXISTS);
		}
		return "THE SELECTED STORE DETAILS : " + viewDetails;
	}

//	/**
//	 * method for modifying store name.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public String modifyStoreName(int storeId, String storeName) throws StoreExceptions {
//
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidName(storeName);
//
//		StoreDao storeDao = new StoreDaoImpl();
//		boolean modifyDetails = storeDao.modifyStoreName(storeName, storeId);
//		if (!modifyDetails) {
//			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
//		}
//		return storeName;
//	}
//
//	/**
//	 * method for modifying store contact.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public String modifyStoreContact(int storeId, String storeContact) throws StoreExceptions {
//
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidStoreContact(storeContact);
//
//		StoreDao storeDao = new StoreDaoImpl();
//		boolean modifyDetails = storeDao.modifyStoreContact(storeContact, storeId);
//		if (!modifyDetails) {
//			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
//		}
//		return storeContact;
//	}
//
//	/**
//	 * method for modifying store address.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public String modifyStoreAddress(int storeId, String storeAddress) throws StoreExceptions {
//
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidStoreAddress(storeAddress);
//
//		StoreDao storeDao = new StoreDaoImpl();
//		boolean modifyDetails = storeDao.modifyStoreAddress(storeAddress, storeId);
//		if (!modifyDetails) {
//			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
//		}
//		return storeAddress;
//	}
//
//	/**
//	 * method for modifying owner name.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public String modifyOwnerName(int storeId, String ownerName) throws StoreExceptions {
//
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidName(ownerName);
//
//		StoreDao storeDao = new StoreDaoImpl();
//		boolean modifyDetails = storeDao.modifyOwnerName(ownerName, storeId);
//		if (!modifyDetails) {
//			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
//		}
//		return ownerName;
//	}

	@Override
	public String modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {

		ValidateStoreDetails validateStoreDetails = null;
		if(validateStoreDetails==null) {
			validateStoreDetails=new ValidateStoreDetails();
		}
		if (storeDetailsDTO.getStoreName() != null) {
			validateStoreDetails.isValidName(storeDetailsDTO.getStoreName());
		} else if (storeDetailsDTO.getStoreContact() != null) {
			validateStoreDetails.isValidStoreContact(storeDetailsDTO.getStoreContact());
		} else if (storeDetailsDTO.getStoreAddress() != null) {
			validateStoreDetails.isValidStoreAddress(storeDetailsDTO.getStoreAddress());
		} else if (storeDetailsDTO.getOwnerName() != null) {
			validateStoreDetails.isValidName(storeDetailsDTO.getOwnerName());
		}
		StoreDao storeDao=new StoreDaoImpl();
		boolean modifyDetails = storeDao.modifyStore(storeDetailsDTO);
		if (!modifyDetails) {
			throw new StoreExceptions(ExceptionMessages.STORE_ID_NOT_EXISTS);
		}
		return "Modified";
	}


	@Override
	public String deleteStoreDetails(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions {
//		ValidateStoreDetails validateStoreDetails = new ValidateStoreDetails();
//		validateStoreDetails.isValidStoreName(storeDetailEntity1.);
		StoreDao storeDao = new StoreDaoImpl();
		boolean deleteDetails = storeDao.deleteStore(storeDetailEntity1);
		if (!deleteDetails) {
			throw new StoreExceptions(ExceptionMessages.STORE_NAME_NOT_EXISTS);
		}
		return storeDetailEntity1.getStoreId() + " is deleted ";
	}

}
