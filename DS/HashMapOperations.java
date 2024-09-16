/**
 * @author Sumitra to implement all methods.
 */
public class HashMapOperations {
	private final static int No_Of_Rooms = 11;
	int count = 0;
	HashNode[] room;

	HashMapOperations() {
		room = new HashNode[No_Of_Rooms];
		for (int i = 0; i < No_Of_Rooms; i++) {
			room[i] = null;

		}
	}

	/**
	 * 
	 * @param key
	 *            to print the information about specific room.
	 */
	public void get(int key) {
		int hash = key;
		while (room[hash] != null && room[hash].getKey() != key)
			hash = (hash + 1) % No_Of_Rooms;
		if (room[hash] == null) {
			System.out.println("Not present");
			return;
		} else {
			System.out.println("Age:	" + room[hash].getAge());
			System.out.println("Name:	" + room[hash].getName());
		}
	}

	/**
	 * 
	 * @param value
	 *            value to insert at room
	 * @param name
	 *            with the user name
	 */
	public void put(int value, String name) {
		int hash = (value % No_Of_Rooms);
		if (count < No_Of_Rooms) {
			while ((room[hash] != null)) {
				hash = (hash + 1) % No_Of_Rooms;
			}
			room[hash] = new HashNode(hash, value, name);
			System.out.println("Your room is" + hash);
			count = count + 1;
		} else {
			System.out.println("Rooms not possible");
			return;
		}
	}

	/**
	 * 
	 * @param hashRoom
	 *            to delete the room
	 */
	public void deleteRoom(int hashRoom) {
		room[hashRoom] = null;
		count = count - 1;

	}

	/**
	 * to clear all rooms
	 */
	public void clear() {
		for (int i = 0; i < No_Of_Rooms; i++) {
			room[i] = null;

		}
		count = 0;
		System.out.println("All rooms are empty");
	}

	/**
	 * to display whole information.
	 */
	public void display() {
		int k = 0;
		while (k < No_Of_Rooms) {
			System.out.println("Room no  " + k + "  status");
			if (room[k] != null) {
				System.out.println("Age:	" + room[k].getAge());
				System.out.println("Name:	" + room[k].getName());
				k++;
			} else {
				System.out.println("empty right now");
				k++;
			}
		}
	}

}
