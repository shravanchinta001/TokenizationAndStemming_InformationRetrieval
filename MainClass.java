import java.util.Timer;


public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Shravan Chinta - SXC129530");
		System.out.println();
		System.out.println();
		long startTime = System.currentTimeMillis();
		
		Tokenization tokenObject=new Tokenization(args[0]);
		System.out.println("Total Number of Tokens - "+tokenObject.totalNumberOfTokens);
		System.out.println("Number of distinct tokens - "+tokenObject.distinctTokenCount.size());
		tokenObject.numberOfTokensOnce();
		System.out.println("");
		System.out.println("Thirty most frequent tokens:");
		tokenObject.thirtyFrequentWords();
		System.out.println("");
		System.out.println("");
		System.out.println("Average number of tokens per document "+tokenObject.totalNumberOfTokens/tokenObject.fileCount);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Stemming stemObject=new Stemming(tokenObject.distinctTokenCount);
		System.out.println("Number of distinct stems - "+stemObject.stemWordsCount.size());
		stemObject.numberOfStemsOnce();
		System.out.println();
		System.out.println("Thirty frequent stems :");
		stemObject.thirtyFrequentWords();
		System.out.println();
		System.out.println();
		System.out.println("Average number of stems per document - "+tokenObject.distinctTokenCount.size()/tokenObject.fileCount);
		System.out.println();
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time Elapsed (milli seconds)- "+(endTime-startTime));
		
	}
}
