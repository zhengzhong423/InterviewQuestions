package sort;

public class Heap {

	public static void main(String[] args) {
	}

	// heap sort
	public void heapSort(int[] a) {
		for (int i = a.length/2; i >=0; i--)
			HeapDown(a, i, a.length);
	}

	// add element
	public void HeapUp(int[] a, int i) {
		int temp = a[i];
		int j = (i - 1) / 2;
		while (j >= 0 && i != 0) {
			if (a[j] > temp)
				break;
			a[i] = a[j];
			i = j;
			j = (i - 1) / 2;
		}
		a[i] = temp;
	}

	// delete element
	public void deleteHeap(int[] a, int n) {
		// swap element
		int temp = a[0];
		a[0] = a[n - 1];
		a[n - 1] = temp;
		HeapDown(a, 0 ,n - 1);
	}

	public void HeapDown(int[] a, int i ,int n) {
		int j = i * 2 + 1;
		int temp = a[i];
		while (j < n) {
			if (j + 1 < n && a[j + 1] < a[j])
				j++;
			if (temp <= a[j])
				break;
			a[i] = a[j];
			i = j;
			j = i * 2 + 1;
		}
		a[i] = temp;
	}

}
