package framework;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;

public class HelloImplTest {
	@Test
	public void testSayHello() {
		new MockUp<HelloImpl>() {
			@Mock
			public void sayHello() {
				System.out.println("Mocked hello");
			}
		};

		HelloImpl hello = new HelloImpl();
		hello.sayHello();
	}
}
