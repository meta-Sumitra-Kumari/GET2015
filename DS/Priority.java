/**
 * @author Sumitra
 * node POGO class
 */
public class Priority {

	private TaskNode[] heap;
	private int heapSize, capacity;

	// Constructor calling
	public Priority(int capacity) {
		this.capacity = capacity + 1;
		heap = new TaskNode[this.capacity];
		heapSize = 0;
	}

	/**
	 * checking whether heap is empty or not
	 */
	public boolean isEmpty() {
		return heapSize == 0;
	}

	/**
	 * checking for heap size
	 */
	public int size() {
		return heapSize;
	}

	/**
	 * ----function to insert job in heap based on priority
	 * 
	 * @param job
	 *            ----job to print
	 * @param priority
	 *            ----priority of job
	 */
	public void insert(String job, int priority) {
		if (heapSize == capacity - 1) {
			System.out.println("No more insertion possible");
			return;
		}

		TaskNode newJob = new TaskNode(job, priority);

		heap[++heapSize] = newJob;
		int pos = heapSize;
		while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
			heap[pos] = heap[pos / 2];
			pos = pos / 2;
		}
		heap[pos] = newJob;
	}

	/**
	 * Function to print top most priority job and delete it from heap
	 */
	public void remove() {
		int parent, child;
		TaskNode item, temp;
		if (isEmpty()) {
			System.out.println("Heap is empty");
			return;

		}

		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;
		while (child <= heapSize) {
			if (child < heapSize
					&& heap[child].priority < heap[child + 1].priority)
				child++;
			if (temp.priority >= heap[child].priority)
				break;

			heap[parent] = heap[child];
			parent = child;
			child = child * 2;
		}
		heap[parent] = temp;

		System.out.println("item to print is		" + item.job);
		System.out.println("item is of priority		" + item.priority);
	}
}
