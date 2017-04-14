package weeklyAssignments;

import java.util.*;

public class MinHeapSort<AnyType extends Comparable<AnyType>>
{
   private static final int CAPACITY = 2;

   private int size;
   private AnyType[] heap;

   public MinHeapSort()
   {
      size = 0;
      heap = (AnyType[]) new Comparable[CAPACITY];
   }

   public MinHeapSort(AnyType[] array)
   {
      size = array.length;
      heap = (AnyType[]) new Comparable[array.length+1];
      System.arraycopy(array, 0, heap, 1, array.length);
      buildHeap();
   }

   private void buildHeap()
   {
      for (int i = size/2; i > 0; i--)
      {
         percDown(i);
      }
   }
   
   private void percDown(int i)
   {
	   int child;
	   AnyType tmp;
	   for(tmp = heap[i]; 2*i <= size; i = child)
	   {
	         child = 2*i;
	         if(child != size && heap[child].compareTo(heap[child + 1]) > 0) 
	        	 child++;
	         if(tmp.compareTo(heap[child]) > 0)  
	        	 heap[i] = heap[child];
	         else
	        	 break;
	   }
	      heap[i] = tmp;
   }

   public AnyType deleteMin()
   {
      if (size == 0)
    	  return null;
      AnyType min = heap[1];
      heap[1] = heap[size--];
      percDown(1);
      return min;
	}
   
   public void heapSort(AnyType[] a)
   {
      size = a.length;
      heap = (AnyType[]) new Comparable[size+1];
      System.arraycopy(a, 0, heap, 1, size);
      buildHeap();

      for (int i = size; i > 0; i--)
      {
         AnyType tmp = heap[i];
         heap[i] = heap[1];
         heap[1] = tmp;
         size--;
         percDown(1);
      }
      for(int k = 0; k < heap.length-1; k++)
         a[k] = heap[heap.length - 1 - k];
      deleteMin();
   }
   
   public String toString()
   {
      String a = "";
      for(int i = 1; i <= size; i++) 
    	  a += heap[i]+" ";
      return a;
   }

   public static void main(String[] args)
   {
      MinHeapSort<Integer> integers = new MinHeapSort<Integer>();
      Integer[] a = {2,5,8,9,8,10,22,0,9,6,3,36,5,65,0,23,12,14,48};
      integers.heapSort(a);
      System.out.println(Arrays.toString(a));
   }
}
