package demo.basic;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class GenericMain {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        context.refresh();

        HelloApi hello = context.getBean("hello", HelloApi.class);
        hello.sayHello();
    }

}
