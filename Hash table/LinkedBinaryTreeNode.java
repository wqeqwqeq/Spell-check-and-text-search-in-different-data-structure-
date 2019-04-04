/**
 *CSC 221 A: Project 4 Inventory Database
 * @author Zhehui Yuan
 * @version 0.1, April 19th, 2018
 */
/* *
 * A simple class for binary tree nodes .
 *
 * ACHTUNG ! LinkedBinaryTreeN ode objects may not play well
 * with others : if one tries to mix them up with different
 * types of binary tree nodes , exception may be thrown . </ p >
 *  * @author Zhehui Yuan
 * @version 0.2, Apr. 28, 2018
 */
public class LinkedBinaryTreeNode <E > implements BinaryTreeNode <E >{
    protected E data ;
    protected LinkedBinaryTreeNode <E > parent ;
    protected LinkedBinaryTreeNode <E > left ;
    protected LinkedBinaryTreeNode <E > right ;
    protected int size;
    /* *
     * Constructs a node as root of its own one - element tree .
     */
    public LinkedBinaryTreeNode ( E data ) {
        this . data = data ;
    }

    /* *
     * Returns the data stored in this node .
     */
    public E getData (){ return data ; }

    /* *
     * Modifies the data stored in this node .
     */
    public void setData ( E data ){ this . data = data ; }

    /* *
     * Returns the parent of this node , or null if root .
     */
    public BinaryTreeNode <E > getParent (){ return parent ; }

    /* *
     * Returns the left child of this node , or null if none .
     */
    public BinaryTreeNode <E > getLeft (){ return left ; }

    /* *
     * Returns the right child of this node , or null if none .
     */
    public BinaryTreeNode <E > getRight (){ return right ; }

    /* *
     * Removes child from its current parent and inserts it
     * as the left child of this node . If this node already
     * has a left child then it is removed .
     * @exception IllegalArgume nt Exception if the child is
     * an ancestor of this node
     */
    public void setLeft ( BinaryTreeNode <E > child ){
        // Ensure the child is not an ancestor .
        for ( LinkedBinaryTreeNode <E > n = this ; n != null ;
              n = n . parent ){
            if( n == child )
                throw new IllegalArgumentException ();
        }
        // Ensure child is instance of LinkedBinaryTre eNo de .
        LinkedBinaryTreeNode <E > childNode =
                ( LinkedBinaryTreeNode <E >) child ;
        // Break old links , then reconnect properly .
        if( this . left != null )
            left . parent = null ;
        if( childNode != null ){
            childNode . removeFromParent ();
            childNode . parent = this ;
        }
        this . left = childNode ;
    }
    /* *
     *@param BinaryTreeNode child
     * Removes child from its current parent and inserts it
     * as the right child of this node . If this node already
     * has a right child then it is removed .
     * @exception IllegalArgume nt Exception if the child is
     * an ancestor of this node
     */
    @Override
    public void setRight(BinaryTreeNode<E> child) {
        for ( LinkedBinaryTreeNode <E > n = this ; n != null ;
              n = n . parent ){
            if( n == child )
                throw new IllegalArgumentException ();
        }
        // Ensure child is instance of LinkedBinaryTre eNo de .
        LinkedBinaryTreeNode <E > childNode = ( LinkedBinaryTreeNode <E >) child ;
        // Break old links , then reconnect properly .
        if( this . right != null )
            right . parent = null ;
        if( childNode != null ){
            childNode . removeFromParent ();
            childNode . parent = this ;
        }
        this . right= childNode ;
    }


    /* *
     * Removes this node , and all its descendants , from
     * whatever tree it ’s in . Nothing if node is a root .
     */
    public void removeFromParent (){
        if( parent != null ){
            if( parent . left == this )
                parent . left = null ;
            else if( parent . right == this )
                parent . right = null ;
            this . parent = null ;
        }
    }
    /* *
     * Visits the nodes in this tree in preorder .
     * @param visitor
     */
    public void traversePreorder ( BinaryTreeNode . Visitor <E > visitor ){
        visitor . visit ( this );
        if( left != null ) left . traversePreorder ( visitor );
        if( right != null ) right . traversePreorder ( visitor );
    }

    /* *
     *@param visitor
     * Visits the nodes in this tree in postorder .
     */
    public void traversePostorder ( BinaryTreeNode . Visitor <E > visitor ){
        if( left != null ) left . traversePostorder ( visitor );
        if( right != null ) right . traversePostorder ( visitor );
        visitor . visit ( this );
    }


    /* *
     * Visits the nodes in this tree in inorder .
     */
    public void traverseInorder ( BinaryTreeNode . Visitor <E > visitor ){
        if( left != null ) left . traverseInorder ( visitor );
        visitor . visit ( this );
        if( right != null ) right . traverseInorder ( visitor );
    }

    public void sizePrint (int haha){
        if (right!=null){
            right.sizePrint(haha+4);
        }
        for (int i=0;i<haha;i++)
            System.out.print("-");
        System.out.println(data);
        if (left!=null){left.sizePrint(haha+4);}
    }

    /*
     * print method that print the tree to a piece of tree to string
     */
    public void big(){
        System.out.print("(");
        if (left!=null){
            left.big();
        }
        System.out.print(data);

        if (right!=null){
            right.big();
        }

        System.out.print(")");
    }

    @Override
    public String toString (){

        return data . toString ();
    }
}