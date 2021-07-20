package dao;

import lombok.experimental.UtilityClass;
import modele.Person;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static modele.GENDER.FEMALE;
import static modele.GENDER.MALE;

@UtilityClass
public class PersonDao {

    Person person1 = Person.builder().name("Paul").email("paul@gmail.com").age(23).gender(MALE).phoneNumbers(List.of("0267890932", "0367890999")).build();
    Person person2 = Person.builder().name("Pierre").email("pierre@gmail.com").age(40).gender(MALE).phoneNumbers(Collections.singletonList("0123457609")).build();
    Person person3 = Person.builder().name("Yves").email("yves@gmail.com").age(13).gender(MALE).phoneNumbers(List.of("0367890932", "0367890999")).build();
    Person person4 = Person.builder().name("Anne").email("anne@gmail.com").age(46).gender(FEMALE).phoneNumbers(List.of("0567890932", "0567890999")).build();
    Person person5 = Person.builder().name("Sophie").email("sophie@gmail.com").age(16).gender(FEMALE).phoneNumbers(List.of("0667890932", "0667890999")).build();

    public static List<Person> getPeople() {
        return List.of(person1, person2, person3, person4, person5);
    }

    public static Map<Person, Integer> getPeopleWithBothersNumber() {
        return Map.of(person1, 1, person2, 2, person3, 3, person4, 4, person5, 5);
    }
}
