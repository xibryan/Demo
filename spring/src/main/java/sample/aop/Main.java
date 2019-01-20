package sample.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.spring.framework.HelloApi;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Dog dog = context.getBean("dog", Dog.class);
		dog.eat();
		context.close();
	}
}
