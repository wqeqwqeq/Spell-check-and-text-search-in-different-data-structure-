import java.io.*;
import java.util.Scanner;
/**
 *CSC 221 A: Project 4 Inventory Database
 * @author Zhehui Yuan
 * @version 0.1, April 19th, 2018
 */
public class Inventory {
    public static void main(String[] args) throws Exception{
        //open files
        FileReader fr=new FileReader(args[0]);
        // create  a binary search tree, called BST, contained BST object
        BinarySearchTree BST= new BinarySearchTree();
        // create  a AVL tree, called AVL, contained AVL object
        AVLTree AVL=new AVLTree();
        //create a scanner, called scanner, contain scanner object
        Scanner scanner=new Scanner(fr);
        //create an arraylist, called temp, to store the command and data to the specified tree
        String []temp;
        // create counter for update, initialized to -1
        int upup=0;
        // create a while loop, based on the command, add or remove data from specified tree.
        while (scanner.hasNextLine()){
            //divide the whole string by half, first part is command, second part is data, separated by blank space
            temp=scanner.nextLine().split(" ");
            if(temp[0].toUpperCase().equals("A")){
                // Add to bst or avl
                if (!BST.contains(temp[1])){upup++;}
                BST.add(temp[1]);

                AVL.add(temp[1]);


            }
            if(temp[0].toUpperCase().equals("D")){
               // remove from bst or avl
                if (BST.contains(temp[1])){upup++;}
                BST.remove(temp[1]);
                AVL.remove(temp[1]);

            }
            // increment the counter by 1

        }
        // print the information
        System.out.println("Number of inventory updates: "+upup);
        System.out.println();

        System.out.println("BST tree size: "+BST.size()+", "+"height: "+BST.getHeight(BST.getRoot()));
       // print the BST tree
        BST.big();
        System.out.println();
        System.out.println();
        System.out.println("AVL tree size: "+AVL.size()+", "+"height: "+AVL.getHeight(AVL.getRoot()));
        // print the avl tree
       AVL.big();
       }
}
