/**
 * @author Sumitra
 *
 *         --Main Class to parse the annotation
 */
public class AnnotationMain {
	 public static void main(String[] args) throws Exception {
	      TestAnnotationParser parser = new TestAnnotationParser();
	      parser.parse(Employee.class);
	   }
}
