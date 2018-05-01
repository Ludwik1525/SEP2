
public class QueueADT<T> {
	
	private static final int DEFAULT_CAPACITY = 100;
	private T[] queue;
	private int count;
	private int front;
	
	public QueueADT(int initialCapacity)
	{
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		count = 0;
		front = 0;
	}
	
	public QueueADT()
	{
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		count = 0;
		front = 0;
	}
	
	public void enqueue(T element)
	{
		if(count == queue.length)
			expandCapacity();
		queue[count] = element;
		count ++;
	}
	
	public void expandCapacity()
	{
		T[] doublesize = (T[]) new Object[2*queue.length];
		for(int i = 0; i < queue.length; i++)
			doublesize[i] = queue[i];
		queue = doublesize;
	}
	
	public T dequeue()
	{
		if(isEmpty())
			throw new IllegalStateException("Queue is empty.");

		T copy = queue[front];
		for(int i = front; i < count-1; i++)
				queue[i] = queue[i+1];
		queue[count-1] = null;
		count--;
		return copy;
	}
	public T first()
	{
		if(isEmpty())
			throw new IllegalStateException("Queue is empty.");
		return queue[front];
	}
	
	public int indexOf(T element)
	{
		for(int i = 0; i < count; i++)
			if(queue[(front + i) % queue.length].equals(element))
				return i;
		return -1;
	}
	
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	public boolean isFull()
	{
		return count == queue.length;
	}
	
	public int size()
	{
		return queue.length;
	}

}
