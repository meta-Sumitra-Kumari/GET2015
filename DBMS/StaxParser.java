
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Arushi ---Class to read data from XML file
 *
 */
public class StaxParser {
	static final String VEHICLE = "vehicle";
	static final String CAR = "car";
	static final String BIKE = "bike";
	static final String VEHICLE_ID = "vehicleId";
	static final String MAKE = "make";
	static final String MODEL = "model";
	static final String ENGINE_IN_CC = "engineInCC";
	static final String FUEL_CAPACITY = "fuelCapacity";
	static final String MILAGE = "milage";
	static final String PRICE = "price";
	static final String ROADTAX = "roadTax";
	static final String AC = "ac";
	static final String POWER_STEERING = "powerStering";
	static final String ACCESSORY_KIT = "accessoryKit";
	static final String SELF_START = "selfStart";
	static final String HELMET_PRICE = "helmetPrice";

	// @SuppressWarnings({ "unchecked", "null" })
	/**
	 * 
	 * ---Function to read data from XML
	 * 
	 * @param configFile
	 * @return----List of vehicles
	 */
	public List<Vehicle> readConfig(String configFile) {
		List<Vehicle> vehicleObjectList = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Vehicle objVehicle = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == (CAR)) {
						objVehicle = new Car();
					} else if (startElement.getName().getLocalPart() == (BIKE)) {
						objVehicle = new Bike();
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(VEHICLE_ID)) {
							event = eventReader.nextEvent();
							objVehicle.setVehicleId(Integer.parseInt(event
									.asCharacters().getData()));
							continue;
						}
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(MAKE)) {
							event = eventReader.nextEvent();
							objVehicle.setMake(event.asCharacters().getData());
							continue;
						}
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MODEL)) {
						event = eventReader.nextEvent();
						objVehicle.setModel(event.asCharacters().getData());
						objVehicle.setCreatedBy();
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ENGINE_IN_CC)) {
						event = eventReader.nextEvent();
						objVehicle.setEngineInCC(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(FUEL_CAPACITY)) {
						event = eventReader.nextEvent();
						objVehicle.setFuelCapacity(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MILAGE)) {
						event = eventReader.nextEvent();
						objVehicle.setMilage(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(PRICE)) {
						event = eventReader.nextEvent();
						objVehicle.setPrice(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ROADTAX)) {
						event = eventReader.nextEvent();
						objVehicle.setRoadTax(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					/*if (event.asStartElement().getName().getLocalPart()
							.equals(CREATED_BY)) {
						event = eventReader.nextEvent();
						objVehicle.setCreatedBy(event.asCharacters().getData());
						continue;
					}*/

					if (event.asStartElement().getName().getLocalPart()
							.equals(AC)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAC(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(POWER_STEERING)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setPowerSteering(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ACCESSORY_KIT)) {
						event = eventReader.nextEvent();
						((Car) objVehicle).setAccessoryKit(Boolean
								.valueOf(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(SELF_START)) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setSelfStart(Boolean.valueOf(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(HELMET_PRICE)) {
						event = eventReader.nextEvent();
						((Bike) objVehicle).setHelmetPrice(Integer
								.parseInt(event.asCharacters().getData()));
						continue;
					}

				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (CAR)
							|| endElement.getName().getLocalPart() == (BIKE))
						vehicleObjectList.add(objVehicle);

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return vehicleObjectList;
	}

}
