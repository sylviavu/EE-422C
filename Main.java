/*
 * CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Student 1 Name: Norman Wang
 * Student 1 EID: NW6596
 * Student 1 Unique No: 16325
 * Student 2 Name: Sylvia Vu
 * Student 2 EID: sav987
 * Student 2 Unique No: 16330
 * Slip days used: <0>
 * Spring 2020
 */

package assignment4;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.reflect.Method;

/*
 * Usage: java <pkg name>.Main <input file> test input file is
 * optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */

public class Main {

    /* Scanner connected to keyboard input, or input file */
    static Scanner kb;

    /* Input file, used instead of keyboard input if specified */
    private static String inputFile;

    /* If test specified, holds all console output */
    static ByteArrayOutputStream testOutputString;

    /* Use it or not, as you wish! */
    private static boolean DEBUG = false;

    /* if you want to restore output to console */
    static PrintStream old = System.out;

    /* Gets the package name.  The usage assumes that Critter and its
       subclasses are all in the same package. */
    private static String myPackage; // package of Critter file.

    /* Critter cannot be in default pkg. */
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     *
     * @param args args can be empty.  If not empty, provide two
     *             parameters -- the first is a file name, and the
     *             second is test (for test output, where all output
     *             to be directed to a String), or nothing.
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
            }
            if (args.length >= 2) {
                /* If the word "test" is the second argument to java */
                if (args[1].equals("test")) {
                    /* Create a stream to hold the output */
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    /* Save the old System.out. */
                    old = System.out;
                    /* Tell Java to use the special stream; all
                     * console output will be redirected here from
                     * now */
                    System.setOut(ps);
                }
            }
        } else { // If no arguments to main
            kb = new Scanner(System.in); // Use keyboard and console
        }
        commandInterpreter(kb);

        System.out.flush();
    }

    /* Do not alter the code above for your submission. */

    private static void commandInterpreter(Scanner kb) {
        String in;

        while(true){
            System.out.println("critters> ");
            in = kb.nextLine();
            String[] args = in.split(" ");

            if(args[0].equals("quit")){
                if(args.length > 1)
                    error(args);

                return;
            }

            else if(args[0].equals("show")){
                if(args.length > 1)
                    error(args);

                Critter.displayWorld();
            }

            else if(args[0].equals("step")){
                if(args.length > 3)
                    error(args);
                
                if(args.length == 1)
                    Critter.worldTimeStep();
                
                else{
                    try{
                        countStep(args);
                    }
                    catch(NumberFormatException n){
                        error(args);
                    }
                }
            }

            else if(args[0].equals("seed")){
                if(args.length > 3)
                    error(args);
                
                else{
                    try{
                        int newSeed = Integer.parseInt(args[1]);
                        Critter.setSeed(newSeed);
                    }
                    catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                        error(args);
                    }
                }
            }

            else if(args[0].equals("create")){
                if(args.length > 3)
                    error(args);

                else{
                    try{
                        countCreate(args);
                    }
                    catch(InvalidCritterException | NumberFormatException | NoClassDefFoundError e){
                        error(args);
                    }
                }
            }

            else if(args[0].equals("stats")){
                try{
                    statsMain(args);
                }
                catch(ClassNotFoundException | InvalidCritterException | SecurityException | IllegalAccessException |
                        IllegalArgumentException | InvocationTargetException | NoSuchMethodException e){
                            error(args);
                }
            }

            else if(args[0].equals("clear")){
                if(args.length != 1)
                    error(args);
                else Critter.clearWorld();
            }
            
            else System.out.println("invalid command: " + String.join(" ", args));
        }
    }

    /**
     * Method to produce error message if an exception occurs during the execution of a command
     * @param args
     */
    public static void error(String[] args){
        System.out.println("error processing: " + String.join(" ", args));
    }

    /**
     * 
     * @param args
     * @throws NumberFormatException
     */
    public static void countStep(String[] args) throws NumberFormatException{
        int count = Integer.parseInt(args[1]);

        for(int i=0; i<count; i++){
            Critter.worldTimeStep();
        }
    }

    /**
     * 
     * @param args
     * @throws InvalidCritterException
     * @throws NumberFormatException
     * @throws ArrayIndexOutOfBoundsException
     */
    public static void countCreate(String[] args) throws InvalidCritterException,
                                                                NumberFormatException, ArrayIndexOutOfBoundsException{

        String input_class = args[1];
        if(args.length == 2){
            Critter.createCritter(input_class);
        }
        else{

            int count = Integer.parseInt(args[2]);
        
            for(int i=0; i<count; i++){
                Critter.createCritter(input_class);
            }
        }

    }

    /**
     * 
     * @param args
     * @throws ClassNotFoundException
     * @throws InvalidCritterException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static void statsMain(String[] args) throws ClassNotFoundException, InvalidCritterException, 
                SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
                                                                        NoSuchMethodException{

        List<Critter> critterList = Critter.getInstances(args[1]);
        Class<?>[] critterType = {List.class};
        Method doStats = Class.forName(myPackage + "." + args[1]).getMethod("doStats", critterType);
        doStats.invoke(null, critterList);
    }



}
