package MultiStageDeque;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentStageQueue implements StageQueue
{
	private final ConcurrentLinkedDeque<Item> queue;
	
	public ConcurrentStageQueue() 
	{
		this.queue = new ConcurrentLinkedDeque<Item>();
	}

	@Override
	public void addItem(Item addItem) 
	{
		queue.offer(addItem);
	}

	@Override
	public Item takeItem() throws InterruptedException 
	{
		return queue.poll();
	}

}
