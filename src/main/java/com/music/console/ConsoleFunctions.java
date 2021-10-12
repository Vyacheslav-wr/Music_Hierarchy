package com.music.console;

import com.music.model.Genres;

import java.util.Scanner;

public class ConsoleFunctions {

    public static String consoleInputAuthorName(){
        try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter author name");
        String name = scanner.next();
        return name;
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }
    }

    public static String consoleInputSongName(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter song name");
            String name = scanner.next();
            return name;
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }
    }

    public static int consoleInputDuration(){
        try{
            Scanner scanner = new Scanner(System.in);
            int duration;

            System.out.println("Enter song duration in seconds");
            duration = scanner.nextInt();
            return duration;
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }
    }

    public static Genres consoleInputGenre(){
        try{
            Scanner scanner = new Scanner(System.in);
            int name;

            System.out.println("Choose genre form the list");
            System.out.println("1. " + Genres.Classic + "\n" + "2. " + Genres.EDM + "\n" + "3. " + Genres.Dubstep + "\n" +
                    "4. " + Genres.Jazz + "\n" + "5. " + Genres.Metal + "\n" + "6. " + Genres.Pop + "\n" +
                    "7. " + Genres.Rap + "\n" + "8. " + Genres.Rock);
            name = scanner.nextInt();
            switch(name){
                case 1: return Genres.Classic;
                case 2: return Genres.EDM;
                case 3: return Genres.Dubstep;
                case 4: return Genres.Jazz;
                case 5: return Genres.Metal;
                case 6: return Genres.Pop;
                case 7: return Genres.Rap;
                case 8: return Genres.Rock;
                default: return Genres.Pop;
            }
        }
        catch(IllegalArgumentException ex){
            throw ex;
        }
    }
}
