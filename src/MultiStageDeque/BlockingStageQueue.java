package MultiStageDeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingStageQueue implements StageQueue
{
	private final BlockingDeque<Item> queue;
	
	public BlockingStageQueue()
	{
		this.queue = new LinkedBlockingDeque<Item>();
	}

	@Override
	public void addItem(Item addItem) 
	{
		try {
        queue.put(addItem);
    } 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
		}	
	}

	@Override
	public Item takeItem() throws InterruptedException 
	{
		return queue.take();
	}
}
