
package taller1cc;

/**
 *
 * @author Francheska_Cardenas-Elizabeth_Henriquez
 */
public class insertSort {
    // insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
   private Info[] info; 
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   private int nElemsInfo;
//--------------------------------------------------------------
   public insertSort(int max)          // constructor
      {
      info = new Info[max];                 // create the array
      nElemsInfo = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(Info value)    // put element into array
      {
      info[nElemsInfo] = value;             // insert it
      nElemsInfo++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElemsInfo; j++)       // for each element,
        System.out.print(info[j].toString());
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out;

      for(out=1; out<nElemsInfo; out++)     // out is dividing line
         {
         Info temp = info[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && info[in-1].getVolume() >= temp.getVolume()) // until one is smaller,
            {
            info[in] = info[in-1];            // shift item to right
            --in;                       // go left one position
            }
         info[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()
//--------------------------------------------------------------
     // end class ArrayIns
////////////////////////////////////////////////////////////////
//class InsertSortApp
//   {
//   public void main(String[] args)
//      {
//      int maxSize = 100;            // array size
//      ArrayIns arr;                 // reference to array
//      arr = new ArrayIns(maxSize);  // create the array
//
//      arr.insert(77);               // insert 10 items
//      arr.insert(99);
//      arr.insert(44);
//      arr.insert(55);
//      arr.insert(22);
//      arr.insert(88);
//      arr.insert(11);
//      arr.insert(00);
//      arr.insert(66);
//      arr.insert(33);
//
//      arr.display();                // display items
//
//      arr.insertionSort();          // insertion-sort them
//
//      arr.display();                // display them again
//      }  // end main()
//   }  // end class InsertSortApp

}
