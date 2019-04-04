/*
 * Create a Word count link list class to implement the double link list
 * Store the scan String from dictionary file and txt file
 * Method include AddLast, contain, size, isEmpty, toString,
 * inner class include Node class and iterator class
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class WCLinkedList implements Iterable<String>  {

   /*
   This is an inner class that build Node
   the constructor will built for previous and next and store String
   The pointer and data will be declared protected
    */

    public class Node {
        // data declaration
        protected WordCount WC;// Word count object that will get access the private String and count by getter
        protected Node previous;
       protected   Node next;

        // constructor

        public Node(Node previous,String data, Node next ){
             WC=new WordCount(data);

            this . next = next ;
            this . previous = previous ;
        }


    }
    // initiate the node and size
    // declare some variable

    protected Node head;
    protected Node tail;
    protected int size;

    // initialize an empty list
    public WCLinkedList(){
        head=null;
        tail=null;

    }



    // check if it is empty or not

    public boolean IsEmpty(){
        if (head==null){return false;}
        else return true;
    }

    /* *
     * This method check if the data is in the list
     * String parameters .
     * @param String data
     * @return true or false
     */
    public boolean contain (String dada) {
        Node current = head;
        if(head==null){return false;}
        while (current != null) {
            if (dada.equals(current.WC.getString())) {
                //transpose (current)
                current.WC.countonce();
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /*
    This method will add data at the end of the List
    @param String data
    @void method does not return
     */
    public int size(){return size;}
    public void addLast (String data){

        // insert head

        if (head==null){
            head=new Node(null,data,null);


        }
       else
           // insert tail
        { tail= head;
        while (tail.next!=null){
            tail=tail.next;
        }
        Node current=new Node(tail,data,null);
        tail.next=current;
        }

    // increment the size of the list
    size++;

    }
    /*
    This is a toString method that will print result as String and count
    @ param no parameter
    @it will return the result as string contain both count and String data
     */
    public String toString() {
        String result = "";
        Node current = head;
        while(current.next != null){
            current = current.next;
            result += current.WC.getString() + " "+current.WC.getCount();
        }
        return  result;
    }

    public boolean findMove(String e){
        Node previous=head;
        Node current=head;
        while(current !=null){
            if(e.equals(current.WC.getString())){
                //Found the item
                previous.next=current.next;
                current.next=head;
                head=current;
                System.out.println("True");
                return true;
            }
            previous = current;
            current=current.next;
        }
        System.out.println("False");
        return false;
    }






    // DlistIterator class
    /*
    This is a iterator class and implement iterator interface
    This class will used for traverse
    The method include hasNext, Next
     */
    private class DListIterator implements Iterator < String > {
        private Node nextNode = head ;

        @Override
        public boolean hasNext () { return nextNode != null ; }
    /*
    Check if the string has next
     */
        @Override
        public String next () {
            if (! hasNext () )
                throw new NoSuchElementException("Iterator֒→ exceeded");
            String data = nextNode .WC.toString()  ;
            nextNode = nextNode . next ;
            return data ;// return data
        }
    }
    /*
    This constructor will build an iter
     */
    public Iterator iterator () {
        return new DListIterator ();
    }
}
