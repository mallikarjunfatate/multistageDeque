package MultiStageDeque;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManufacturingProcess 
{
	private  List<StageProcessor> stages;
	private  ExecutorService executorService;
	
	public ManufacturingProcess(int stageCount)
	{
		stages = new ArrayList<StageProcessor>();
		
		StageQueue nextQueue = null;
		for (int i = stageCount-1; i >=0; i--) 
		{
			StageQueue currentQueue = (i % 2 == 0) ? new ConcurrentStageQueue() : new BlockingStageQueue();
			StageProcessor stage = new StageProcessor(currentQueue, nextQueue);
			stages.add(0,stage);
			nextQueue = currentQueue;
		}
		executorService = Executors.newFixedThreadPool(stageCount);
	}
	public void start() 
	{
        for (StageProcessor stage : stages) 
        {
            executorService.submit(stage);
        }
    }

    public void stop() 
    {
        executorService.shutdownNow();
    }
    public void addItem(Item item) 
    {
        if (!stages.isEmpty())
        {
            stages.get(0).stageQueue.addItem(item);
        }
    }
}
