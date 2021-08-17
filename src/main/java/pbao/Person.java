package pbao;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Person {

//    @JSONField(name = "AGE"/*, serialize = false*/)
    private int age;

//    @JSONField(name = "LAST NAME", ordinal = 2)
    private String lastName;

//    @JSONField(name = "FIRST NAME", ordinal = 1)
    private String firstName;

//    @JSONField(name = "DATE OF BIRTH", format = "yyyy/MM/dd", ordinal = 3)
    private Date dateOfBirth;

    public Person() {
    }

    public Person(int age, String lastName, String firstName, Date dateOfBirth) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
