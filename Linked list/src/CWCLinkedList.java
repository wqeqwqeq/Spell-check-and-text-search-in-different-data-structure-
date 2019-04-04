   /*
    * This class is a count list class
    * this class is extended from WCLinkedlist class
    * This class will transpose the data with its predecessor if called more often
    */
public class CWCLinkedList extends WCLinkedList {
    /*
      This method will check if the list contains the data
      if contained, the count will be added
      and then call swap method
      @param String data
      @return a boolean value to check if the data contains
     */
    @Override
    public boolean contain(String data){
        Node current = head;// declare a new node point to head
        if(head==null){return false;}
        while (current != null) {
            if (data.equals(current.WC.getString())) {
               current.WC.countonce();
               swap(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /*
       This method will swap value of two nodes if the count number is greater that its
       predecessor
       @ Param Node e
        This method will pass a Node to the code to do the swap
       @ return nothing, void method
     */
    public void swap(Node e){
       Node prev=e.previous; //declare a node and point to the previous of parameter node
        if (e.previous!=null){
        if (e.WC.getCount()>prev.WC.getCount()){
            WordCount temp=prev.WC;
            prev.WC=e.WC;
            e.WC=temp;

        }}

    }

    public boolean max(int number ){return  true;}// for love

    public void ahead(Node love){
        love.next=head;
        head.previous=love;
        love.previous=null;
        head=love;

    }
}

