package sample.osgi.hello;

public class SimpleLogServiceImpl implements SimpleLogService {

	public void log(String message) {
		System.out.println(message);
	}
	
}
