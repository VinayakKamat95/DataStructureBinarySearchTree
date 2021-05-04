package com.bridgelabz;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add (K key){
        this.root = this.addRecursively(root,key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if(current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if(compareResult ==0) return current;
        if (compareResult < 0) {
            current.left = addRecursively(current.left, key);
        }else {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    public int getSize() {
        return this.getSizeRecursive(root);
    }

    private int getSizeRecursive(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursive(current.left)
                +this.getSizeRecursive(current.right);
    }

    public K search (K key){
        K searchResult = searchRecursively(root, key);
        System.out.println(searchResult);
        return searchResult;
    }

    public K searchRecursively(MyBinaryNode<K> current, K key) {
        // Base Cases: current is null or key is present at root
        if ( current == null || current.key == key ){
            return current.key;
        }
        // Key is greater than current's key
        if ((current.key.compareTo(key))<0) {
            return searchRecursively(current.right, key);
        }
        // Key is smaller than current's key
        return searchRecursively(current.left, key);
    }

}

