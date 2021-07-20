package stream;


import modele.Person;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static dao.PersonDao.getPeople;

public class MapVsFlatMapDemo {
    /* 1- map is one to one mapping it get one stream and apply a function and return another stream
    Example:
    Stream.of("A", "B", "C", "D") after transformation in map by calling lowerCase function we will retrieve a new stream of
    ["a", "b", "c", "d"]

    2- flatMap flat a stream who contains other stream or collections before applying any method
     Example:
        Stream.of(["A", "B"], ["C", "D"], ["E", "F"]) when we flatMap it we have a one level stream as
        Stream.of("A", "B", "C", "D", "E", "F")
     */

    public static void main(String[] args) {
        List<Person> persons = getPeople();
        List<String> names = persons.stream().map(Person::getName).collect(Collectors.toList());

        System.out.println(names);

        //
        List<List<String>> phoneNumbers = persons.stream().map(Person::getPhoneNumbers).collect(Collectors.toList());

        System.out.println(phoneNumbers);

        // To avoid previous list of list i need to use flatMap which process stream of stream of value
        List<String> phonesNumbers = persons.stream().flatMap(person -> person.getPhoneNumbers().stream()).collect(Collectors.toList());

        System.out.println(phonesNumbers);

    }
}
