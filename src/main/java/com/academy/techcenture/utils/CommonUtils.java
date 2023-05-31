package com.academy.techcenture.utils;

import com.academy.techcenture.pojos.Customer;
import com.github.javafaker.Faker;

import java.util.Locale;

public class CommonUtils {
    private CommonUtils(){

    }

    private static Faker faker = new Faker(Locale.US);

    /**
     * Generates a random number between min and max both inclusive
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max){

        return (int)(Math.random() * max) + min;
    }


    public static Customer getRandomCustomer(){
        Customer customer = new Customer();
        customer.setEmailAddress(faker.internet().emailAddress());
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setFullName(faker.name().fullName());
        customer.setStreetAddress(faker.address().streetAddress());
        customer.setCity(faker.address().city());
        String state = faker.address().stateAbbr();
        customer.setState(state);
        customer.setZip(faker.address().zipCodeByState(state));
        return customer;
    }

    public static String generateRandomCreditCardNumber(){
        long ccNumber = (long)(Math.random()*10000000000000000l)+1;
        return String.valueOf(ccNumber);
    }
    public static String generateDate() {
        int randomYear = (int) (Math.random() * 98 + 1);
        int randomMonth = (int) (Math.random() * 11 + 1);
        String result = null;
        if (randomMonth < 10) {
            result = "0" + randomMonth + "/" + randomYear;
        }
        else{
            result = randomMonth + "/" + randomYear;
        }
        return result;
    }


}


