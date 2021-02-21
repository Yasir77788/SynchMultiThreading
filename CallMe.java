// Yasir Hassan
// This program shows the use of synchronized keyword
// in method to guard the object-state from race conditions, 
// where the method is accessed by multiple threads.

package synchMultiThreading1Package;

// CallMe class uses a synchronized method to prevents 
// other threads from entering call() method while another thread 
// is using it.
public class CallMe
{
	/**
	 * call() is a synchronized method to prevent race condition.
	 * call() should print out a string in square brackets.
	 * @param str message passed to this method.
	 */
	synchronized void call(String str)
	{
		System.out.print("[" + str);
		
		// by calling sleep( ), the call() method allows the execution to
		// switch from the current thread to another thread.
		try
		{
			Thread.sleep(1000); // wait for a second.
		}
		catch(InterruptedException e) // sleep() might throw an exception
		{
			System.out.println("Thread interrupted.");
		}
		System.out.println("]"); // print the closing bracket.
	}
}