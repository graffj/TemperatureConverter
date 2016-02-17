package com.graff.temperatureconverter;

/**
 * Created by Jonathan on 2/17/2016.
 * Utility class to provide temperature conversions
 */
public class ConverterUtil {

    /* Convert to Celsius */
    public static float convertFahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    /* Convert to Fahrenheit */
    public static float convertCelsiusToFahrenheit(float celsius) {
        return ((celsius * 9) /5) + 32;
    }

}
