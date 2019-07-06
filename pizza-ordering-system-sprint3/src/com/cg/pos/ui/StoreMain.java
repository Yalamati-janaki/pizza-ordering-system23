package com.cg.pos.ui;

import java.util.Scanner;

import com.cg.pos.entity.StoreDetailsDTO;
import com.cg.pos.exceptions.StoreExceptions;
import com.cg.pos.service.StoreService;
import com.cg.pos.service.impl.StoreServiceImpl;

public class StoreMain {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String choice;

		StoreService storeService = null;
		if (storeService == null) {
			storeService = new StoreServiceImpl();
		}

		do {
			System.out.println("1. ADDING Store Details");
			System.out.println("2. VIEW Store Details");
			System.out.println("3. MODIFY Store Details");
			System.out.println("4. DELETE Store Details");
			System.out.println("5. EXIT");
			System.out.println(" Enter your Choice");
			choice = s.next();
			try {
				switch (choice) {
				case "1":
					System.out.println("Enter Store Name");
					String storeName = s.next();
					System.out.println("Enter Store Address");
					String storeAddress = s.next();
					System.out.println("Enter Store Contact");
					String storeContact = s.next();
					System.out.println("Enter Owner Name");
					String ownerName = s.next();
					StoreDetailsDTO storeDetailEntity = new StoreDetailsDTO();
					storeDetailEntity.setStoreName(storeName);
					storeDetailEntity.setStoreAddress(storeAddress);
					storeDetailEntity.setStoreContact(storeContact);
					storeDetailEntity.setOwnerName(ownerName);
					storeService.addStoreDetails(storeDetailEntity);
					System.out.println(storeName + " is added");
					break;
				case "2":
					System.out.println("Enter the Store Name to view its details");
					String storeNameView = s.next();
					String msg = storeService.viewStoreDetails(storeNameView);
					System.out.println(msg);
					break;
				case "3":
					StoreDetailsDTO storeDetailEntity1 = new StoreDetailsDTO();
					System.out.println("enter store ID you want to modify");
			
					int selectedId = s.nextInt();
					storeDetailEntity1.setStoreId(selectedId);
					do {
						System.out.println("1. Modify Store NAME");
						System.out.println("2. Modify Store CONTACT");
						System.out.println("3. Modify Store Address");
						System.out.println("4. Modify OWNER NAME");
						System.out.println("Enter your Choice");
						choice = s.next();
						
						switch (choice) {
						case "1":
							System.out.println("Enter New Store Name ");
							String newStoreName = s.next();
							storeDetailEntity1.setStoreName(newStoreName);
							String setStoreName = storeService.modifyStore(storeDetailEntity1);
							System.out.println(setStoreName + " is set to store id " + selectedId);
							break;
						case "2":
							System.out.println("Enter New Store Contact Number");
							String newStoreContact = s.next();
							storeDetailEntity1.setStoreContact(newStoreContact);
							String setStoreContact = storeService.modifyStore(storeDetailEntity1);
							System.out.println("Your Modified store Contact is : " + setStoreContact);
							break;
						case "3":
							System.out.println("Enter New Store Address");
							String newStoreAddress = s.next();
							storeDetailEntity1.setStoreAddress(newStoreAddress);
							String setStoreAddress = storeService.modifyStore(storeDetailEntity1);
							System.out.println("Your Modified store Address is : " + setStoreAddress);
							break;
						case "4":
							System.out.println("Enter New Owner Name");
							String newOwnerName = s.next();
							storeDetailEntity1.setOwnerName(newOwnerName);
							String setOwnerName = storeService.modifyStore(storeDetailEntity1);
							System.out.println("Your Modified Owner Name :" + setOwnerName);
							break;
						default:
							System.err.println("Enter valid number");
//							System.out.println("1. Modify Store NAME");
//							System.out.println("2. Modify Store CONTACT");
//							System.out.println("3. Modify Store Address");
//							System.out.println("4. Modify OWNER NAME");
//							System.out.println("Enter your Choice");
//							choice = s.next();
							break;
						}
						System.out.println("Do you want to Continue your modifications with this store ");
						System.out.println(" Enter yes or no");
						choice = s.next();
						if (choice.equals("yes")) {
							choice = "";
						} else {
							choice = "0";
						}
					} while (choice != "0");
					break;
				case "4":
					StoreDetailsDTO storeDetailEntity2 = new StoreDetailsDTO();
					System.out.println("Select ID of Store you want to delete");
					int selectedID = s.nextInt();
					storeDetailEntity2.setStoreId(selectedID);
					String setStoreId = storeService.deleteStoreDetails(storeDetailEntity2);
					System.out.println(setStoreId);
					break;
				case "5":
					System.out.println("exit");
					System.exit(0);
					break;
				default:
					System.err.println("Enter PROPER Number");
				}

			} catch (StoreExceptions e) {
				System.err.println("ERROR :" + e.getMessage());
			}
			System.out.println("Do you want to Continue");
			System.out.println("yes or no");
			String continueNumber = s.next();
			if (continueNumber.equals("yes")) {
				choice = "";
			} else {
				System.out.println("THANK YOU....:)");
				System.exit(0);
			}
		} while (choice != "0");
		s.close();
	}

}
