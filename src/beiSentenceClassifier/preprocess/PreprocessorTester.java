package beiSentenceClassifier.preprocess;

import java.io.IOException;

public class PreprocessorTester {

	public static void main(String[] args) throws IOException {
		Preprocessor p = new Preprocessor();
		p.readChineseFile("example.txt");
		p.listedPrint();
	}

}
