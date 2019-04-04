/*
This class creates a hash table as a primitive type based on the AVLTree
Method include add, contain, getSize, and toArray

 * @author Zhehui Yuan
 * @version 0.2, Apr. 28, 2018
 */

public class AVLHashSet<E>{

    //build a hashtable based on AVLTree, for each cell , store a tree.
   AVLTree <E>[] hashest ;


    /*
    null constructor initialize the size of the table as 11
     */
    public AVLHashSet() {
        hashest=new AVLTree[11];

    }
    /*
    @param initialCapacity
    constructor passed an integer to the constructor
    check if the number is not positive and throw exception
    design size of the table
     */
    public AVLHashSet(int initialCapacity) {
        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
       else hashest=new AVLTree[initialCapacity];

    }

    /*
    @param data
    @return true if add successfully
    add method adds data to the tree
     */
    public boolean add(E data){
        int index1=data.hashCode();
        int index=Math.abs(index1);
        if (hashest[index%hashest.length]==null){
            hashest[index%hashest.length]=new AVLTree<E>();}
            if (hashest[index%hashest.length].contains(data))return false;
        hashest[index%hashest.length].add(data);

        return true;


    }

    /*
    @param data
    contain method check if the data is contained in the AVLtree
    return true if data is contained, otherwise false
     */
    public boolean contains(E data) {
    int index1=data.hashCode();
    int index=Math.abs(index1);

    if (hashest[index%hashest.length]==null)return false;
    if (hashest[index%hashest.length].contains(data)){return true;}

    else return false;
    }

    /*
    get the number of data stored in the hash table
    @return the size of the data
     */
    public int getSize(){
    int size=0;

    for (int i=0; i<hashest.length;i++){
        if (hashest[i%hashest.length]!=null)
       size=size+hashest[i].size();
    }
    return size;

    }

    /*
    @param list
    convert the AVL tree stored in the hash table to array
    @return a list
    create a visitor object to traverse the whole table
     */

    public E[] toArray(E[] list){
        PrintNode <E> a =new PrintNode<>(list);
        for (int i=0;i<hashest.length;i++){
            if (hashest[i%hashest.length]!=null)
            hashest[i].getRoot().traversePreorder(a);

        }
        return list;
    }
}
