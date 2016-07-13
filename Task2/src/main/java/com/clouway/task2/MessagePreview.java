package com.clouway.task2;

import com.clouway.task1.JSONCodecConverter;

public class MessagePreview {

    public static void printAverageStats(User[] users){
        int counter = 0, temp = 0;
        double age;
        for (User each: users) {
            counter++;
            temp = temp + each.getAge();
        }
        age = (temp / counter);
        System.out.print("Users Count: " + counter + "\n" + "Average Age: " + age + "\n");
    }

    public static void main(String [] args){
        JSONCodecConverter jsonConverter = new JSONCodecConverter();

        if(args[0].equals("-type") && args[1].equals("json") && args[3].equals("--printAverageStats")){
            User[] users = (User[]) jsonConverter.unmarshal(User[].class, args[2]);
            printAverageStats(users);
        }
    }
}
