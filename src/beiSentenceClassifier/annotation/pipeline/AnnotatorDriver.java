package beiSentenceClassifier.annotation.pipeline;

import beiSentenceClassifier.preprocess.Preprocessor;

import java.io.IOException;

public class AnnotatorDriver {
	public static void main(String[] args) throws IOException {
		// preprocess raw test
		Preprocessor p = new Preprocessor();
		p.readChineseFile("example1.txt");
		
		// 
		Annotator anno = new Annotator(p.getText());
		anno.annotating("StanfordCoreNLP-chinese.properties");
	}
}
