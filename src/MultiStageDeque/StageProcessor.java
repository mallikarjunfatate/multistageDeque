package MultiStageDeque;

import java.util.concurrent.PriorityBlockingQueue;

public class StageProcessor implements Runnable 
{
	StageQueue stageQueue;
	private  StageQueue nextStageQueue;
	private  PriorityBlockingQueue<Item> processingQueue;
	
	// here is the multistage processing like  one stage to another
	public StageProcessor(StageQueue stageQueue, StageQueue nextStageQueue)
	{
		this.stageQueue = stageQueue; // one stage
		this.nextStageQueue = nextStageQueue;  // next stage
		this.processingQueue = new PriorityBlockingQueue<Item>();
	}
	
	@Override
	public void run() 
	{
		try 
		{
			while(!Thread.currentThread().isInterrupted())
			{				
				Item item = stageQueue.takeItem();
				processingQueue.put(item);
				processItem(item);
				if( nextStageQueue != null)
				{
					nextStageQueue.addItem(item);
				}
			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	private void processItem(Item item)
	{
		System.out.println(Thread.currentThread().getName()+"Processing " + item);
		try 
		{
			Thread.sleep(100);  // simulate processing time
		} 
		catch (Exception e) 
		{
			 Thread.currentThread().interrupt();	 
		}
	}

}
