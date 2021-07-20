package stream;

import modele.Person;

import java.util.List;

import static dao.PersonDao.getPeople;

public class OptionalDemo {

    public static Person getPersonByEmail(String email) throws Exception {
        List<Person> persons = getPeople();
        return persons.stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new Exception("no person with the email: " + email ));
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Display paul: " + getPersonByEmail("paul@gmail.com"));
        System.out.println("Display new person when email not exist: " + getPersonByEmail("pepito@gmail.com"));
    }
}
