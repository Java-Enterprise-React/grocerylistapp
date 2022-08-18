package com.revature.util;

import java.util.Scanner;

public class InputUtil {

    Scanner scanner = new Scanner(System.in);

    public String retrieveString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public Integer retrieveInt(String msg) {
        
        Integer num = 0;
        Boolean valid = false;
        while (!valid) {
            System.out.print(msg);
            try {
                num = Integer.parseInt(scanner.nextLine());
                //throw new RuntimeException();  //this is how we manually throw an exception
                valid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Not a number...");
            } catch (Exception e){
                e.printStackTrace();
            }  finally{
                //this will run if an exception happens or not
            }
        }

        return num;
    }
}
