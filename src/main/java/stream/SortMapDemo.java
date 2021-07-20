package stream;

import modele.Person;

import java.util.Comparator;
import java.util.Map;

import static dao.PersonDao.getPeopleWithBothersNumber;

public class SortMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> integerStringMap = Map.of(1, "MARIE", 2, "BORRIS", 3, "CAMILLE" , 4, "MARK");
        System.out.println("***************** SORT BY KEY  ASC *********************");
        integerStringMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("***************** SORT BY VALUE  ASC *********************");

        integerStringMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        System.out.println("***************** SORT PERSON (Person is a key in our map) BY AGE ASC *********************");
        getPeopleWithBothersNumber().entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Person::getAge))).forEach(System.out::println);

        System.out.println("***************** SORT PERSON (Person is a key in our map) BY AGE DESC *********************");
        getPeopleWithBothersNumber().entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Person::getAge).reversed())).forEach(System.out::println);
    }
}
