package binarysearchtree;

class BTQueue<dataType extends Comparable<dataType>> {
    BinaryTreeNode<dataType> head;
    BinaryTreeNode<dataType> tail;
    
    
    public BTQueue() {
        this.head = null;
        this.tail = null;
    }
    
    public void enQueue(BinaryTreeNode<dataType> newNode) {
        if (head == null) {
            tail = newNode;
            head = tail;
        }
        else {
            tail.setLink(newNode);
            tail = tail.getLink();
        }
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public void clear() {
        head = null;
        tail = null;
    }
    
    public BinaryTreeNode<dataType> getNext() {
        return head;
    }
    
    public boolean removeHead() {
        if (head != null) {
            head = head.getLink();
            return true;
        }
        return false;
    }
}
