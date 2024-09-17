import java.lang.reflect.Method;

/**
 * @author  Sumitra---Main Class to parse the annotation
 *
 */
public class TestAnnotationParser {
	public static void main(String[] args) throws Exception {
		System.out.println("Parsing the values...");
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(AnnotationRunner.class);
	}

	/**
	 * ---Function to parse the class and call the annotations
	 * 
	 * @param tempClass
	 * @throws Exception
	 */
	public void parse(Class<?> tempClass) throws Exception {

		Method[] methods = tempClass.getMethods();

		for (Method method : methods) {

			if (method.isAnnotationPresent(CanRun.class)) {
				
				method.invoke(AnnotationRunner.class.newInstance());

			}

		}
	}

}
