package com.example.spring4new;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Import(MyBean.class)
public class Spring4newApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring4newApplication.class, args);
	}

}


@Configuration
class MyConfig{

	static final String BEAN_NAME = "myBar";


	@Bean(name = BEAN_NAME)
	//@Scope("prototype")
	Bar bar(Environment environment){
		System.out.println("calling-- vsrsion "+environment.getProperty("java.version"));
		return new Bar();
	}
	@Bean(name = "myBar2")
	Bar bar1(){
		return new Bar();
	}


}

class Bar{


}
class Foo{
Bar bar;
	public Foo(Bar bar) {
		this.bar= bar;
	}
}

//@ComponentScan
class MyConfigOth{


	@Bean
	Foo foo(MyConfig myConfig){
		var bar1 = myConfig.bar(null);
		for (int i = 0; i < 100; i++) {
			myConfig.bar(null);

		}

		return new Foo(bar1);
	}
}
//@Component
class Bazz{
	Bazz(){
		System.out.println("baxxx");
	}
}

class MyBean implements BeanRegistrar{


	@Override
	public void register(BeanRegistry registry, Environment env) {
		registry.registerBean(Bazz.class);
	}
}