package demo.taxi.com.util;

/**
 * The Class DistanceCalculator.
 *
 * @author Christian Iradukunda
 */
public class DistanceCalculator {

	public static double calculateDistance(String initLocation, String destinationLocation){

		String[] initPoints = initLocation.split(",");
		String[] destinationPoints = destinationLocation.split(",");

		double x1 = Double.parseDouble(initPoints[0]);
		double y1 = Double.parseDouble(initPoints[1]);
		double x2 = Double.parseDouble(destinationPoints[0]);
		double y2 = Double.parseDouble(destinationPoints[1]);

		return Math.round(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)) * 1000d)/ 1000d;
	}
}