package binarysearchtree;

/**
  * <h1> Binary Search Tree Interface </h1>
  * <p> For use in defining a concrete Binary Search Tree </p>
  * @author Bonga Njamela
  * @since 22/02/22
  * @version 1.0
  */

public interface BinarySearchTreeInterface<dataType extends Comparable<dataType>> {
    int getHeight(BinaryTreeNode<dataType> node);
    
    int getSize(BinaryTreeNode<dataType> node);
    

    void insert(dataType d, BinaryTreeNode<dataType> node);
    
    
    dataType find(dataType d, BinaryTreeNode<dataType> node);
    
    BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node);
    
    BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node);
    
    BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node);
    
    void traverse(String traversalType);    
    
    void visit(BinaryTreeNode<dataType> node);
    
    void preOrder(BinaryTreeNode<dataType> node);
    
    void inOrder(BinaryTreeNode<dataType> node);
    
    void levelOrder(BinaryTreeNode<dataType> node);
    
    void postOrder(BinaryTreeNode<dataType> node);
}
