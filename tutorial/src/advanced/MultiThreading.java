/*
Inaccurately, Thread is a part of a "process", a subprocess that can
run concurrently with other threads. They are independent and have
separate environment of execution. Threads share the memory of their
(parent) process.
The process of executing multiple threads simultaneously is known
as multithreading. Thus we can simultaneously execute parts of the
program to maximize CPU utilization.

A thread can be in one of the following states:
NEW – A thread that has not yet started is in this state.
RUNNABLE – A thread executing in the Java virtual machine is in this state.
BLOCKED – A thread that is blocked waiting for a monitor lock is in this state.
WAITING – A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
TIMED_WAITING – A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
TERMINATED – A thread that has exited is in this state.

A thread can be in only one state at a given point in time.

Thread Scheduling is a very important concept in multithreaded systems.
Number of threads may be far more than number of available CPU cores.
So each thread must be scheduled to access CPU time. Java schedules
based on priority. A high priority thread can preempt a low priority
one. There are multiple priority-based scheduling algorithms.

Methods:
wait(): the thread gives up the lock on an object and let other threads
acquire it.
notify(): wakes up all the threads that called wait() on the same
object.
the above two methods along with notifyAll() are used for communication
between methods.
yield(): give other threads (with same priority) a chance to run. In
other words, it causes current thread to move to runnable state.
sleep(): pause a thread for a specified period of time i.e. moves the
current thread to Sleep state for a specified amount of time.

Thread Priority is between MIN_PRIORITY(1) and MAX_PRIORITY(10)
normally default on 5.

isAlive(): is used to determine whether a thread is still running (but
not yet finished)
join(): allows the thread to wait until another thread completes its
execution

Designing a multi thread program is hard. You should be aware of the
background process and how operating system and Java itself mange
threads.

Deadlock:
When two threads or processes are waiting for each other to release
the resource or object they hold and so are blocked forever

Some definitions:
Multitasking: Ability to execute more than one task at the same time
is known as multitasking.
Multithreading: We already discussed about it. It is a process of
executing multiple threads simultaneously. Multithreading is also
known as Thread-based Multitasking.
Multiprocessing: It is same as multitasking, however in
multiprocessing more than one CPUs are involved. On the other hand
one CPU is involved in multitasking.
Parallel Processing: It refers to the utilization of multiple CPUs
in a single computer system.
 */

package advanced;

public class MultiThreading {
    public MultiThreading() {
//        threadExample1();

        // inline thread example
        threadExample2();
    }

    private void threadExample2() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In thread run() method");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("Is the main thread blocked?");
        th.start();
        System.out.println("I don't think so");
    }

    private void threadExample1() {
        Count c = new Count();
        try {
            while (c.isAlive()) {
                System.out.println("Main thread alive");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MultiThreading();
    }
}

class Count extends Thread {
    Count() {
        // Not necessary
        super("In child thread");
        // this initialize necessary steps to start the thread
        // and then call run() method.
        start();
    }

    @Override
    public void run() {
        // Not necessary
        super.run();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Counting: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Run is finished");
    }
}
