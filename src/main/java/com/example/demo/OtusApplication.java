package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Цель:
Реализовать Stub сервер со следующими методами-заглушами

получение списка пользователей
получение списка курсов
оценка пользователя
Описание/Пошаговая инструкция выполнения домашнего задания:
Необходимо реализовать Stub сервер на Spring(mockito, wiremock) со следующими endpoint'ами:

/user/get/{id} для получение оценки пользователя          Для оценки: { "name":"Test user", "score": 78 }
/cource/get/all для получения списка курсов                    [ { "name":"QA java", "price": 15000 }, { "name":"Java", "price": 12000 } ]
/user/get/all - для получения списка всех пользоваелей Контракты  Для user { "name":"Test user", "cource":"QA", "email":"test@test.test" "age": 23 }

Подключить stub frontend,


написать тесты для проверки json cхем.
 */

@RestController
@SpringBootApplication
public class OtusApplication {


	@RequestMapping( value = "/user/get/{id}")
	public String getUsers(@PathVariable(value="id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		model.put("name","Test user");
		model.put("score",id);
		System.out.println(model.toString());
		return model.toString();
	}
	public Map<String,Object> courses(String name,Object price){
		Map<String,Object> map1 = new HashMap<>();
		map1.put("name",name);
		map1.put("price",price);
		return map1;
	}

	public Map<String,Object> users(String name,String cource,String email,Object age){
		Map<String,Object> map1 = new HashMap<>();
		map1.put("name",name);
		map1.put("cource",cource);
		map1.put("email",email);
		map1.put("age",age);
		return map1;
	}
	@RequestMapping(value = "/cource/get/all")
	public String getCourses() {
ArrayList<Object> list = new ArrayList<>();

		list.add(courses("QA java",15000));
		list.add(courses("Java",12000));
		System.out.println(list.toString());
		return list.toString();
	}
	@RequestMapping(value = "/user/get/all")
	public String hello3(ArrayList<Object> model) {
		ArrayList<Object> list = new ArrayList<>();
		model.add(users("Test user","QA","test@test.test",23));
		model.add(users("java user","java","java@test.test",33));
		String response = list.toString();
		System.out.println(list.toString());
		return response;
//		return "[{price=15000, name=QA java}, {price=12000, name=Java}]";
	}
	@GetMapping
	public String main(Map<String, Object> model) {
		model.put("", "Hello OTUS team!");
		return "main";
	}

	@RequestMapping(value = "/hello/{name}")
	public String helloUser(@PathVariable(value="name") String name) {
		return String.format("Hello %s", name);
	}

	public static void main(String[] args) {
		SpringApplication.run(OtusApplication.class, args);
	}


}
