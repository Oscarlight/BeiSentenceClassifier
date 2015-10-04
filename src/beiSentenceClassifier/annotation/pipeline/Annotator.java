package beiSentenceClassifier.annotation.pipeline;
import beiSentenceClassifier.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

/**
 * Annotating the preprocessed text
 * @author oscar
 *
 */
public class Annotator {
	private ArrayList<String> rawText;
	private PrintWriter out;
	/**
	 * Default Constructor
	 */
	public Annotator() {
		
	}
	
	/**
	 * Constructor
	 * @param rawText
	 * @param outputFiles
	 * @throws FileNotFoundException
	 */
	public Annotator(ArrayList<String> rawText, String outputFiles) throws FileNotFoundException {
		this();
		this.rawText = rawText;
		out = new PrintWriter(outputFiles);
	}
	
	/**
	 * Constructor
	 * @param rawText
	 */
	public Annotator(ArrayList<String> rawText) {
		this();
		this.rawText = rawText;
		out = new PrintWriter(System.out);
	}
	
	public void annotating(String propertyFileName) throws IOException {
		// Create a CoreNLP pipeline
	    ReadPropertiesFile props = new ReadPropertiesFile(propertyFileName);
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props.getProps());
	    
	    // Extract annotation result sentence by sentence
	    int i = 0;
	    for (String sentence : rawText) {
	    Annotation annotation = new Annotation(sentence);
	    pipeline.annotate(annotation);
	    System.out.println("Complete annotate sentence #" + i++);
	    }	
	}	
}
