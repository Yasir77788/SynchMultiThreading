// Yasir Hassan
// This program shows the use of synchronized keyword
// in method to guard the object-state from race conditions, 
// where the method is accessed by multiple threads.

package synchMultiThreading1Package;

public class Synch
{
	public static void main(String[] args)
	{
		// create a CallMe object (or instance)
		CallMe callMeObj = new CallMe();
		
		// Create or instantiate Caller's objects.
		// Pass a reference of a CallMe class and a String message.
		Caller callerObj1 = new Caller(callMeObj, "Hello");
		Caller callerObj2 = new Caller(callMeObj, "Synchronized");
		Caller callerObj3 = new Caller(callMeObj, "World");
		
		// start the threads by calling
		// start method on a Thread object.
		callerObj1.threadObj.start();
		callerObj2.threadObj.start();
		callerObj3.threadObj.start();
		
		// wait for the threads to end.
		try
		{
			callerObj1.threadObj.join();
			callerObj2.threadObj.join();
			callerObj3.threadObj.join();
		}
		// join() might throw an Interrupted Exception.
		catch(InterruptedException e) 
		{
			System.out.println("Thread interrupted.");
		}
	}
}