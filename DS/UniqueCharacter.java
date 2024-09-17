import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sumitra this is to check whether the string is already present in
 *         cache or not if present then return the size if not present then add
 *         in the map and return the size.
 */
public class UniqueCharacter {

	private static Map<String, Integer> cache = new HashMap<String, Integer>();

	public Integer checkUnique(String input) {
		Set<Character> result = new HashSet<Character>();

		if (cache.containsKey(input)) {
			// if already in cache then return size
			// System.out.println("already in cahce");
			return cache.get(input);
		} else {
			// if not then add in map and then return size.
			for (int i = 0; i < input.length(); i++) {
				result.add(input.charAt(i));
			}
			cache.put(input, result.size());
			return result.size();
		}

	}
}
