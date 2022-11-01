package binarysearchtree;
import java.io.*;
import java.util.*;

/**
  * <h1> Binary Tree Node </h1>
  * <p> BinaryTreeNode class creates a Binary Tree Node object which holds generic data,  a left child and a right child </p>
  * @author Bonga Njamela
  * @since 22/02/22
  * @version 1.0
  */

public class BinaryTreeNode<dataType extends Comparable<dataType>> implements BinaryTreeNodeInterface<dataType>
{
    dataType data;
    BinaryTreeNode<dataType> leftChild;
    BinaryTreeNode<dataType> rightChild;
    BinaryTreeNode<dataType> link;//for use in queues 
    int height; //tree height at this node
    int key;
    
    /**
      * Empty constructor method for creating node with no data and null children 
      */ 
    public BinaryTreeNode(dataType d) {
        this.data = d;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 0;
        this.key = 0;    
    }
    
    /**
      * Constructor method for explicit definition of node
      * @param d dataType
      * @param l left child
      * @param r right child
      * @param nodeKey key 
      * @param height tree height at node
      */
    public BinaryTreeNode(dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r, int nodeKey, int height) {
        this.data = d;
        this.leftChild = l;
        this.rightChild = r;
        this.key = nodeKey;
        this.height = height;
    }
    
    public BinaryTreeNode(dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r) {
        this.data = d;
        this.leftChild = l;
        this.rightChild = r;
        this.key = 0;
        this.height = 0;
    }
    /**
      * Copy constructor for BinaryTreeNode
      */
    public BinaryTreeNode(BinaryTreeNode<dataType> node) {
         this.data = node.getData();
         this.leftChild = node.getLeftChild();
         this.rightChild = node.getRightChild();
         this.height = node.getHeight();
         this.key = node.getKey();      
    }
    
    /** Returns data stored in node.
     * @return dataType This returns data stored in this node 
     */    
    public dataType getData() {
        return this.data;  
    }
    
    public BinaryTreeNode<dataType> getLink() {
        return this.link;  
    }
    
    public void setLink(BinaryTreeNode<dataType> node) {
        this.link = node;
    }
    
    /**
     * Imputes node data.
     */
    public void setData(dataType d) {
         this.data = d;
    }
    
    /** Returns left child.
     * @return BinaryTreeNode This returns the left child of this node. 
     */
    public BinaryTreeNode<dataType> getLeftChild() {
        return this.leftChild;
    }
    
    /**
      * Add the left child of the current node.
      * @param lefty This is the right child of the node
      */
    public void setLeftChild(BinaryTreeNode<dataType> lefty) {
        this.leftChild = lefty;
    }
    
    /** Returns right child.
     * @return BinaryTreeNode This returns the right child of this node. 
     */
    public BinaryTreeNode<dataType> getRightChild() {
        return this.rightChild;
    }
    
    /**
      * Add the right child of the current node.
      * @param righty This is the right child of the node
      */
    public void setRightChild(BinaryTreeNode<dataType> righty) {
        this.rightChild = righty;
    }
    
    /** <p> Returns height of the tree at this node. If height is zero, then node is root </p>
     * @return int This returns the height of the tree at the current node. 
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
      * Set the height of the binary tree at this node. If node is root, then the height is zero.
      * @param h This is the height of the binary tree at this node
      */
    public void setHeight(int h) {
        this.height = h;
    }
    
    /** Returns the key of the node
     * @return int This is the key of the node 
     */
    public int getKey() {
        return this.key;
    }
    
    /**
      * Define the key of this node
      * @param k The key integer value of this node
      */
    public void setKey(int k) {
        this.key = k;
    }
    
    /**
      * Verify whether the data in a node exists or not. 
      * @return boolean This is true if data is null; otherwise returns
      * false.
      */
    public boolean isEmpty(BinaryTreeNode<dataType> node) {
        return (node.data == (dataType) null);
    }
    
    /**
      * Changes the data item d stored in the node n.
      * @return BinaryTreeNode This is the updated node or the same node if node change was made.
      */
    public BinaryTreeNode<dataType> update(dataType d, BinaryTreeNode<dataType> oldNode) {
       
       BinaryTreeNode<dataType> node = new BinaryTreeNode<dataType>(data);
       
       if (isEmpty(oldNode) && (d != null))
          return new BinaryTreeNode<dataType>(d);
       else if (node.compareTo(oldNode) == 0) {
          node.data = d;
          return node;
       }
       return oldNode;
    }
    
    /**
      * Compares the values of two nodes.
      * @return int <p> Returns -1 if the otherNode data value is greater than the 
      * instance node. Returns 1 if the value of the otherNode data is greater than the value of the instance  
      * data. Returns 0 if the data is equal. Otherwise, returns 2 if the otherNode is null. </p>
      */
    public int compareTo(BinaryTreeNode<dataType> otherNode) {
    
       if (otherNode == null)
         return 0;
       else if (data.compareTo(otherNode.getData()) < 0)
         return -1;
       else if (data.compareTo(otherNode.getData()) > 0)
         return 1;
         
       return 0;         
    }
    
    public String toString() {
        if (data != null)
            return data.toString();
        return "";
    }
}
