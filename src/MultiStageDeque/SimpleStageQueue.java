package MultiStageDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleStageQueue implements StageQueue
{
	private final Deque<Item> queue;
	public SimpleStageQueue()
	{
		this.queue = new ArrayDeque<Item>();
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
