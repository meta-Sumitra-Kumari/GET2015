import java.lang.reflect.Method;

/**
 * @author Sumitra
 * class calling the annotation methods.
 */
public class TestAnnotationParser {
	/**
	 * Function to parse the class and run their methods through annotation
	 * 
	 * @param tempClass
	 *            ---class in which we have to parse the annotation
	 * @throws Exception
	 */
	public void parse(Class<?> tempClass) throws Exception {
		/**
		 * will get all the methods of Employee class
		 */
		Method[] methods = tempClass.getMethods();
		/**
		 * for each loop is applied to fetch each method.
		 */
		for (Method method : methods) {
			/**
			 * to fetch methods on which annotation is applied.
			 */
			if (method.isAnnotationPresent(RequestForEnhancement.class)) {
				/**
				 * to get the annotation set on the method.
				 */
				RequestForEnhancement test = method
						.getAnnotation(RequestForEnhancement.class);
				int info = test.id();
				String synopsis = test.synopsis();
				if (1 == info) {
					
					/**
					 *  try to invoke the method with info==1
					 */
					method.invoke(Employee.class.newInstance(), info, synopsis,
							test.engineer(), test.date());
				}
			}

		}
	}
}
