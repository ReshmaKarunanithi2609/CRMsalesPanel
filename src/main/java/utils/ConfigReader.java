package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final Properties props = new Properties();

	static {
		try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (in == null) {
				throw new RuntimeException("config.properties not found in src/test/resources");
			}
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException("Could not read config.properties", e);
		}
	}

	public static String get(String key) {
		String value = props.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Key missing in config.properties: " + key);
		}
		return value.trim();
	}
}
