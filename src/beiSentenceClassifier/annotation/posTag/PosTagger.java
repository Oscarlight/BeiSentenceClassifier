package beiSentenceClassifier.annotation.posTag;
import beiSentenceClassifier.util.*;

import java.io.IOException;
import java.util.List;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.util.Properties;

public class PosTagger {
	private static final String basedir = System.getProperty("posModel", "lib/postagger/models/");
	private static final String model = "chinese-distsim.tagger";
	private static final String propFile = "chinese-distsim.tagger.props";
	private MaxentTagger tagger;
	private ReadPropertiesFile props;
	
	public PosTagger() throws IOException {
		// props = new ReadPropertiesFile(propFile);
		// tagger = new MaxentTagger(basedir + model, props.getProps());	
		tagger = new MaxentTagger(basedir + model);	
	}
	
	public List<TaggedWord> posTag(List<HasWord> sentence) {
    List<TaggedWord> tSentence = tagger.tagSentence(sentence);
	return tSentence;
	}
}
