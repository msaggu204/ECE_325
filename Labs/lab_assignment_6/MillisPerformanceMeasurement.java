package ece325_lab_assignment6;

public class MillisPerformanceMeasurement implements PerformanceMeasurement {
	long start;
	long end;
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void end() {
		end = System.currentTimeMillis();
	}
	
	public void reset() {
		start = 0;
		end = 0;
	}
	
	public long getResult() {
		long result = end - start;
		toString(result);
		return result;
	}
	
	public void toString(long result) {
		String time = "Task completed in " + result + " ms.";
		System.out.println(time);
	}
}
