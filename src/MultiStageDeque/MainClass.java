package MultiStageDeque;

public class MainClass
{
	public static void main(String[] args) 
	{
		ManufacturingProcess process = new ManufacturingProcess(3); // 3-stage process
		process.start();

		// Simulate adding items to the process
		for (int i = 1; i <= 10; i++) 
		{
			Item item = new Item("Item " + i, 0, (int) (Math.random() * 10), "Description " + i);
			process.addItem(item);
			try
			{
				Thread.sleep(50); // Adding items at intervals
			} 
			catch (InterruptedException e) 
			{
				Thread.currentThread().interrupt();
			}
		}

		// Allow some time for processing
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			Thread.currentThread().interrupt();
		}
		process.stop();
	}
}
