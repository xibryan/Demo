package framework;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
        HelloApi hello = context.getBean("hello", HelloApi.class);  
        hello.sayHello(); 
        context.close();
    }

}
