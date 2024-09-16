/**
 * @author Sumitra the node class of hashmap
 *
 */
public class HashNode {
	private int key;
	private int age;
	private String name;

	HashNode(int key, int age, String name) {
		this.key = key;
		this.age = age;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public int getAge() {
		return age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setAge(int value) {
		this.age = value;
	}
}
