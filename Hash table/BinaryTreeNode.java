/*
 *CSC 221 A: Project 4 Inventory Database
 * @author Zhehui Yuan
 * @version 0.1, April 19th, 2018
 * simple interface for binary trees .
 **/
public interface BinaryTreeNode <E > {

    /* *
     * Returns the data stored in this node .
     */
    E getData () ;
    /* *
     * Modifies the data stored in this node .
     * */
    void setData ( E data ) ;

    /* *
     * Returns the parent of node , or null if node is root .
     */
    BinaryTreeNode <E > getParent () ;

    /* *
     * Returns the left child of this node , or null if none
     */
    BinaryTreeNode <E > getLeft ();

    /* *
     * Returns the right child of this node , or null if none
     */
    BinaryTreeNode <E > getRight ();

    /* *
     * Removes child from its current parent and inserts it
     * as the left child of this node . If this node already
     * has a left child it is removed .
     *
     * @exception IllegalArgume nt Ex ce pti on if the child is
     * an ancestor ( that would make a cycle ).
     */
    void setLeft ( BinaryTreeNode <E > child );

    /* *
     * Removes child from its current parent and inserts it
     * at the right child of node , remove existing left child
     * @exception IllegalArgume nt Ex ce pti on if child ancestor
     */
    void setRight ( BinaryTreeNode <E > child );

    /* *
     * Removes this node and all its descendants from tree
     */
    void removeFromParent ();

    /* *
     * Visits the nodes in this tree in preorder .
     */
    void traversePreorder ( Visitor <E > visitor );

    /* *
     * Visits the nodes in this tree in postorder .
     */
    void traversePostorder ( Visitor <E > visitor );

    /* *
     * Visits the nodes in this tree in inorder .
     */
    void traverseInorder ( Visitor <E > visitor );

    /**
     *print method for the tree that contains the parameter
     */
    void big();
    /* *
     * Visitor pattern used by traversals to process
     */
    public interface Visitor <E >{
        void visit ( BinaryTreeNode <E > node );
    }
}