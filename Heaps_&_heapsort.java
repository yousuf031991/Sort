package heaps;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {

	/**
	 * @param heap
	 * @param lastIndex
	 *            places deleted root node at the lastIndex position and make
	 *            the resultant array a heap
	 */
	public static void maximumKeyDeletion(int heap[], int lastIndex) {
		int temp = heap[1];
		heap[1] = heap[lastIndex];
		heap[lastIndex] = temp;
		int v = heap[1];
		int k = 1;
		boolean isHeap = false;
		while (!isHeap && k * 2 < lastIndex) {
			int j = k * 2;
			if (j < lastIndex - 1) {
				if (heap[j] < heap[j + 1]) {
					j = j + 1;
				}
			}
			if (heap[k] > heap[j]) {
				isHeap = true;
			} else {
				heap[k] = heap[j];
				k = j;
			}
		}
		heap[k] = v;
	}

	/**
	 * @param heap
	 *            makes the array a heap
	 */
	public static void heapify(int heap[]) {
		int n = heap.length - 1;
		for (int i = n / 2; i >= 1; i--) {
			int k = i;
			int v = heap[k];
			boolean isHeap = false;
			while (!isHeap && 2 * k <= n) {
				int j = 2 * k;
				if (j < n) {
					if (heap[j] < heap[j + 1]) {
						j = j + 1;
					}
				}
				if (v >= heap[j]) {
					isHeap = true;
				} else {
					heap[k] = heap[j];
					k = j;
				}
			}
			heap[k] = v;
		}
	}

	public static void heapSort(int heap[]) {
		heapify(heap);
		int len = heap.length - 1;
		while (len > 1) {
			maximumKeyDeletion(heap, len--);
			System.out.println(Arrays.toString(heap));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of elements in heap?");
		int n = sc.nextInt();
		int heap[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			heap[i] = sc.nextInt();
		}
		heapSort(heap);
		sc.close();
	}
}
