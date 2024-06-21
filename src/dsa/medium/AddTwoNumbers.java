package dsa.medium;

// https://leetcode.com/problems/add-two-numbers/
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }


  }
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int firstVal = l1.val + l2.val;

        ListNode addition = new ListNode(firstVal>=10? firstVal%10 : firstVal);

        ListNode currentAddition = addition;
            ListNode currentl1 = l1.next;
            ListNode currentl2 = l2.next;

            int additionalNo = firstVal>=10? firstVal/10 : 0;
        while(true){
            if(currentl1 != null && currentl2 != null){
                currentAddition.next = new ListNode(currentl1.val + currentl2.val + additionalNo);
            }else if(currentl1 != null)
                currentAddition.next = new ListNode(currentl1.val + additionalNo);
            else if(currentl2 != null)
                currentAddition.next = new ListNode(currentl2.val + additionalNo);
            else{
                if(additionalNo > 0)
                    currentAddition.next = new ListNode(additionalNo);
                break;
            }

            if(currentAddition.next.val >= 10){
                additionalNo = currentAddition.next.val / 10;
                currentAddition.next = new ListNode(currentAddition.next.val % 10);
            }else{
                additionalNo = 0;
            }

            currentAddition = currentAddition.next;

            if(currentl1 != null)
                currentl1 = currentl1.next;

            if(currentl2 != null)
                currentl2 = currentl2.next;

        }

        return addition;
    }

    public  void check(ListNode l1){
        ListNode current = l1;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        AddTwoNumbers node = new AddTwoNumbers();
        System.out.println("Hello world");
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//
//        node1.next = node2;
//        node2.next = node3;
//
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(4);
//
//        node4.next = node5;
//        node5.next = node6;
//
//        node.check(node.addTwoNumbers(node1, node4));



//        ListNode node1 = new ListNode(0);
//
//        ListNode node4 = new ListNode(0);
//
//        node.check(node.addTwoNumbers(node1, node4));


        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        node.check(node.addTwoNumbers(node1, node21));

    }
}
