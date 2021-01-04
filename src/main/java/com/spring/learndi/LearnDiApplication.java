package com.spring.learndi;

import com.spring.learndi.controllers.*;
import com.spring.learndi.examplebeans.FakeDataSource;
import com.spring.learndi.examplebeans.FakeJmsSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class LearnDiApplication {

	public static void main(String[] args) {


		ApplicationContext ctx = SpringApplication.run(LearnDiApplication.class, args);

		System.out.println("-------------------Language controller");
		I18nController controller = (I18nController) ctx.getBean("i18nController");
		System.out.println(controller.sayHello());

		System.out.println("-------------------Property controller");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------------------Setter controller");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------------------Constructor controller");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("-------------------Primary controller");
		//MyController myController = (MyController) ctx.getBean("myController");
		//System.out.println(myController.getGreeting());

		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUrl());

		FakeJmsSource fakeJmsSource = (FakeJmsSource) ctx.getBean(FakeJmsSource.class);

		System.out.println(fakeJmsSource.getJmsUrl());
		System.out.println(fakeJmsSource.getSecondUrl());

	}

}
