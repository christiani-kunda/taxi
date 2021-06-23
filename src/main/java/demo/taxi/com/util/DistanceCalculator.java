package demo.taxi.com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class DistanceCalculator.
 *
 * @author Christian Iradukunda
 */
public class DistanceCalculator {

	private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCalculator.class);

	public static double calculateDistance(String initLocation, String destinationLocation){

		String[] initPoints = initLocation.split(",");
		String[] destinationPoints = destinationLocation.split(",");

		double x1 = Double.parseDouble(initPoints[0]);
		double y1 = Double.parseDouble(initPoints[1]);
		double x2 = Double.parseDouble(destinationPoints[0]);
		double y2 = Double.parseDouble(destinationPoints[1]);

		double distance = Math.round(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) * 1000d)/ 1000d;
		LOGGER.debug( "Distance is {}", distance);
		return distance;
	}
}