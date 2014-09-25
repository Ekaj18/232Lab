package heap;

import java.util.List;
import java.util.ArrayList;

public class HeapTestDriver {

	public static void main(String[] args) {
		int[] heapArray = {4,3,6,8,1,2,5,10,15,14,12,19};
		List<Integer> heapList = new ArrayList<>();
		for(int i = 0; i < heapArray.length; i++){
			heapList.add(heapArray[i]);
		}
		Heap testHeap = new Heap(heapList);
		testHeap.heapSort();
	}

}
