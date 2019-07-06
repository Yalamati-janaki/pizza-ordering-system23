package com.cg.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.utility.Connect;
import com.cg.pos.utility.ExceptionMessages;
import com.cg.pos.utility.Query;

/**
 * class for adding, viewing, deleting and modifying the store details in
 * database.
 * 
 * @author trainee
 *
 */
public class StoreDaoImpl implements StoreDao {
	/**
	 * method for ADDING the store details to database.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	@Override
	public boolean addStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {

		Connection connection = Connect.getConnection();
		String sql = Query.addStore;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, storeDetailsDTO.getStoreName());
			preparedStatement.setString(2, storeDetailsDTO.getStoreAddress());
			preparedStatement.setString(3, storeDetailsDTO.getStoreContact());
			preparedStatement.setString(4, storeDetailsDTO.getOwnerName());
			int resultset = preparedStatement.executeUpdate();
			if (resultset == 1) {
				return true;
			}

		} catch (SQLException e) {
			throw new StoreExceptions(ExceptionMessages.STORE_NAME_EXISTS);
		} finally {

			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	/**
	 * method for VIEWING store details from database.
	 * 
	 * @throws StoreExceptions
	 * @throws SQLException
	 */
	@Override
	public StoreDetailsDTO viewStore(String storeName) throws StoreExceptions {

		Connection connection = Connect.getConnection();
		String sql = Query.viewStore;
		PreparedStatement preparedStatement = null;
		StoreDetailsDTO storeDetailsDTO = new StoreDetailsDTO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, storeName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(2).equals(storeName)) {
					storeDetailsDTO.setStoreId(resultSet.getInt(1));
					storeDetailsDTO.setStoreName(resultSet.getString(2));
					storeDetailsDTO.setStoreAddress(resultSet.getString(3));
					storeDetailsDTO.setStoreContact(resultSet.getLong(4) + "");
					storeDetailsDTO.setOwnerName(resultSet.getString(5));
				}
			}

		} catch (SQLException e) {
			System.out.println("sdh");
			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return storeDetailsDTO;

	}

//	/**
//	 * method for MODIFYING store name of selected store in database.
//	 *
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public boolean modifyStoreName(String storeName, int storeId) throws StoreExceptions {
//		Connection connection = Connect.getConnection();
//		String sql = Query.modifyStoreName;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, storeName);
//			preparedStatement.setInt(2, storeId);
//			int resultSet = preparedStatement.executeUpdate();
//			if (resultSet == 1) {
//				return true;
//			}
//
//		} catch (SQLException e) {
//			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
//		} finally {
//			try {
//				connection.commit();
//				preparedStatement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return false;
//	}
//
//	/**
//	 * method for MODIFYING store contact of selected store in database.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public boolean modifyStoreContact(String storeContact, int storeId) throws StoreExceptions {
//		Connection connection = Connect.getConnection();
//		String sql = Query.modifyStoreContact;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, storeContact);
//			preparedStatement.setInt(2, storeId);
//			int resultSet = preparedStatement.executeUpdate();
//			if (resultSet == 1) {
//				return true;
//			}
//		} catch (SQLException e) {
//			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
//		} finally {
//			try {
//				connection.commit();
//				preparedStatement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * method for MODIFYING store address of selected store in database.
//	 *
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public boolean modifyStoreAddress(String storeAddress, int storeId) throws StoreExceptions {
//		Connection connection = Connect.getConnection();
//		String sql = Query.modifyStoreAddress;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, storeAddress);
//			preparedStatement.setInt(2, storeId);
//			int resultSet = preparedStatement.executeUpdate();
//			if (resultSet == 1) {
//				return true;
//			}
//
//		} catch (SQLException e) {
//			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
//		} finally {
//			try {
//				connection.commit();
//				preparedStatement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return false;
//	}
//
//	/**
//	 * method for MODIFYING store owner name of selected store in database.
//	 * 
//	 * @throws StoreExceptions
//	 * @throws SQLException
//	 */
//	@Override
//	public boolean modifyOwnerName(String ownerName, int storeId) throws StoreExceptions {
//		Connection connection = Connect.getConnection();
//		String sql = Query.modifyOwnerName;
//		PreparedStatement preparedStatement = null;
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, ownerName);
//			preparedStatement.setInt(2, storeId);
//			int resultSet = preparedStatement.executeUpdate();
//			if (resultSet == 1) {
//				return true;
//			}
//		} catch (SQLException e) {
//			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
//		} finally {
//			try {
//				connection.commit();
//				preparedStatement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//		return false;
//	}

	@Override
	public boolean deleteStore(StoreDetailsDTO storeDetailEntity1) throws StoreExceptions {
		Connection connection = Connect.getConnection();
		String sql = Query.deleteStore;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, storeDetailEntity1.getStoreId());
			int resultSet = preparedStatement.executeUpdate();
			if (resultSet == 1) {
				return true;
			}

		} catch (SQLException e) {
			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
		} finally {
			try {
				connection.commit();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;
	}

	@Override
	public boolean modifyStore(StoreDetailsDTO storeDetailsDTO) throws StoreExceptions {
		Connection connection = Connect.getConnection();
		PreparedStatement preparedStatement = null;
		int resultSet;
		try {
			if (storeDetailsDTO.getStoreName() != null) {
				String sql = Query.modifyStoreName;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, storeDetailsDTO.getStoreName());
				preparedStatement.setInt(2, storeDetailsDTO.getStoreId());
				resultSet = preparedStatement.executeUpdate();
				if (resultSet == 1) {
					return true;
				}
				preparedStatement.close();
			}
			else if (storeDetailsDTO.getStoreContact() != null) {
				String sql = Query.modifyStoreContact;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, storeDetailsDTO.getStoreContact());
				preparedStatement.setInt(2, storeDetailsDTO.getStoreId());
				resultSet = preparedStatement.executeUpdate();
				if (resultSet == 1) {
					return true;
				}
				preparedStatement.close();
			}
			else if (storeDetailsDTO.getStoreAddress() != null) {
				String sql1 = Query.modifyStoreAddress;
				preparedStatement = connection.prepareStatement(sql1);
				preparedStatement.setString(1, storeDetailsDTO.getStoreAddress());
				preparedStatement.setInt(2, storeDetailsDTO.getStoreId());
				resultSet = preparedStatement.executeUpdate();
				if (resultSet == 1) {
					return true;
				}
			}
			else if (storeDetailsDTO.getOwnerName() != null) {
				String sql = Query.modifyOwnerName;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, storeDetailsDTO.getOwnerName());
				preparedStatement.setInt(2, storeDetailsDTO.getStoreId());
				resultSet = preparedStatement.executeUpdate();
				if (resultSet == 1) {
					return true;
				}
			}

		} catch (SQLException e) {
			throw new StoreExceptions(ExceptionMessages.DATA_BASE_EXCEPTION);
		} finally {
			try {
				connection.commit();
//				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
