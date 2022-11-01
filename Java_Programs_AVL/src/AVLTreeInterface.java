package avltree;

/**
  * <h1> AVL Tree Interface </h1>
  * <p> API for defining a concrete AVL Tree.</p>
  * @author Bonga Njamela [NJMLUN002]
  * @since 12-03-2022
  * @version 1.0
  */
  
public interface AVLTreeInterface<dataType extends Comparable<dataType>> {
    
    public int nodeHeight(BinaryTreeNode<dataType> node);
    
    public int subHeight(BinaryTreeNode<dataType> node);
    
    public void fixHeight(BinaryTreeNode<dataType> node);
    
    public int balanceFactor(BinaryTreeNode<dataType> node);
    
    public int getSize(BinaryTreeNode<dataType> node);
    
    public void insert(dataType d, BinaryTreeNode<dataType> node);
    
    public dataType find(dataType d, BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> node);
    
    public BinaryTreeNode<dataType> balance(BinaryTreeNode<dataType> node);
    
    public void traverse(String traversalType);
    
    public void visit(BinaryTreeNode<dataType> node);
    
    public void preOrder(BinaryTreeNode<dataType> node);
    
    public void inOrder(BinaryTreeNode<dataType> node);
    
    public void levelOrder(BinaryTreeNode<dataType> node);
    
    public void postOrder(BinaryTreeNode<dataType> node);
}
