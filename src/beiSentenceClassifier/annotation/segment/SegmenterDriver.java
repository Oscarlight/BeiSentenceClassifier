package beiSentenceClassifier.annotation.segment;

import java.util.ArrayList;
import java.util.List;

import beiSentenceClassifier.preprocess.Preprocessor;
import edu.stanford.nlp.ling.CoreLabel;

public class SegmenterDriver {

	public static void main(String[] args) throws Exception {
		// preprocess raw test
		Preprocessor p = new Preprocessor();
		p.readChineseFile("example.txt");
		
		// Segment
	   List<String> list = new ArrayList<String>();
	   Segmenter seg = new Segmenter();
	   seg.load();
	   for (String s : p.getText()) {
		   list = seg.segSentence(s);
		   System.out.println(list);
	   }
	}

}
