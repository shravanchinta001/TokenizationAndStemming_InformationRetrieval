import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;




public class Stemming {

	HashMap<String,Double> stemWordsCount;
	PriorityQueue<String> priorityQueue;
	
	public Stemming(HashMap<String,Double> tokens){
		stemWordsCount=new HashMap<String,Double>();
		
		for(int i=0;i<tokens.size();i++)
		{
			Stemmer temp=new Stemmer();
			String temper=tokens.keySet().toArray()[i].toString();
			for(int j=0;j<temper.toCharArray().length;j++)
			{
				temp.add(temper.toCharArray()[j]);
			}
			temp.stem();
			
			String result=temp.toString();
			
			if(stemWordsCount.containsKey(result))
			{
				double tempo=stemWordsCount.get(result);
				tempo++;
				stemWordsCount.put(result, tempo);
			}
			else
			{
				stemWordsCount.put(result, 1.0);
			}
		}
			
	}
	
	public void thirtyFrequentWords()
	{
		TComparator<String> tc=new TComparator<>();
        this.priorityQueue=new PriorityQueue<>(this.stemWordsCount.size(), tc);
        
        for(int i=0;i<this.stemWordsCount.size();i++)
        {
        	this.priorityQueue.add(this.stemWordsCount.keySet().toArray()[i].toString());
        }
        for(int i=0;i<30;i++)
        {
        	String words=this.priorityQueue.poll();
        	System.out.println(words+" - "+this.stemWordsCount.get(words));
        
        }
	}
	
	public void numberOfStemsOnce()
	{
		int count=0;
		
		for(int i=0;i<this.stemWordsCount.size();i++)
		{
			if(this.stemWordsCount.get(this.stemWordsCount.keySet().toArray()[i].toString())==1.0)
			{
				count++;
			}
		}
		
		System.out.println("Number of stems that occur only once - "+count);
	}
	
	  public class TComparator<String> implements Comparator<String>{
		     @Override
	         public int compare(String s1, String s2) {
	            if (stemWordsCount.get(s2) > stemWordsCount.get(s1)) {
	               return 1;
	            } 
	            else if(stemWordsCount.get(s2) < stemWordsCount.get(s1))
	            {
	            	return -1;
	            }
	            else 
	            {
	               return 0;
	            }
	         }
	      }

}
