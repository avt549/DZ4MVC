package otusApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class OtusApplication {


	@RequestMapping( value = "/user/get/{id}")
	public String getUsers(@PathVariable(value="id") Integer id) {
		Map<String, Object> model = new HashMap<>();
		model.put("name","Test user");
		model.put("score",id);
		System.out.println(buildJSONFromObject(model));
		return buildJSONFromObject(model);
	}

	@RequestMapping(value = "/cource/get/all")
	public String getCourses() {
		ArrayList<Object> list = new ArrayList<>();

		list.add(courses("QA java",15000));
		list.add(courses("Java",12000));
		System.out.println(list.toString());
		return buildJSONFromObject(list);
	}
	@RequestMapping(value = "/user/get/all")
	public String hello3() {
		ArrayList<Object> list = new ArrayList<>();
		list.add(users("Test user","QA","test@test.test",23));
		list.add(users("java user","java","java@test.test",33));
		String response = buildJSONFromObject(list);;
		return response;

	}

	public static void main(String[] args) {
		SpringApplication.run(OtusApplication.class, args);
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
	public static <T> String buildJSONFromObject(T object) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String jsonString;
		try {
			jsonString = gson.toJson(object);
		} catch (JsonSyntaxException ex) {
			ex.printStackTrace();
			jsonString = "";
		}
		return jsonString;
	}


}
