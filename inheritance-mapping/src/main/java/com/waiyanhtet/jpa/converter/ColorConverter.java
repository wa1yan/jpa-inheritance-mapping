package com.waiyanhtet.jpa.converter;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color color) {
		if(null != color) {
			return "%s,%s,%s".formatted(color.getRed(), color.getGreen(), color.getBlue());			
		}
		return null;
	}

	@Override
	public Color convertToEntityAttribute(String color) {
		if(null != color && !color.isBlank()) {
			var colorArr = color.split(",");
			return new Color(ColorCode(colorArr[0]), ColorCode(colorArr[1]), ColorCode(colorArr[2]));
		}
		return null;
	}

	private float ColorCode(String colorCode) {
		var value = new BigDecimal(colorCode);
		return value.divide(new BigDecimal(255), 16, RoundingMode.HALF_UP).floatValue();
	}

}
