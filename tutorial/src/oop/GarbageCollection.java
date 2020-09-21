/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
When JVM starts up, it creates a heap area which is known as
runtime data area. This is where all the objects (instances of class)
are stored. Since this area is limited, it is required to manage this
area efficiently by removing the objects that are no longer in use.
The process of removing unused objects from heap memory is known as
Garbage collection and this is a part of memory management in Java.
 */

package oop;

public class GarbageCollection {
    public GarbageCollection() {
        TooMuchMemory tmm = new TooMuchMemory();
        // TooMuchMemory object created above will no longer be used
        // It's wise to remove it from the heap memory
        tmm = null;

        // Another scenario
        TooMuchMemory t1 = new TooMuchMemory();
        TooMuchMemory t2 = new TooMuchMemory();
        // The second TooMuchMemory created will no longer be used and
        // is available to be garbage collected
        t2 = t1;
    }

    public static void main(String[] args) {
        new GarbageCollection();
    }
}

class TooMuchMemory {
    double a1;
    double a2;
    double a3;
    double a4;
}

// Let's see how GC works in action
class GCInAction {
    public static void main(String[] args) {
        GCInAction g1 = new GCInAction();
        g1 = null;

        GCInAction g2 = new GCInAction();
        GCInAction g3 = new GCInAction();
        g3 = g2;

        // How many objects are going to be garbage collected?
        System.gc();
    }

    // This method is invoked every time an object is destroyed by GC.
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC is triggered by JVM!");
    }
}
