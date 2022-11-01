package avltree;

/** <h1> AVL Tree </h1>
  * <p> AVL tree data structure code implementing the AVLTree interface. AVL tree is a binary search tree with 
  * additional balancing conditions. Initially intended for use in the AVLExperiment application.
  * </p>
  * @author Bonga Njamela
  * @since 12-03-22
  * @version 1.0
  */
  
public class AVLTree<dataType extends Comparable<dataType>> implements AVLTreeInterface<dataType>{
    
    BinaryTreeNode<dataType> root;
    public static int opCount;
    public static int findCount;
    
    /**
      * AVL Tree explicit constructor which initialises non-null root.
      * @param rootNode The tree's root node
      */
    public AVLTree(BinaryTreeNode<dataType> rootNode) {
        this.root = rootNode;
        opCount = 0;
        findCount = 0;
    }
    
    /**
      * Empty AVL Tree constructor initialising null root.
      */
    public AVLTree() {
        this.root = null;
        opCount = 0;
        findCount = 0;
    }
    
    /**
      * Gives the height of the node substree.
      * @param node The Binary Tree node at which the subtree height is calculated
      * @return int - Returns the height of the subtree or -1
      */
    public int subHeight(BinaryTreeNode<dataType> node) {
        if (node != null) {
            return node.getHeight();
        }
        return -1;
    }
    
    /**
      *<p> Calculates the balance factor, i.e. the height of the left-hand side subtree subtracted from the 
      * height of the right-hand side subtree.
      *</p>
      * @param node The node at which the balance factor is calculated.
      * @return int - This is the balance factor of the tree
      * @see subHeight(BinaryTreeNode node)
      */
    public int balanceFactor(BinaryTreeNode<dataType> node) {
        return subHeight(node.getRightChild()) - subHeight(node.getLeftChild());
    }
    
    /**
      * <p> Fixes the height at a particular node from bottom of AVL tree going up. Typically used after 
      * changing the AVL tree.
      * </p>
      */
    public void fixHeight(BinaryTreeNode<dataType> node) {
        node.setHeight(Math.max(subHeight(node.getLeftChild()), subHeight(node.getRightChild())) + 1);
    }
    
    /**
      * <p> Used to rotate the AVL tree to the right when when inserting or deleting a node in the left 
      * hand side subtree of the left child of a node.
      * </p>
      * @param node AVL tree node on which a rotation with the left child will be performed.
      * @return BinaryTreeNode - returns the rotated tree node.
      */
    public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> node) {
        if (node != (BinaryTreeNode) null) {
            if (node.getRightChild() != (BinaryTreeNode)null) {
                BinaryTreeNode<dataType> r = node.getRightChild();
                node.setLeftChild(r.getRightChild());//swap the left and right children of the nodes
                r.setRightChild(node);//swap the right child with the node
                fixHeight(node);//fix the height of the node
                fixHeight(r);
                return r;
            }
        }
        return node;
    }
    
    /**
      * <p> Used to rotate the AVL tree to the left when when inserting or deleting a node in the right 
      * hand side subtree of the right child of a node.
      * </p>
      * @param node AVL tree node on which a rotation with the right child will be performed.
      * @return BinaryTreeNode - returns the rotated tree node.
      */
    public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> node) {
        if (node != (BinaryTreeNode) null) {
            if (node.getLeftChild() != (BinaryTreeNode)null) {
                BinaryTreeNode<dataType> r = node.getLeftChild();
                node.setRightChild(r.getLeftChild());//swap the left and right children of the nodes
                r.setLeftChild(node);//swap the left child with the node
                fixHeight(node);//fix the height of the node
                fixHeight(r);
                return r;
            }
        }
        return node;
    }
    
    /**
      * <p>
      * Reestablishes the AVL tree balance conditions by performing appropriate double rotations. If the 
      * balance factor of the right subtree is less than zero then there is an imbalance in the left subtree 
      * and we need to perform a double rotation by first rotating the tree with the right child and then 
      * again with the left child. Likewise, if the imblance is in the left-hand side subtree then we perform
      * a double rotation beginning with a left rotation then followed by a right rotation.
      * </p>
      * @param node The node where the imbalance occurs.
      * @return BinaryTreeNode - returns the node satisfying AVL balance conditions
      */
    public BinaryTreeNode<dataType> balance(BinaryTreeNode<dataType> node) {
        fixHeight(node);//resynchronise internal variable that stores height
        if (balanceFactor(node) == 2) {//check balance factor for AVL conditions
            if (balanceFactor(node.getRightChild()) < 0) {//indicates imbalance in right subtree
                node.setRightChild(rotateRight(node.getRightChild()));//rotate tree right to balance
            }
            return rotateLeft(node);
        }
        if (balanceFactor(node) == -2) {//indicates imbalance in left subtree
            if (balanceFactor(node.getLeftChild()) > 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        return node;//tree is actually balance at node
    }
    
    /**
      * Auxiliary method for adding new node to a AVL Tree using recursion.
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
      * <p> Adds a new node to the AVL Tree. If the root is null, then the new node becomes the 
      * entire tree. if the root is not null, then compare the key(s) of existing node(s) to the new node. 
      * If the value of the key of the new node is less than the key of the old node, add the new node
      * as the left child. Otherwise if the key is greater, add the node as the right child.
      * </p>
      * @param d This is the data of the new node to be added.
      * @param node The left or right child node to be compared to during insertion.
      * @see balance(BinaryTreeNode node)
      */
    public void insert(dataType d, BinaryTreeNode<dataType> node) {
        
        int cmp = d.compareTo(node.getData());
        
        if (cmp == 1) {
            if (node.getLeftChild() == (BinaryTreeNode) null) {
                node.setLeftChild(new BinaryTreeNode<dataType>(d, null, null));//add as left child
                opCount++;
            }
            else {
                opCount++;
                insert(d, node.getLeftChild());
            }
        }
        else if (cmp == 3){
            if (node.getRightChild() == (BinaryTreeNode) null) {
                opCount++;
                node.setRightChild(new BinaryTreeNode<dataType>(d, null, null));//add as right child
            }
            else {
                opCount++;
                insert(d, node.getRightChild());
            }
        }
        balance(node);
    }

    /** 
      * Auxiliary method for searching for a node in a AVL Tree using recursion.
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
        
        if (comparison == 1) {
            findCount++;
            return (node.getLeftChild() == (BinaryTreeNode) null) ? null: find(d, node.getLeftChild());
        }
        else if (comparison == 2) {
            findCount++;
            return node.getData();
        }
        else if (comparison == 3){
            findCount++;
            return (node.getRightChild() == (BinaryTreeNode) null) ? null: find(d, node.getRightChild());
        }
        else {
            findCount++;
            return d;
        }
    }
    
    /** 
      * Auxiliary method for deleting a node from the AVL Tree using recursion.
      * @param d Data contained in tree node
      * @see delete(dataType,BinaryTreeNode)
      */
    public void delete(dataType d) {
        root = delete(d, root);
    }
    
    /**
      * <p> Removes node from AVL Tree. Determines whether the node exists in the tree. If node is
      * a leaf node, remove node. Reestablishes AVL balance in the tree from the position of the removed node
      * to the bottom of the tree. Employs the balance() method.
      * </p>
      * @param d Data contained in node to be deleted
      * @param node Node to be removed from tree
      * @return BinaryTreeNode - returns the removed node if successfully removed from tree
      * @see findMin(BinaryTreeNode<dataType> node) 
      */
    public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node) {
        int cmp = d.compareTo(node.getData());
        
        if (cmp == 0) {
            return null;
        }
        else if (cmp == 1) {
            opCount++;
            node.setLeftChild(delete(d, node.getLeftChild()));
        }
        else if (cmp == 3){
            opCount++;
            node.setRightChild(delete(d, node.getRightChild()));
        }
        else {
            BinaryTreeNode<dataType> q = node.getLeftChild();
            BinaryTreeNode<dataType> r = node.getRightChild();
            if (r == null) {
                return q;
            }
            BinaryTreeNode<dataType> min = findMin(r);
            min.setRightChild(removeMin(r));
            min.setLeftChild(q);
            return balance(min);
        }
        return balance(node);
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
        if (node.getLeftChild() == null) {
            return node.getRightChild();
        }
        node.setLeftChild(removeMin(node.getLeftChild()));
        return balance(node);
    }
    
    /**
      * Auxiliary method for determining tree height.
      * @return int - Tree height
      * @see getHeight(BinaryTreeNode<dataType> node)
      */
    public int getHeight() {
        return nodeHeight(root);
    }
    
    /**
      * Obtain AVL Tree height using recursion
      * @return int - Binary Search Tree Height
      * @param node Binary Tree Node at which height of tree must be determined
      */
    public int nodeHeight(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return -1;
        }
        else {
            return 1 + Math.max(nodeHeight(node.getLeftChild()), 
                                nodeHeight(node.getRightChild())
                                );
        }
    }
    
    /**
      * Auxiliary method for determining tree size.
      * @return int - Tree size.
      */
    public int getSize() {
        return getSize(root);
    }
    
    /**
      * Obtain number of nodes in the AVL Tree using recursion
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
        System.out.println(node.getData());
    }
    
    /**
      * Traverses the AVL Tree according to a specified sorting algorithm.
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
        } while ((q.getNext()) != null);
    }
}
