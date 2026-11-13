package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;


public class PageElements {

	public static WebElement find(String name, Object... pages) {
		String key = normalize(name);
		List<String> known = new ArrayList<>();
		for (Object page : pages) {
			for (Field field : page.getClass().getFields()) {
				if (!WebElement.class.isAssignableFrom(field.getType())) {
					continue;
				}
				known.add(field.getName());
				if (normalize(field.getName()).equals(key)) {
					try {
						return (WebElement) field.get(page);
					} catch (IllegalAccessException e) {
						throw new RuntimeException("Cannot read locator " + field.getName(), e);
					}
				}
			}
		}
		throw new IllegalArgumentException("No locator named '" + name + "'. Available: " + known);
	}

	public static String normalize(String text) {
		return text.toLowerCase().replaceAll("[^a-z0-9]", "");
	}
}
