import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;



public class Tokenization {

	double fileCount;
	double totalNumberOfTokens;
	HashMap<String,Double> distinctTokenCount;
	PriorityQueue<String> priorityQueue;
	
	public Tokenization(String filepath)
	{
		fileCount=0;
		totalNumberOfTokens=0;
		distinctTokenCount=new HashMap<String,Double>();
		
		
		File dir=new File(filepath);
		File[] directoryListing=dir.listFiles();
		
		
		if(directoryListing != null)
		{
			for(File file:directoryListing)
			{
				
				InputReader in=new InputReader(file.getPath());
				
				while(!in.isEmpty())
				{
					String temp=in.readString();
					if(temp.contains("<")&&temp.contains(">"))
					{
						continue;
					}
					else
					{
						if(distinctTokenCount.containsKey(temp))
						{
							double tempo=distinctTokenCount.get(temp);
							tempo++;
							distinctTokenCount.put(temp, tempo);
						}
						else
						{
							distinctTokenCount.put(temp, 1.0);
						}
					}
					
					totalNumberOfTokens++;
				}
				fileCount++;				
			}
		}
		
				
	}
	
	public void numberOfTokensOnce()
	{
		int count=0;
		
		for(int i=0;i<this.distinctTokenCount.size();i++)
		{
			if(this.distinctTokenCount.get(this.distinctTokenCount.keySet().toArray()[i].toString())==1.0)
			{
				count++;
			}
		}
		
		System.out.println("Tokens that occur only once - "+count);
	}
	
	public void thirtyFrequentWords()
	{
		TComparator<String> tc=new TComparator<>();
        this.priorityQueue=new PriorityQueue<>(this.distinctTokenCount.size(), tc);
        
        for(int i=0;i<this.distinctTokenCount.size();i++)
        {
        	this.priorityQueue.add(this.distinctTokenCount.keySet().toArray()[i].toString());
        }
        for(int i=0;i<30;i++)
        {
        	String words=this.priorityQueue.poll();
        	System.out.println(words+" - "+this.distinctTokenCount.get(words));
        
        }
	}
	
	  public class TComparator<String> implements Comparator<String>{
		     @Override
	         public int compare(String s1, String s2) {
	            if (distinctTokenCount.get(s2) > distinctTokenCount.get(s1)) {
	               return 1;
	            } 
	            else if(distinctTokenCount.get(s2) < distinctTokenCount.get(s1))
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
