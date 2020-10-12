package Converter;

public class TemperatureConverter extends ConverterPane {

	private String title = "Temperature Converter";
	private String[] options = {
			"°C - Celsius", 
			"°F - Fahrenheit", 
			"°K - Kelvin", 
			"°R - Rankine", 
			"°De - Delisle", 
			"°N - Newton", 
			"°Ré - Réaumur", 
			"°Rø - Rømer"
	};
	private String fromUnit;
	private String toUnit;
	private String fromValue;
	
	public TemperatureConverter() {
		setTitle(title);
		setOptions(options);
		
		button.setOnMouseClicked(event -> {
			
			fromUnit = getFromUnit();
			toUnit = getToUnit();
			fromValue = getValueFrom();
			double value;
			double celsiusTemp;
			double result;
			try {
				value = Double.parseDouble(fromValue);
				if ((celsiusTemp = convertToCelsius(value, fromUnit)) >= -273.15) {
					result = convertToUnit(celsiusTemp, toUnit);
					textOut.setText("" + df.format(result));
				} else {
					textOut.setText("Temperature can't be lower than absolute zero!");
				}
			} catch (NumberFormatException e) {
				textOut.setText("Bad number");
			}
		});
	}
	
	private double convertToCelsius(double value, String fromUnit) {
		double result = 0;
		switch (fromUnit) {
		case "°C":
			result = value;
			break;
		case "°F":
			result = (value - 32) * 5/9;
			break;
		case "°K":
			result = value - 273.15;
			break;
		case "°R":
			result = (value - 491.67) * 5/9;
			break;
		case "°De":
			result = 100 - value * 2/3;
			break;
		case "°N":
			result = value * 100/33;
			break;
		case "°Ré":
			result = value * 5/4;
			break;
		case "°Rø":
			result = (value - 7.5) * 40/21;
			break;
		default:
			textOut.setText("No such Temperature Unit");
		}		
		return result;
	}
	
	private double convertToUnit(double value, String unit) {
		double result = 0;
		
		switch (unit) {
		case "°C":
			result = value;
			break;
		case "°F":
			result = value * 9/5 + 32;			
			break;
		case "°K":
			result = value + 273.15;
			break;
		case "°R":
			result = value * 9/5 + 491.67;
			break;
		case "°De":
			result = (100 - value) * 3/2;
			break;
		case "°N":
			result = value * 33/100;
			break;
		case "°Ré":
			result = value * 4/5;
			break;
		case "°Rø":
			result = value * 21/40 + 7.5;
			break;
		default:
			textOut.setText("No such Temperature Unit");
		}
		return result;
	}
}
