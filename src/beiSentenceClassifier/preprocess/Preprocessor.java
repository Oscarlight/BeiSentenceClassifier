package beiSentenceClassifier.preprocess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/** 
 * Read the raw text and clean the text file
 * Details of clean:
 * 
 * @author oscar
 *
 */
public class Preprocessor {
	private BufferedReader reader;
	private ArrayList<String> text;
	
	/**
	 * Constructor
	 */
	public Preprocessor() {
		text = new ArrayList<String>();
	}
	
	
	/**
	 * Read a Chinese text file.
	 * @param fileName
	 * @throws IOException 
	 */
	public void readChineseFile(String fileName) throws IOException {
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8")); // use UTF-8 for Chinese
		String currentLine = reader.readLine();
		while (currentLine != null) {
            // System.out.println(currentLine);
            text.add(currentLine);
            currentLine = reader.readLine();
        }
	}
	
	/** 
	 * cleanUp the text
	 * 1. delete the leading number and spaces
	 * 2. delete "原始语料"
	 * 3. delect [...]
	 * 4. 
	 * @param wordsToDelect
	 * @return
	 * @throws IOException
	 */
	public String cleanUp() {
		
		return "";
	}
	
	/**
	 * get the text as processing 
	 * @return
	 */
	public ArrayList<String> getText() {
		return text;
	}
	
	/** 
	 * have a nice print out the ArrayList<String> text
	 */
	public void listedPrint() {
		for (int i = 0; i < text.size(); i++) {
			System.out.println( (i + 1) + ": " + text.get(i) );
		}
	}
}
