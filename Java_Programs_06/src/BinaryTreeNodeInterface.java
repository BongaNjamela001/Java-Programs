package binarysearchtree;
import java.io.*;

/**
  *<h1>Binary Tree Node Interface!</p>
  *<p>Interface for defining a concrete binary tree node. Initially intended for use in 
  * the Vaccine Binary Search Tree Application for CSC2 </p>
  * @since 22/02/22
  * @author Bonga Njamela NJMLUN002
  * @version 1.0  
  */

public interface BinaryTreeNodeInterface<dataType extends Comparable<dataType>> {
    /**
      * Returns the data in the Binary Tree Node of generic type dataType.
      */ 
    dataType getData();
    
    /**
      * Defines the data to be stored in the binary tree node.
      * @param data The data to be stored by the node.
      */
    void setData(dataType data);
    
    /**
      * Returns the Binary Tree Node's right child.
      * @return BinaryTreeNode This returns the right child of the Binary Tree Node.
      */
    BinaryTreeNode<dataType> getRightChild();
    
    /**
      * Defines the right child of the current Binary Tree Node object.
      * @param node This is the right child of the Binary Tree Node.
      */
    void setRightChild(BinaryTreeNode<dataType> node);
    
    /**
      * Returns the data in the Binary Tree Node of generic type dataType.
      * @return BinaryTreeNode This the left child of the Binary Tree Node. 
      */
    BinaryTreeNode<dataType> getLeftChild();
    
    /**
      * Define the left child of the current Binary Tree Node object.
      * @param node This is the left child of the Binary Tree Node.
      */
    void setLeftChild(BinaryTreeNode<dataType> node);
    
    /**
      * Returns the integer height of the Binary Tree at the current node.
      * @return int This returns the height of the tree at this Binary Tree Node
      */
    int getHeight();
    
    /**
      * Stores the height of the Binary Tree at this node.
      * @param height This is the height of the Binary Tree at this node. 
      */
    void setHeight(int height);
    
    /**
      * Returns the integer key value of the Binary Tree Node which is used to uniquely identify the node.
      * @return This is the key of the Binary Tree Node.
      */
    int getKey();
    
    /**
      * Returns the data in the Binary Tree Node of generic type dataType.
      * @param key This is the key of the Binary Tree Node.
      */
    void setKey(int key);
    
    /**
      * Returns an integer value of -1, 0, 1 or 2 depending on the result of using Comparable's 
      * to compare the data in the Binary Tree Nodes being compared.
      * @param node This is the Binary Tree Node to be compared to this Binary Tree Node
      * @return int This is the value which indicates whether the Binary Tree Node data in b1 is equal to,
      * greater than or less than the data in Binary Tree Node b2.
      */
    int compareTo(BinaryTreeNode<dataType> node);
    
    /**
      * This returns a boolean to determine whether the Binary Tree Node has data or not.
      * @return boolean Returns true if the Binary Tree Node is not storing any data or false if the Binary Tree * Node contains data.
      * @param node The Binary Tree Node to be checked for nullity.
      */
    boolean isEmpty(BinaryTreeNode<dataType> node);
    
    /**
      * Attempts to update the data stored by the current Binary Tree Node otherwise returns the original
      * Binary Tree Node
      * @return BinaryTreeNode This is the Binary Tree Node with updated data or the same data.
      * @param d This is the new data to be stored in the old node.
      * @param oldNode This is the original Binary Tree Node to be updated
      */
    BinaryTreeNode<dataType> update(dataType d, BinaryTreeNode<dataType> oldNode);
}
