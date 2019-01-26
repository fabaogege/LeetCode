package exercise;

/*
 * 题目：输入一个链表，反转链表后，输出新链表的表头。
 * */
//非递归
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		//空判断
		if(head == null)
			return head;
		//3个节点分别指向前一节点，当前节点，下一节点。
		ListNode prev = null;
		ListNode current = head;
		ListNode pNext;
		//结束条件就是current节点成为了null时，那么prev节点就成为反转后的头节点了。
        while(current!=null){
        	pNext = current.next;
        	current.next = prev;
        	prev = current;
        	current = pNext;
        }
        return prev;
    }
}
//递归
 class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}
