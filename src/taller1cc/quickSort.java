
package taller1cc;

/**
 *
 * @author Francheska_Cardenas-Elizabeth_Henriquez
 */
public class quickSort {
    // quickSort3.java
// demonstrates quick sort; uses insertion sort for cleanup
// to run this program: C>java QuickSort3App
////////////////////////////////////////////////////////////////
   private Info[] theArray;          // ref to array theArray
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public quickSort(int max)          // constructor
      {
      theArray = new Info[max];      // create the array
      nElems = 0;                    // no items yet
      }
//--------------------------------------------------------------
   public void insert(Info value)    // put element into array
      {
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)    // for each element,
      System.out.print(theArray[j].toString());
      }
//--------------------------------------------------------------
   public void quickSort()
      {
      recQuickSort(0, nElems-1);
      // insertionSort(0, nElems-1); // the other option
      }
//--------------------------------------------------------------
   public void recQuickSort(int left, int right)
      {
      int size = right-left+1;
      if(size < 10)                   // insertion sort if small
         insertionSort(left, right);
      else                            // quicksort if large
         {
         Info median = medianOf3(left, right);
         int partition = partitionIt(left, right, median);
         recQuickSort(left, partition-1);
         recQuickSort(partition+1, right);
         }
      }  // end recQuickSort()
//--------------------------------------------------------------
   public Info medianOf3(int left, int right)
      {
      int center = (left+right)/2;
                                       // order left & center
      if( theArray[left].getVolume() > theArray[center].getVolume() )
         swap(left, center);
                                       // order left & right
      if( theArray[left].getVolume() > theArray[right].getVolume() )
         swap(left, right);
                                       // order center & right
      if( theArray[center].getVolume() > theArray[right].getVolume() )
         swap(center, right);

      swap(center, right-1);           // put pivot on right
      return theArray[right-1];        // return median value
      }  // end medianOf3()
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  // swap two elements
      {
      Info temp = theArray[dex1];        // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
      }  // end swap(
//--------------------------------------------------------------
    public int partitionIt(int left, int right, Info pivot)
       {
       int leftPtr = left;             // right of first elem
       int rightPtr = right - 1;       // left of pivot
       while(true)
          {
          while( theArray[++leftPtr].getVolume() < pivot.getVolume() )  // find bigger
             ;                                  // (nop)
          while( theArray[--rightPtr].getVolume() > pivot.getVolume() ) // find smaller
             ;                                  // (nop)
          if(leftPtr >= rightPtr)      // if pointers cross,
             break;                    //    partition done
          else                         // not crossed, so
             swap(leftPtr, rightPtr);  // swap elements
          }  // end while(true)
       swap(leftPtr, right-1);         // restore pivot
       return leftPtr;                 // return pivot location
       }  // end partitionIt()
//--------------------------------------------------------------
                                       // insertion sort
   public void insertionSort(int left, int right)
      {
      int in, out;
                                       //  sorted on left of out
      for(out=left+1; out<=right; out++)
         {
         Info temp = theArray[out];    // remove marked item
         in = out;                     // start shifts at out
                                       // until one is smaller,
         while(in>left && theArray[in-1].getVolume() >= temp.getVolume())
            {
            theArray[in] = theArray[in-1]; // shift item to right
            --in;                      // go left one position
            }
         theArray[in] = temp;          // insert marked item
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------
     // end class ArrayIns


////////////////////////////////////////////////////////////////
//class QuickSort3App
//   {
//   public void main(String[] args)
//      {
//      int maxSize = 16;             // array size
//      ArrayIns arr;                 // reference to array
//      arr = new ArrayIns(maxSize);  // create the array
//
//      for(int j=0; j<maxSize; j++)  // fill array with
//         {                          // random numbers
//         long n = (int)(java.lang.Math.random()*99);
//         arr.insert(n);
//         }
//      arr.display();                // display items
//      arr.quickSort();              // quicksort them
//      arr.display();                // display them again
//      }  // end main()
//   }  // end class QuickSort3App
////////////////////////////////////////////////////////////////
}

