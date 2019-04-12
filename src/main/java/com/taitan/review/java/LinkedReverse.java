package com.taitan.review.java;

/**
 * @author 邹德翔
 * @date 2019/4/12 14:55
 *
 * 链表反转
 */
public class LinkedReverse {

    public static void main(String[] args) {

        LinkedNode head = new LinkedNode(0);
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        /** 链表反转前遍历 */
        LinkedNode tempNode = head;
        while (tempNode != null){
            System.out.println(tempNode.data);
            tempNode = tempNode.next;
        }

        System.out.println("--------------------");

        head = reverse(head);

        /** 打印反转后的结果 */
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }


    /**
     * 递归、再反转当前节点之前先反转后续节点
     * @param head
     * @return
     */
    static LinkedNode reverse(LinkedNode head){

        /** head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点 */
        if (head == null || head.next == null){
            return head;
        }

        /** 先反转后续节点 head.next */
        LinkedNode reHead = reverse(head.next);
        /** 将当前节点的指针域指向前一节点 */
        head.next.next = head;
        /** 前一节点的指针域设为空 */
        head.next = null;
        return reHead;
    }
}



/**
 * 链表节点类
 */
class LinkedNode{

    // 数据域
    int data;

    // 指针域
    LinkedNode next;

    LinkedNode(int data){
        this.data = data;
    }
}
