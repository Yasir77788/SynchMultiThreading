// Yasir Hassan
// This program shows the use of synchronized keyword
// in method to guard the object-state from race conditions, 
// where the method is accessed by multiple threads.

package synchMultiThreading1Package;

// Caller class implements Runnable interface.
public class Caller implements Runnable
{
	String msg;        // to store the String message
	CallMe callMeObj;  // declare a reference to an instance of the CallMe class
	Thread threadObj;  // declare a reference to an instance of the Thread class
	
	// Constructor of the Caller class which takes a reference to an instance of
	// the CallMe class and a String message.
	public Caller(CallMe callMeObj, String msg)
	{
		this.callMeObj = callMeObj;
		this.msg = msg;
		
		// create a new thread that will call this object’s run() method.
		threadObj = new Thread(this);
	}
	
	// run() method executes the thread code.
	// run() calls the call() method on
	// the object of CallMe class.
	@Override
	public void run()
	{
		callMeObj.call(msg);
	}
}