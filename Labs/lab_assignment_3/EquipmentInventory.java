package ece325_lab_assignment3;

import java.util.ArrayList;

public class EquipmentInventory {
	// your inventory of items
	ArrayList<InventoryItem> inventory;
	// inventory of all missing items and items that require wrapping 
	ArrayList<InventoryItem> missing;
	ArrayList<InventoryItem> needsWrapping;

	public EquipmentInventory() {
		// Create a new inventory of items
		inventory = new ArrayList<InventoryItem>();
	}

	/**
	 * Stow equipment into the trunk of the bus. Note: every type of equipment
	 * should only occur once in the inventory. Make sure to check if you are not
	 * accidentally taking someone else's equipment.
	 * 
	 * @param equip  The type of equipment to stow
	 * @param number The number of items to stow
	 */
	public void addEquipmentToBus(Equipment equip, int number) {
		for (InventoryItem i:inventory) {
			// Make sure we are adding to the instances already created
			if (i.getEquipment().equals(equip)) {
				// Add to the bus but also remove from missing
				i.addToBus(number);
				missing.remove(i);
			}
		}
	}

	/**
	 * Add equipment to your inventory. Note: every type of equipment
	 * should only occur once in the inventory. Whenever you acquire new
	 * equipment, it is always outside the bus. 
	 * 
	 * @param equip  The type of equipment to add to your inventory
	 * @param number The number of items to add
	 */
	public void addEquipmentToInventory(Equipment equip, int number) {
		// Add a new instance of the equipment in inventory
		inventory.add(new InventoryItem(equip, number));
	}

	
	/**
	 * Returns a list of items that are still missing from the bus. 
	 * @return List of missing items.
	 */
	public ArrayList<InventoryItem> getMissingItems() {
		missing = new ArrayList<InventoryItem>();
		for (InventoryItem i:inventory) {
			// If the item is in the inventory but not in bus, it's missing
			if (i.getInInventory() != i.getInBus()) {
				missing.add(i);
			}
		}
		return missing;
	}

	/**
	 * Returns a list of items that still need wrapping. Note that these items might still 
	 * be (partially) missing from the bus too. 
	 * @return List of items that still need to be wrapped.
	 */
	public ArrayList<InventoryItem> getNeedsWrappingItems() {
		needsWrapping = new ArrayList<InventoryItem>();
		for (InventoryItem i:inventory) {
			// If the item hasn't been wrapped, then add it to arrayList
			if (i.getEquipment().getNeedsWrapping()) {
				needsWrapping.add(i);
			}
		}
		return needsWrapping;
	}

	/**
	 * Wrap items of the same type as e.
	 * @param The type of equipment you want to wrap. 
	 */
	public void wrapItems(Equipment e) {
		for (InventoryItem i:inventory) {
			// If the item hasn't been wrapped - returns true
			if (!i.needsWrapping()) {
				// Wrap the item but also remove it from needsWrapping
				i.wrap();
				needsWrapping.remove(i);
			}
		}
	}

	/** 
	 * Returns a string representation of the inventory.
	 */
	public String toString() {
		// Must return which equipment + how many of each we own.
		// This also returns which equipment + how many are on the bus
		// AND which equipment still needs to be wrapped
		StringBuilder myInvList = new StringBuilder();
		for (InventoryItem i:inventory) {
			myInvList.append(i);
		}
		return myInvList.toString();
	}

	/** 
	 * Returns true iff the inventory is complete, wrapped and you are ready to go.
	 * @return true iff inventory is complete and wrapped
	 */
	public boolean getReadyToGo() {
		boolean g2g = false;
		// If there are no more missing items or items that need to be wrapped
		// then we are good 2 go (g2g) :)
		if (missing.size() == 0 && needsWrapping.size() == 0) {
			g2g = true;
			return g2g;
		}
		return g2g;
	}

	public static void main(String[] args) {
		
		EquipmentInventory myInv = new EquipmentInventory();
		// Add 2 microphones, 4 guitars and 12 chairs to Equipment Inventory
		// Instantiate new instances of each piece of equipment and the number
		// of each instrument that are to be added to the inventory
		myInv.addEquipmentToInventory(new Microphone(true), 2);
		myInv.addEquipmentToInventory(new Guitar(true), 4);
		// Do chairs need to be wrapped?
		// myInv.addEquipmentToInventory(new Chair(true), 12);
		myInv.addEquipmentToInventory(new Chair(false), 12);
		
		System.out.println("This is what's in inventory: ");
		System.out.println(myInv);

		System.out.println("Printing missing items: ");
		ArrayList<InventoryItem> missing = myInv.getMissingItems();
		System.out.println(missing);

		System.out.println("Printing items that need wrapping: ");
		ArrayList<InventoryItem> needsWrapping = myInv.getNeedsWrappingItems();
		System.out.println(needsWrapping);
		
		//Try to add 15 chairs to bus
		System.out.println("Adding 15 chairs to the bus: ");
		myInv.addEquipmentToBus(new Chair(false), 15);
		
		System.out.println(myInv);
		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());
		
		//Try to add 4 guitars and 2 microphones to bus
		System.out.println("Adding 4 guitars and 2 microphones to the bus: ");
		myInv.addEquipmentToBus(new Guitar(true), 4);
		myInv.addEquipmentToBus(new Microphone(true), 2);
		System.out.println(myInv);
		
		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());

		//Wrap items that need wrapping but have not been wrapped yet
		myInv.wrapItems(new Guitar(true));
		myInv.wrapItems(new Microphone(true));
		// Inventory now shows items as wrapped and in bus, along with #'s
		System.out.println(myInv);

		System.out.println("Ready to go?");
		System.out.println(myInv.getReadyToGo());
	}
}
