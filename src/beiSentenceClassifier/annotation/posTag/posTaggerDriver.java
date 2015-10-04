package beiSentenceClassifier.annotation.posTag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import beiSentenceClassifier.annotation.segment.Segmenter;
import beiSentenceClassifier.preprocess.Preprocessor;

public class posTaggerDriver {
	public static void main(String[] args) throws Exception {
		// preprocess raw test
		Preprocessor p = new Preprocessor();
		p.readChineseFile("example.txt");
		
		// Segment & posTag
	   List<HasWord> segSentence = new ArrayList<HasWord>();
	   List<TaggedWord> taggedSentence = new ArrayList<TaggedWord>();
	   
	   Segmenter seg = new Segmenter();
	   PosTagger pT = new PosTagger();
	   seg.load();
	   for (String s : p.getText()) {
		   // segment
		   segSentence = seg.segSentenceToHasWord(s);;
		   // posTag
		   taggedSentence = pT.posTag(segSentence);
		   // System.out.println(Sentence.listToString(taggedSentence, true));
		   System.out.println(taggedSentence.get(0).toString());
	   }
	}
}