package com.cg.pos.utility;

public class Query {

	public static String addStore="insert into store(storeid,storename,storeaddress,storecontact,ownername) values(seq.NEXTVAL,?,?,?,?)";
	public static String viewStore="select storeid,storename,storeaddress,storecontact,ownername from store where storename =?";
	public static String deleteStore="delete from store where storeid=?";
	public static String modifyStoreName="update store set storename=? where storeid=?";
	public static String modifyStoreContact="update store set storecontact=? where storeid=?";
	public static String modifyStoreAddress="update store set storeaddress=? where storeid=?";
	public static String modifyOwnerName="update store set ownername=? where storeid=?";
}
