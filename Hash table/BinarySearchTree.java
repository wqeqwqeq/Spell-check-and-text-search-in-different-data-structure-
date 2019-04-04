import java . util . Comparator ;
/**
 *CSC 221 A: Project 4 Inventory Database
 * @author Zhehui Yuan
 * @version 0.1, April 19th, 2018
 */
/* *
 * A binary search tree class with insertion , removal and
 * * lookup . All tree items must be distinct according to the
 * comparator . If no comparator is supplied the " natural
 * order " of tree elements is used .
 */
public class BinarySearchTree <E >{
    /* *
     * Root of the tree .
     */
    protected BinaryTreeNode <E > root = null ;

    /* *
     * Comparator used to order the items in the tree .
     */
    private Comparator <E > comparator ;
    /* *
     * Constructs an empty BST that can only accept
     * Comparables as items .
     */
    public BinarySearchTree () {
        this ( null );
    }
    /* *
    @param compactor c
    * Constructs a BST that orders its items according
    * * to the given comparator .
    */
    public BinarySearchTree ( Comparator <E > c ){
        comparator = c ;
    }

    /* *
     @param data
     * Returns whether or not the tree contains an object
     * with the given value .
     */
    public boolean contains ( E data ){
        return nodeContaining ( data ) != null ;
    }

    /* *
     @param data
     * Adds a single data item to the tree , can overwrite
     */
    public void add ( E data ) {
        if ( root == null )
            root = new LinkedBinaryTreeNode <E >( data );
        BinaryTreeNode <E > n = root ;
        while ( true ){
            int comparisonResult = compare ( data , n. getData ());
            if( comparisonResult == 0){ // if match , overwrite
                n . setData ( data );
                return ;
            }
            else if( comparisonResult < 0){
                if( n . getLeft () == null ){
                    n . setLeft ( new LinkedBinaryTreeNode <E >( data ));
                    return ;
                }
                n = n . getLeft ();
            } else { // comparisonResult > 0
                if( n . getRight () == null ){
                    n . setRight ( new LinkedBinaryTreeNode <E >( data ));
                    return ;
                }
                n = n . getRight ();
            }
        }
    }
    /*
    @param data
    * remove method, remove the data from the tree
    */
    public void remove (E data ){
        // find the node containing the data
        BinaryTreeNode <E > node = nodeContaining ( data );
        if( node == null ) // No such object , do nothing
            return ;
        else if( node . getLeft ()!= null && node . getRight ()!= null ){
            // Node has two children , we cannot delete it . Copy
            // predecessor data and prepare to delete predecessor
            BinaryTreeNode <E > predecessor = predecessor ( node );
            node . setData ( predecessor . getData ());
            node = predecessor ; // now predecessor will be deleted
        }
        // At this point node has zero or one child
        BinaryTreeNode <E > pullUp =
                ( node . getLeft () == null )? node . getRight (): node . getLeft ();
        // if node is the root
        if( node == root )
            setRoot ( pullUp );
            // if node is the left child of parent
        else if( node . getParent (). getLeft () == node )
            node . getParent (). setLeft ( pullUp );
            // otherwise node is the right child of parent
        else
            node . getParent (). setRight ( pullUp );
    }

    /* *
     * Returns the root of the tree
     *
     * */
    protected BinaryTreeNode getRoot (){ return root ; }

    /* *
    @param BinaryTreeNode node
    * Makes the given node the new root of the tree .
    */
    protected void setRoot ( BinaryTreeNode <E > node ){
        if ( node != null ) node . removeFromParent ();
        root = node ;
    }

    /* *
     * @param BinaryTreeNode node
     * @return BinaryTreeNode n
     * Returns the rightmost node in the left subtree .
     */

    protected BinaryTreeNode <E > predecessor (BinaryTreeNode <E > node ){
        BinaryTreeNode <E > n = node . getLeft ();
        if( n != null )
            while ( n. getRight () != null )
                n = n . getRight ();
        return n ;
    }

/* *
@param data
@return BinaryTreeNode n
* Helper method that returns node containing data
* * This is used in both contains and remove .
 */

    protected BinaryTreeNode <E > nodeContaining ( E data ){
        for ( BinaryTreeNode <E > n = root ; n != null ;){
            int comparisonResult = compare ( data , n . getData ());
            if( comparisonResult == 0)
                return n ;
            else if( comparisonResult < 0)
                n = n . getLeft ();
            else
                n = n . getRight ();
        }
        return null ;
    }

    /* *
     * Put comparison code in one place ( it ’s a better design )
     */
    protected int compare ( E x , E y ){
        if ( comparator == null )
            return (( Comparable <E >) x ). compareTo ( y );
        else
            return comparator . compare (x , y );
    }
    /* *
    @param BinaryTreeNode n
     * Rotates left around the given node .
    */
    protected void rotateLeft ( BinaryTreeNode <E > n ) {
        // need a right child ( R ) to rotate left ...
        if ( n . getRight () == null ) return ;

        BinaryTreeNode <E > oldRight = n . getRight ();

        // set right child of n ( pivot ) to left child of R
        n. setRight ( oldRight . getLeft ());

        // determine if rotated around BST root ( or not )
        if( n . getParent () == null )
            root = oldRight ;
        else if( n . getParent (). getLeft () == n )
            n . getParent (). setLeft ( oldRight );
        else
            n . getParent (). setRight ( oldRight );

        // set left child of R to n ( the pivot )
        oldRight . setLeft (n );
    }
    /* *
@param BinaryTreeNode n
 * Rotates right around the given node .
*/
    protected void rotateRight ( BinaryTreeNode <E > n ) {

        if ( n . getLeft () == null ) return ;

        BinaryTreeNode <E > oldLeft = n . getLeft ();


        n. setLeft ( oldLeft . getRight ());


        if( n . getParent () == null )
            root = oldLeft ;
        else if( n . getParent (). getRight () == n )
            n . getParent (). setRight ( oldLeft );
        else
            n . getParent (). setLeft( oldLeft );


        oldLeft . setRight (n );
    }

    /*
     * @param BinaryTreeNode aNode
     * @return int hight
     * return the hight of the tree of the given node
     */
    public int getHeight(BinaryTreeNode<E> aNode) {
        if (aNode == null) {
            return -1;
        }
        int lefth=0;
        int righth=0;
        if (aNode.getLeft()==null&&aNode.getRight()==null){return 0;}
        if (aNode.getLeft()!=null)
        {  lefth = getHeight(aNode.getLeft());}
        if (aNode.getRight()!=null){
            righth = getHeight(aNode.getRight());}


        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }
    /*
    recursively call the big method
     */
    public void big(){
        root.big();
    }
    /*
    @return size of the tree
    @param BinaryTreeNode wqreq
    return the size of the tree
     */
    public int size(BinaryTreeNode wqeq){
        if (wqeq==null)return 0;
        else return (size(wqeq.getLeft()) + 1 + size(wqeq.getRight()));
    }
    /*
    recursively call the size method
     */
    public int size(){
        return size(root);
    }


} // end of BinarySearchTree


