/*
 *This class will check the spelling from text to dictionary
 * the user will decide if they want to transpose data by editing the configuration
 * or put the data accessed most at front
 * or does not change the data
 * The output file will be in final.dictionary.txt
 */


import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

public class SpellChecker2 {
    public static void main(String[] args) throws IOException {
        /*
            Create three empty list to store dictionary, misspelled and unique
         */
        WCLinkedList dictionary = null;
        WCLinkedList misspelled = null;
        WCLinkedList unique = null;

        /*
         * check what user want to do
         * -t will transpose the list
         * -c will put the word accessed most ahead
         * -s will remain the samn
         */
        if (args[0].equals("-t")) {
            dictionary = new TWCLinkedList();
            misspelled = new TWCLinkedList();
            unique=new TWCLinkedList();
        }
        if (args[0].equals("-s")) {
            dictionary = new WCLinkedList();
            misspelled = new WCLinkedList();
            unique=new WCLinkedList();
        }

        if (args[0].equals("-c")) {
            dictionary = new CWCLinkedList();
            misspelled = new CWCLinkedList();
            unique=new CWCLinkedList();
        }

        /* input the dictionary from dictionary. txt
          * using a while loop to parse the dictionary
          *add data in dictionary to dictionary list
         */
        FileReader file1 = new FileReader(args[1]);
        Scanner s2 = new Scanner(file1);
        String[] temp3;
        while (s2.hasNext()) {
            temp3 = s2.next().replaceAll("[^A-Za-z0-9]", " ").toLowerCase().split(" ");

            for (int j = 0; j < temp3.length; j++)
                {

                    dictionary.addLast(temp3[j]);
                }
                }




        /*input the txt
           check if the data in the text is in the dictionary
           if contained, first addlast to the unique list
           if misspelled, add last ot the misspelled list
         */
        final long startTime = System . currentTimeMillis ();// time counter

        FileReader file = new FileReader(args[2]);
        Scanner s1 = new Scanner(file);

        String[] temp1;
        while (s1.hasNext()) {
            temp1 = s1.next().replaceAll("[^A-Za-z0-9]", " ").toLowerCase().split(" ");

            for (int j = 0; j < temp1.length; j++) {
                if (!unique.contain(temp1[j])) {
                    unique.addLast(temp1[j]);// check unique
                }
                if (!dictionary.contain(temp1[j]) && !unique.contain(temp1[j])) {
                    misspelled.addLast(temp1[j]);// check if misspelled
                }



            }
        }

                /*
        the time will count how long will it take to check if contained and do the swap or transpose
         */
        final long endTime = System . currentTimeMillis ();// final time

        // Try to open file

        FileWriter writer = new FileWriter(new File("final."+args[1]));


        System.out.println("Words: " + dictionary.size + ", unique words: " + unique.size + ", misspelled: " + misspelled.size);

        /*
        *Using a list iterator and enhance for loop to write the output to the final.dictionary .txt file
        * then close file
         */
      ;
        for (String data: dictionary){
            writer.write(data);
            writer.write("\n");
        }
        writer.flush();
       writer.close();

        // out put the information
        System . out . println ("time to complete : " + ( endTime - startTime ) + " msec ");
        System.out.println("managed dictionary written to: final.dictionary.txt");


    }

}
