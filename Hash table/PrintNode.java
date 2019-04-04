
   /*This class creates a visitor to traverse the Hash table
   * @author Zhehui Yuan
   * @version 0.2, Apr. 28, 2018
   */
   public class PrintNode <E > implements BinaryTreeNode . Visitor <E >{
    private E[]L;
    private int wqe=0;

    /*
    @param list
    constructor assign list to L
     */
    public PrintNode (E[]list){
        L=list;
    }
    /*
    @param BinaryTreeNode node
    This method get the data of the list and increment the size
     */
    public void visit ( BinaryTreeNode <E > node ) {
        // relying on the node ’s toString ()
        L[wqe] = node.getData();
        wqe++;

    }
}