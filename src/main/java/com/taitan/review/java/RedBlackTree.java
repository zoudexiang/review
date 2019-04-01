package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/3/31 17:07
 *
 * 红黑树 ----> 递归思想
 */
public class RedBlackTree {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.add(20);
        tree.add(30);
        tree.add(10);
        tree.add(210);
        tree.add(2);
        tree.add(70);
        tree.add(90);

        tree.travel();
    }
}

class Tree {

    Node root = null;

    public void add(int value){

        Node newNode = new Node();
        newNode.value = value;

        if (root == null){
            root = newNode;
        }else{
            insertNode(root,newNode);
        }
    }

    /**
     * 插入节点
     * @param node
     * @param newNode
     */
    public void insertNode(Node node,Node newNode){

        if (newNode.value < node.value){
            if (node.left == null){
                node.left = newNode;
            }else {
                insertNode(node.left,newNode);
            }
        }else {
            if (node.right == null){
                node.right = newNode;
            }else {
                insertNode(node.right,newNode);
            }
        }
    }

    /**
     * 遍历红黑树
     * @param node
     */
    public void travel(Node node){
        if (node != null){
            travel(node.left);
            System.out.print(node.value + " ");
            travel(node.right);
        }
    }

    public void travel(){
        travel(root);
    }
}

/**
 * 节点类
 */
class Node{
    int value;
    Node left;
    Node right;
}


