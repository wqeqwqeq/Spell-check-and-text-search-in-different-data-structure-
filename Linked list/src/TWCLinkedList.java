/*
 This class will transpose the data if the text element is called from the text.
 The method include contain and transpose
  this class is extended from WCLinkedlist class
 */
public class TWCLinkedList extends WCLinkedList {
    /*
 * This method will check if the list contains the data
  *if contained, the count will be added
  *and then call swap method
  *@param String data
  *@return a boolean value to check if the data contains
 */
    @Override
    public boolean contain(String data){

        Node current = head;
        if(head==null){return false;}
        while (current != null) {
            if (data.equals(current.WC.getString())) {
                current.WC.countonce();
                Transpose(current);
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
    public void Transpose(Node e){
        Node prev=e.previous;

        if (e.previous!=null){

           String temp=prev.WC.getString();
           prev.WC.setString(e.WC.getString());
           e.WC.setString(temp);
            int count=prev.WC.getCount();
            prev.WC.setCount(e.WC.getCount());
            e.WC.setCount(count);
        }


    }
}
