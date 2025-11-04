package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Matt", "Christenson", 43));
        people.add(new Person("Sarah", "Nguyen", 29));
        people.add(new Person("James", "Anderson", 35));
        people.add(new Person("Olivia", "Hernandez", 27));
        people.add(new Person("James", "Lopez", 33));          // duplicate first name
        people.add(new Person("Daniel", "Kim", 51));
        people.add(new Person("Sophia", "Lopez", 25));          // duplicate last name
        people.add(new Person("Ethan", "Williams", 40));
        people.add(new Person("Ava", "Patel", 22));
        people.add(new Person("Michael", "Brown", 47));
        people.add(new Person("Isabella", "Brown", 31));        // duplicate last name
        people.add(new Person("Benjamin", "Jones", 38));
        people.add(new Person("Charlotte", "Martinez", 25));
        people.add(new Person("Amelia", "Rodriguez", 36));
        people.add(new Person("Lucas", "Miller", 41));
        people.add(new Person("Mia", "Wilson", 28));
        people.add(new Person("Henry", "Moore", 34));
        people.add(new Person("Matt", "Taylor", 30));


        while (true){
            String command = InputCollector.promptForString("Enter a name you want to search");

            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")) {
                break;
            }


            //List our data will be store into
            List<Person>matchingNames = people.stream()

                    //How we are going to find what we are looking for
                    //filer the data based on what we want (if the full name matches what we typed)
                    //.tolist takes our filtered items and make them into a list
                    .filter(person -> person.getFullName().toLowerCase().contains(command.toLowerCase())).toList();

            //use map to turn our people into just their ages and store it in s list of Integers
            List<Integer> averageAge = people.stream().map(person -> person.getAge()).toList();

            //Next we add up all of our ages
            int sum = averageAge.stream().reduce(0,(temp,num) -> temp += num);

            //divide our sum by the amount of people in our list to find the average.
            int average = sum/people.size();



            //Display the Oldest person
            List<Integer> ageListSorted = people.stream().map(person -> person.getAge()).sorted().toList();

            int youngestPerson = ageListSorted.getClass();




            System.out.println("The average age is " + average);
            System.out.println(matchingNames);


//            for(Person person: listOfNames){
//                if(person.getFirstName().contains(command)){
//                    matchingName.add(person);
//                    System.out.println(matchingName);
//                }
//            }

        }


        System.out.println("Hello world!");
    }
}