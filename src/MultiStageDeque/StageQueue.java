package MultiStageDeque;

public interface StageQueue 
{
	void addItem(Item addItem);
	Item takeItem() throws InterruptedException;
}
