package pbao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonTest {

    @Test
    public void test1() {
        Person p1 = new Person(18, "zhang", "san", new Date());
        String jsonStr = JSON.toJSONString(p1, true);
        System.out.println(jsonStr);
    }

    @Test
    public void test2() {
        JSONArray arr = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject obj = new JSONObject();
            obj.put("AGE", 10);
            obj.put("FULL NAME", "Doe" + i);
            obj.put("DATE OF BIRTH", new Date());
            arr.add(obj);
        }
        String jsonStr = arr.toJSONString(SerializerFeature.PrettyFormat);
        System.out.println(jsonStr);
    }

    @Test
    public void test3() {
        Person p = new Person(20, "John", "Doe", new Date());
        String jsonStr = JSON.toJSONString(p, SerializerFeature.PrettyFormat);
        System.out.println(jsonStr);

        Person newPerson = JSON.parseObject(jsonStr, Person.class);
        System.out.println("Age: " + newPerson.getAge());
        System.out.println("First Name: " + newPerson.getFirstName());
        System.out.println("Last Name: " + newPerson.getLastName());
        System.out.println("Date of Birth: " + newPerson.getDateOfBirth());
    }

    @Test
    public void test4() {
        List<Person> lst = new ArrayList<>();
        lst.add(new Person(18, "zhang", "san", new Date()));
        lst.add(new Person(20, "li", "si", new Date()));
        lst.add(new Person(22, "wang", "wu", new Date()));

        String jsonStr = JSON.toJSONString(lst, SerializerFeature.PrettyFormat);
        System.out.println(jsonStr);

        ContextValueFilter valueFilter = new ContextValueFilter() {
            @Override
            public Object process(BeanContext context, Object object, String name, Object value) {
//                System.out.println(context);
//                System.out.println(object);
//                System.out.println(name);
//                System.out.println(value);
//                return null;
                if (name.equals("DATE OF BIRTH")) {
                    return "Not to Disclose";
                }
                if (value.equals("li")) {
                    return ((String)value).toUpperCase();
                } else {
                    return null;
                }
            }
        };
        jsonStr = JSON.toJSONString(lst, valueFilter, SerializerFeature.PrettyFormat);
        System.out.println(jsonStr);
    }

    @Test
    public void test5() {
        List<Person> lst = new ArrayList<>();
        lst.add(new Person(18, "zhang", "san", new Date()));
        lst.add(new Person(20, "li", "si", new Date()));
        lst.add(new Person(22, "wang", "wu", new Date()));

        NameFilter fmtName = new NameFilter() {
            @Override
            public String process(Object object, String name, Object value) {
//                System.out.println(object);
//                System.out.println(name);
//                System.out.println(value);
//                return null;
                return name.toLowerCase().replace(' ', '_');
            }
        };

        SerializeConfig.getGlobalInstance().addFilter(Person.class, fmtName);
        String jsonStr = JSON.toJSONStringWithDateFormat(lst, "yyyy/MM/dd", SerializerFeature.PrettyFormat);
        System.out.println(jsonStr);
    }

    @Test
    public void test6() {
        Group group = new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser = new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User rootUser = new User();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addUser(guestUser);
        group.addUser(rootUser);

        String jsonString = JSON.toJSONString(group, SerializerFeature.PrettyFormat);

        System.out.println(jsonString);

    }

}
