import java . util . Comparator ;
/**
 *CSC 221 A: Project 4 Inventory Database
 * @author Zhehui Yuan
 * @version 0.1, April 19th, 2018
 */
/* *
* A simple AVL tree class .
*/
         public class AVLTree <E > extends BinarySearchTree <E >{

/* *
* Constructs an empty AVL that only accepts Comparables .
*/
        public AVLTree () {
         this ( null ) ;
         }

/* *
* Constructs an AVL that orders its items according
* to the given comparator .
*/
        public AVLTree ( Comparator <E > c ){
         super ( c ) ;
         }

 /* *
* Adds a single data item to the AVL tree , can overwrite
*/
                  @Override
public void add ( E data ){
          // let ’s go ahead and add the new node , thanks BST
          super . add ( data );
          // find the new node containing the data
          BinaryTreeNode <E > n = nodeContaining ( data );
          // if there is a new node , then rebalance
          if( n != null ) rebalance ( n );
          }
/**
 *
* Removes a data item from the AVL tree
* @param data
*/
 @Override
 public void remove ( E data ){
         // find the node containing the data
          BinaryTreeNode <E > n = nodeContaining ( data );

          if( n != null ){
              // code here to determine the node n where the
              // rebalance should start ( done before removal )

              // let ’s remove node containing the data
              super . remove ( data );
              // Rebalance starting at n
              rebalance ( n );
              }
          }
 /*
 *@param BinaryTreeNode node
 * This method will rebalance the AVL tree after we do the add and remove
  */

     protected void rebalance ( BinaryTreeNode <E > node ){
         // let ’s check every node until we reach root
          while ( node != null ){
             int heightDiff = getHeight ( node . getLeft ()) -
                     getHeight ( node . getRight ());
             if( heightDiff == 2){ // left rebalance
                 heightDiff = getHeight ( node . getLeft (). getLeft ())
                  - getHeight ( node . getLeft (). getRight ());
                  if( heightDiff > 0) // left - left
                      rotateRight ( node );
                  else { // left - right
                     rotateLeft ( node . getLeft ());
                      rotateRight ( node );
                      }
                  }
              else if( heightDiff == -2){ // right rebalance
                  heightDiff = getHeight ( node . getRight (). getLeft ())
                  - getHeight ( node . getRight (). getRight ());
                  // magic right - right or right - left rotate code
                 if (heightDiff<0){
                     rotateLeft(node);
                 }else {
                     rotateRight(node.getRight());
                     rotateLeft(node);
                 }
                  }
              node = node . getParent ();
              }
          }
}

