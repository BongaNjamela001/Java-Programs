package binarysearchtree;
import models.CountryRegister;
/** <h1> Binary Search Tree </h1>
  * <p> The Binary Search Tree data structure which implements the Binary Search Tree Interface for 
  * concreteness. 
  * </p>
  * @author Bonga Njamela
  * @since 22-02-22
  * @version 1.0
  */

public class BinarySearchTree<dataType extends Comparable<dataType>> implements BinarySearchTreeInterface<dataType>
{
    BinaryTreeNode<dataType> root;
    public static int opCount;
    
    /**
      * Binary Search Tree explicit constructor.
      * @param rootNode The tree's root node
      */
    public BinarySearchTree(BinaryTreeNode<dataType> rootNode) {
        this.root = rootNode;
        opCount = 0;
    }
    
    /**
      * Empty Binary Search Tree constructor
      */
    public BinarySearchTree() {
        this.root = null;
        opCount = 0;
    }
    
    /**
      * Auxiliary method for adding new node to a Binary Search Tree using recursion.
      * @param d Data of the new node to be inserted into the tree.
      * @see insert(dataType d, BinaryTreeNode<dataType> node)
      */
    public void insert(dataType d) {
        if (root == (BinaryTreeNode)null) {
            root = new BinaryTreeNode<dataType>(d, null, null);
        }
        else {
            insert(d, root);
        }
    }
    
    /**
      * <p> Adds a new node to the Binary Search Tree. If the root is null, then the new node becomes the 
      * entire tree. if the root is not null, then compare the key(s) of existing node(s) to the new node. 
      * If the value of the key of the new node is less than the key of the old node, add the new node
      * as the left child. Otherwise if the key is greater, add the node as the right child.
      * </p>
      * @param d This is the data of the new node to be added
      * @param node The node to be compared to 
      */
    public void insert(dataType d, BinaryTreeNode<dataType> node) {
        
        if (d.compareTo(node.getData()) <= 0) {
            if (node.getLeftChild() == (BinaryTreeNode) null) {
                node.setLeftChild(new BinaryTreeNode<dataType>(d, null, null));//add as left child
                opCount++;
            }
            else {
                insert(d, node.getLeftChild());
            }
        }
        else {
            if (node.getRightChild() == (BinaryTreeNode) null) {
                opCount++;
                node.setRightChild(new BinaryTreeNode<dataType>(d, null, null));//add as right child
            }
            else {
                insert(d, node.getRightChild());
            }
        }
    }

//     public void insert(dataType d) {
//         
//         BinaryTreeNode<dataType> toInsert = new BinaryTreeNode<dataType>(d, null, null);
//         BinaryTreeNode<dataType> currentNode = root;
//         BinaryTreeNode<dataType> parent = null; //link to previous node
//         
//         if (root == null) {
//             root = toInsert;
//             return;
//         }
//         while(currentNode != null) {
//             parent = currentNode;
//             int cmp = d.compareTo(currentNode.getData());
//             
//             if (cmp < 0) {
//                 currentNode = currentNode.getLeftChild();
//             }
//             else if (cmp > 0) {
//                 currentNode = currentNode.getRightChild();
//             }
//             else {
//                 currentNode.setData(d);
//                 return;
//             }
//         }
//         
//         int cmp = d.compareTo(parent.getData());
//         if (cmp < 0) {
//             parent.setLeftChild(toInsert);
//         }
//         else {
//             parent.setRightChild(toInsert);
//         }
//     }
    
    /** 
      * Auxiliary method for searching for a node in a Binary Search Tree using recursion.
      * @param d Data contained in tree node
      * @see find(dataType d, BinaryTreeNode<dataType> node)
      * @return BinaryTreeNode - Resulting node from performing search algorithm
      */
    public dataType find(dataType d) {
        if (root == null) {
            return (dataType) null;
        }
        else {
            return find(d, root);
        }
    }
    
    /**
      * <p> Find algorithm used to search for data stored in the tree. Start searching at the root and check 
      * whether tree is empty. If the search node is equal to the root then return the root. If the search node
      * is less than the root, recursively search the left-hand subtree. Likewise, if the search node is 
      * greater than the root, search the right-hand subtree recursively. Return the node if found, otherwise 
      * return a null node.
      * </p>
      * @param d Data expected to be found in the tree.
      * @param node The search node
      * @return BinaryTreeNode - Result from searching tree. If found, returns node containing data, otherwise 
      * returns null node.
      */
    public dataType find(dataType d, BinaryTreeNode<dataType> node) {
        int comparison = d.compareTo(node.getData());
        
        if (comparison == 0) {
            System.out.println("Not found");
            return node.getData();
        }
        else if (comparison < 0) {
            opCount++;
            return (node.getLeftChild() == (BinaryTreeNode) null) ? null: find(d, node.getLeftChild());
        }
        else if (comparison == 3) {
            opCount++;
            return node.getData();
        }
        else {
            opCount++;
            return (node.getRightChild() == (BinaryTreeNode) null) ? null: find(d, node.getRightChild());
        }
    }
    
    /** 
      * Auxiliary method for deleting a node from the Binary Search Tree using recursion.
      * @param d Data contained in tree node
      * @see delete(dataType,BinaryTreeNode)
      */
    public void delete(dataType d) {
        root = delete(d, root);
    }
    
    /**
      * <p> Removes node from Binary Search Tree. Determines whether the node exists in the tree. If node is
      * a leaf node, remove node. If node has one child, replace node with child. Otherwise replace node with
      * the minimum node in the right-hand substree. 
      * </p>
      * @param d Data contained in node to be deleted
      * @param node Node to be removed from tree
      * @return BinaryTreeNode - returns the removed node if successfully removed from tree
      * @see findMin(BinaryTreeNode<dataType> node) 
      */
    public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node) {
        int cmp = d.compareTo(node.getData());
        
        if (node == null) {
            return null;
        }
        else if (cmp < 0) {
            opCount++;
            node.setLeftChild(delete(d, node.getLeftChild()));
        }
        else if (cmp > 0){
            opCount++;
            node.setRightChild(delete(d, node.getRightChild()));
        }
        else if (node.getLeftChild() != null && node.getRightChild() != null) {
            opCount++;
            node.setData(findMin(node.getRightChild()).getData());
            node.setRightChild(removeMin(node.getRightChild()));
        }
        else {
            if (node.getLeftChild() != null) {
                opCount++;
                node = node.getLeftChild();
            }
            else {
                node = node.getRightChild();
            }
        }
        return node;
    }
    
    /**
      * Auxiliary method for finding the minimum node a the right-hand subtree of a node that is to be deleted
      * @param node Node that is to be deleted
      @ @return BinaryTreeNode - Minimum node in the right-hand subtree
      */
    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node) {
        if (node != null) {
            while (node.getLeftChild() != null) {
                node = node.getLeftChild();
            }
        }
        return node;
    }
    
    /**
      * Auxiliary method for popping the minimum node out of the right-hand subtree of a parent node.
      * @param node Parent node to be replaced by minimum node
      * @return BinaryTreeNode - The minimum node to replace parent node
      */
    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return null;
        }
        else if (node.getLeftChild() != null) {
            node.setLeftChild(removeMin(node.getLeftChild()));
            return node;
        }
        else {
            return node.getRightChild();
        }
    }
    
    /**
      * Auxiliary method for determining tree height.
      * @return int - Tree height
      * @see getHeight(BinaryTreeNode<dataType> node)
      */
    public int getHeight() {
        return getHeight(root);
    }
    
    /**
      * Obtain Binary Search Tree height using recursion
      * @return int - Binary Search Tree Height
      * @param node Binary Tree Node at which height of tree must be determined
      */
    public int getHeight(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(getHeight(node.getLeftChild()), 
                                getHeight(node.getRightChild())
                                );
        }
    }
    
    /**
      * Auxiliary method for determining tree size.
      * @return int - Tree size
      */
    public int getSize() {
        return getSize(root);
    }
    
    /**
      * Obtain number of nodes in the Binary Search Tree using recursion
      * @return int - Number of node in tree
      * @param node Binary Tree Node to be counted in determining tree size
      */
    public int getSize(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return 0;
        }
        else {
            return 1 + getSize(node.getLeftChild()) + getSize(node.getRightChild());
        }
    }
    
    /**
      * Prints node data to standard output
      * @param node Binary Tree Node to be visited
      */
    public void visit(BinaryTreeNode<dataType> node) {
        //do something
        System.out.println(node.getData());
    }
    
    /**
      * Traverses the Binary Search Tree according to a specified sorting algorithm.
      * @param traversalType <p> Defines the type of sorting algorithm to be used. Includes "pre-order",
      * "post-order", "level-order" and "in-order" traversal types.
      * </p>
      * @see postOrder()
      * @see preOrder()
      * @see inOrder()
      * @see levelOrder()
      */
    public void traverse(String traversalType) {
        if (traversalType.equals("pre-order")) {
            preOrder();
        }
        else if (traversalType.equals("post-order")) {
            postOrder();
        }
        else if (traversalType.equals("level-order")) {
            levelOrder();
        }
        else if (traversalType.equals("in-order")) {
            inOrder();
        }
        else {
            System.out.println("Invalid traversal type.");
        }
    }
    
    /**
      * Auxiliary method for sorting tree data according to pre-order algorithm
      */
    public void preOrder() {
        preOrder(root);
    }
    
    /**
      * Sorts tree nodes according to the pre-order algorithm, i.e. visit the node before visiting children
      * @param node Node to be visited in pre-order arrangement.
      */
    public void preOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
//         else {
//             System.out.println("The tree is empty. Please add a new node");
//         }
    }
    
    /**
      * Auxiliary method for sorting tree data according to in-order algorithm
      */
    public void inOrder() {
        inOrder(root);  
    }
    
    /**
      * Sorts tree nodes according to the in-order algorithm, i.e. visit the left child before visiting
      * the node and the right child.
      * @param node Node to be visited in in-order arrangement.
      */
    public void inOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            visit(node);
            inOrder(node.getRightChild());
        }
//         else {
//             System.out.println("The tree is empty. Please add a new node");
//         }
    }
    
    /**
      * Auxiliary method for sorting tree data according to post-order algorithm
      */
    public void postOrder() {
        postOrder(root);
    }
    
    /**
      * Sorts tree nodes according to the post-order algorithm, i.e. visit node after visiting children. 
      * @param node Node to be visited in post-order arrangement.
      */
    public void postOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            visit(node);
        }
//         else {
//             System.out.println("The tree is empty. Please add a new node");
//         }
    }
    
    /**
      * Auxiliary method for sorting tree data according to level-order algorithm
      */
    public void levelOrder() {
        levelOrder(root);
    }
    
    /**
      * Sorts tree nodes according to the level-order algorithm, i.e. visit node on each level from left to
      * right. 
      * @param node Node to be visited in level-order arrangement.
      */
    public void levelOrder(BinaryTreeNode<dataType> node) {
        
        if (root == null) {
            return;
        }
        
        BTQueue<dataType> q = new BTQueue<dataType> ();
        q.enQueue(root);
        
        do {
            visit(node);
            if(node.getLeftChild() != null) {
                q.enQueue(node.getLeftChild());
            }
            if(node.getRightChild() != null) {
                q.enQueue(node.getRightChild());
            }
        } while ((node = q.getNext()) != null);
    }
}
