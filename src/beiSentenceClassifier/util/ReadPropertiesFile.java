package beiSentenceClassifier.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Read a properties file for StanfordNLP pipeline
 * @author oscar
 *
 */
public class ReadPropertiesFile {
	private Properties prop;
	private InputStream inputStream;
	private String propFileName;
 
	public ReadPropertiesFile(String propFileName) {
		this.propFileName = propFileName;
		prop = new Properties();
	}
	
	/**
	 * get Prop Value from file 
	 * @return
	 * @throws IOException
	 */
	public Properties getProps() throws IOException {
 
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// Date time = new Date(System.currentTimeMillis());
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
}
