
package taller1cc;

/**
 *
 * @author Francheska_Cardenas-Elizabeth_Henriquez
 */
public class NewMain {

    public static void main(String[] args) {
        long startTime = 0, endTime = 0;
        CSVreader c = new CSVreader();
        Info[] infos = c.entregarArreglo();

        int rango = 18249;

        insertSort insertSort1 = new insertSort(rango);
        quickSort quickSort1 = new quickSort(rango);

        for (int i = 0; i < rango; i++) {
            insertSort1.insert(infos[i]);
            quickSort1.insert(infos[i]);
        }

        //Item 1
        System.out.println("Item 1");
        System.out.println("Metodo insertSort:");
        insertSort1.display();
        startTime = System.currentTimeMillis();
        insertSort1.insertionSort();
        endTime = System.currentTimeMillis();
        System.out.println("");
        insertSort1.display();
        System.out.println("");
        System.out.println("Duración en Milisegundos: " + (endTime - startTime));
        System.out.println("");

        System.out.println("Metodo quickSort:");
        quickSort1.display();
        startTime = System.currentTimeMillis();
        quickSort1.quickSort();
        endTime = System.currentTimeMillis();
        System.out.println("");
        quickSort1.display();
        System.out.println("");
        System.out.println("Duración en Milisegundos: " + (endTime - startTime));
        System.out.println("");

        //Item 2
        System.out.println("Item 2");
        Queue theQueue = new Queue(5);

        theQueue.insert(infos[0].getVolume()); //inserta 6423662
        theQueue.insert(infos[1].getVolume()); //inserta 5487698
        theQueue.insert(infos[2].getVolume()); //inserta 11822022
        theQueue.insert(infos[3].getVolume()); //inserta 7899215 

        theQueue.remove();              // remove 3 items
        theQueue.remove();              //    (6423662, 5487698, 11822022)
        theQueue.remove();

        theQueue.insert(infos[4].getVolume()); //inserta 510396   
        theQueue.insert(infos[5].getVolume()); //inserta 5597978
        theQueue.insert(infos[6].getVolume()); //inserta 8345376
        theQueue.insert(infos[7].getVolume()); //inserta 10942833 

        while (!theQueue.isEmpty()) // remove and display
        {                            //    all items
            long n = theQueue.remove();  // (7899215, 510396, 5597978, 8345376, 10942833)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
