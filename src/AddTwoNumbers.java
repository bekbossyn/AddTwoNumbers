/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Add_Two_Numbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int rem = 0;
        int sum = 0;
        while (true) {
            if (l1 == null && l2 == null) {
                break;
            }

            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
            }
            int num2 = 0;
            if (l2 != null) {
                num2 = l2.val;
            }
            sum = num1 + num2;
            if (temp == null) {
                temp = new ListNode(sum % 10);
                result = temp;
                rem = sum / 10;
            } else {
                sum += rem;
                rem = sum / 10;
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (rem != 0) {
            temp.next = new ListNode(rem);
            temp = temp.next;
        }
        return result;
    }

    static String print(ListNode l) {
        StringBuilder myList = new StringBuilder();
        if (l == null) {
            return myList.toString();
        }
        myList.append("[");
        while (l.next != null) {
            myList.append(String.valueOf(l.val)).append(", ");
            l = l.next;
        }
        myList.append(l.val).append("]");
        return String.valueOf(myList);
    }

    public static void main(String[] args) {

        //#TODO make printing nodes method

        ListNode l3 = new ListNode(9);
        ListNode l1 = l3;

        l3.next = new ListNode(9);
        l3 = l3.next;
        l3.next = new ListNode(9);
        l3 = l3.next;
        l3.next = new ListNode(9);
        l3 = l3.next;
        l3.next = new ListNode(9);
        l3 = l3.next;
        l3.next = new ListNode(9);
        l3 = l3.next;
        l3.next = new ListNode(9);

        ListNode l4 = new ListNode(9);
        ListNode l2 = l4;

        l4.next = new ListNode(9);
        l4 = l4.next;
        l4.next = new ListNode(9);
        l4 = l4.next;
        l4.next = new ListNode(9);

        System.out.println(print(addTwoNumbers(l1, l2)));
        System.out.println(print(addTwoNumbers(new ListNode(9), new ListNode(9))));
    }

}