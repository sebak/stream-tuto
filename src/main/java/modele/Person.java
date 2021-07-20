package modele;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Value
public class Person {
    String name;
    int age;
    GENDER gender;
    String email;
    List<String> phoneNumbers;

    @Builder
    public Person(String name, int age, GENDER gender,  String email, List<String> phoneNumbers) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }
}
