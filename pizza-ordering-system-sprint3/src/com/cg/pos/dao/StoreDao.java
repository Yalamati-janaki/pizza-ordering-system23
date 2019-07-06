package com.cg.pos.dao;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;

public interface StoreDao {

	boolean addStore(StoreDetailsDTO storeDetailEntity) throws StoreExceptions;

	StoreDetailsDTO viewStore(String storeName) throws StoreExceptions;

	boolean deleteStore(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions;

//	boolean modifyStoreName(String storeName, int storeId) throws StoreExceptions;
//
//	boolean modifyStoreContact(String storeContact, int storeId) throws StoreExceptions;
//
//	boolean modifyStoreAddress(String storeAddress, int storeId) throws StoreExceptions;
//
//	boolean modifyOwnerName(String ownerName, int storeId) throws StoreExceptions;

	boolean modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions;

}
