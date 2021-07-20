package stream;

import modele.GENDER;
import modele.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static dao.PersonDao.getPeople;
import static modele.GENDER.FEMALE;
import static modele.GENDER.MALE;

public class StreamTraining {


    public static void main(String[] args) {
        List<Person> personList = getPeople();

        System.out.println("***************** FILTER *********************");
        List<Person> males = personList.stream()
                .filter(person -> MALE.equals(person.getGender()))
                .collect(Collectors.toList());

        males.forEach(System.out::println);

        System.out.println("***************** SORT ASC OF PRIMITIVE TYPES *********************");
        List<Integer> integerList = List.of(1, 2, 4, 79, 34, 45);
        integerList.stream().sorted().forEach(integer -> System.out.println(integer));

        System.out.println("***************** SORT DESC OF PRIMITIVE TYPES *********************");
        integerList.stream().sorted(Comparator.reverseOrder()).forEach(integer -> System.out.println(integer));

        System.out.println("***************** SORT DESC *********************");
        List<Person> personByAgeDesc = personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

       personByAgeDesc.forEach(System.out::println);

        System.out.println("***************** SORT ASC *********************");
        List<Person> personByAgeAsc = personList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

        personByAgeAsc.forEach(System.out::println);

        System.out.println("***************** ALL MATCH *********************");
        boolean isAllPersonAgeBiggerThan23 = personList.stream()
                .allMatch(person -> person.getAge() > 23);
        System.out.println(isAllPersonAgeBiggerThan23);

        System.out.println("***************** ANY MATCH *********************");
        boolean isAtLeastOnePersonAgeBiggerThan23 = personList.stream()
                .anyMatch(person -> person.getAge() > 23);
        System.out.println(isAtLeastOnePersonAgeBiggerThan23);

        System.out.println("***************** NONE MATCH *********************");
        boolean isNoPersonHasName = personList.stream()
                .noneMatch(person -> "Pamela".equals(person.getName()));
        System.out.println(isNoPersonHasName);

        System.out.println("***************** MAX *********************");
        personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println); // becarefull when to person have the same age

        System.out.println("***************** MIN *********************");
        personList.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println); // becarefull when to person have the same age

        System.out.println("***************** Group *********************");
        Map<GENDER, List<Person>> personsByGender = personList.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println(personsByGender);

        System.out.println("***************** Mix previous function to get oldest female name *********************");
        personList.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

    }
}
