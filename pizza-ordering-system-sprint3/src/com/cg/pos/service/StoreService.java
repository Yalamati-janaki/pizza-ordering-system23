package com.cg.pos.service;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;

public interface StoreService {
	public boolean addStoreDetails(StoreDetailsDTO storeDetailEntity) throws StoreExceptions;

	public String deleteStoreDetails(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions;

	public String viewStoreDetails(String storeName) throws StoreExceptions;

//	public String modifyStoreName(int storeId, String storeNmae) throws StoreExceptions;
//
//	public String modifyStoreContact(int storeId, String storeContact) throws StoreExceptions;
//
//	public String modifyStoreAddress(int storeId, String storeAddress) throws StoreExceptions;
//
//	public String modifyOwnerName(int storeId, String ownerName) throws StoreExceptions;

	public String modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions;

}
