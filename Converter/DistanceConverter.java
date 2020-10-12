package Converter;

public class DistanceConverter extends ConverterPane {

	private String title = "Distance Converter";
	private String[] options = {
			"km - Kilometer",
			"hm - Hectometer", 
			"dam - Decameter", 
			"m - Meter", 
			"dm - Decimeter", 
			"cm - Centimeter", 
			"mm - Millimeter",
			"ft - Foot",
			"in - Inch",
			"mi - Mile",
			"yd - Yard"
	};
	private String fromUnit;
	private String toUnit;
	private String fromValue;
	
	public DistanceConverter() {
		setTitle(title);
		setOptions(options);
		
		button.setOnMouseClicked(event -> {
			
			fromUnit = getFromUnit();
			toUnit = getToUnit();
			fromValue = getValueFrom();
			double value;
			double meterLength;
			double result;
			try {
				value = Double.parseDouble(fromValue);
				if ((meterLength = convertToMeter(value, fromUnit)) >= 0) {
					result = convertToUnit(meterLength, toUnit);
					textOut.setText("" + df.format(result));
				} else {
					textOut.setText("Distance can't be lower than zero!");
				}
			} catch (NumberFormatException e) {
				textOut.setText("Bad number");
			}
		});
	}
	
	private double convertToMeter(double value, String fromUnit) {
		double result = 0;
		switch(fromUnit) {
		case "km":
			result = value * 1000;
			break;
		case "hm":
			result = value * 100;
			break;
		case "dam":
			result = value * 10;
			break;
		case "m":
			result = value;
			break;
		case "dm":
			result = value / 10;
			break;
		case "cm":
			result = value / 100;
			break;
		case "mm":
			result = value / 1000;
			break;
		case "ft":
			result = value / 3.2808399;
			break;
		case "in":
			result = value / 39.370;
			break;
		case "mi":
			result = value * 1609.344;
			break;
		case "yd":
			result = value / 1.0936;
			break;
		}
		return result;
	}
	
	private double convertToUnit(double value, String toUnit) {
		double result = 0;
		switch(toUnit) {
		case "km":
			result = value / 1000;
			break;
		case "hm":
			result = value / 100;
			break;
		case "dam":
			result = value / 10;
			break;
		case "m":
			result = value;
			break;
		case "dm":
			result = value * 10;
			break;
		case "cm":
			result = value * 100;
			break;
		case "mm":
			result = value * 1000;
			break;
		case "ft":
			result = value * 3.2808399;
			break;
		case "in":
			result = value * 39.370;
			break;
		case "mi":
			result = value / 1609.344;
			break;
		case "yd":
			result = value * 1.0936;
			break;
		}
		return result;
	}
}
