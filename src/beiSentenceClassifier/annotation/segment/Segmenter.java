package beiSentenceClassifier.annotation.segment;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;

public class Segmenter {

	private static final String basedir = System.getProperty("SegmentData", "lib/segmenter/data");
	private Properties props;
	private CRFClassifier<CoreLabel> segmenter;
	
	/**
	 * Constructor
	 * @throws UnsupportedEncodingException
	 */
	public Segmenter() throws UnsupportedEncodingException {
		props = new Properties();

		// Set props for CRFClassifer
		props.setProperty("sighanCorporaDict", basedir);
			// props.setProperty("NormalizationTable", "data/norm.simp.utf8");
			// props.setProperty("normTableEncoding", "UTF-8");
			// below is needed because CTBSegDocumentIteratorFactory accesses it
		props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
			// props.setProperty("testFile", inputFileName);
		props.setProperty("inputEncoding", "UTF-8");
		props.setProperty("sighanPostProcessing", "true");
		
		// set System property
		System.setOut(new PrintStream(System.out, true, "utf-8"));

		// init CRFClassifier
		segmenter = new CRFClassifier<CoreLabel>(props);
	}

	/**
	 * segment a string sentence to List of String
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	public List<String> segSentence(String sentence) throws Exception {
		return segmenter.segmentString(sentence);
	}
	
	/**
	 * segment a string sentence to List of HasWord
	 * @param sentence
	 * @return
	 * @throws Exception
	 */
	public List<HasWord> segSentenceToHasWord(String sentence) throws Exception {
		List<String> l = new ArrayList<String>();
		List<HasWord> rl = new ArrayList<HasWord>();
		l = segmenter.segmentString(sentence);
		for (String s : l) {
			HasWord w = new CoreLabel();
			w.setWord(s);
			rl.add(w);
		}
		return rl;
	}
	
	
	/**
	 * load Classifier, take some time.
	 */
	public void load() {
		segmenter.loadClassifierNoExceptions(basedir + "/ctb.gz", props);
	}
}
