package exercise;
/**
 * 2个队列实现栈
 * 思路：q1作为入栈出栈的，q2作为一个中间站，不存储数据，
 * 入栈：直接q1入队
 * 出栈：将q1除了最后一个元素外，其他的全部入队到q2中,然后q1剩下的1个元素出队列。之后把q2中的全部元素入队回q1中。
 */

import java.util.LinkedList;
import java.util.Queue;
//q1作为入栈出栈的，q2作为一个中间站，不存储数据
 class QueueToStack1<E> {
    Queue<E> queue1 = new LinkedList<>();
    Queue<E> queue2 = new LinkedList<>();
    //入栈
    public void push(E e) {
        queue1.add(e);
    }
    //出栈
    public E pop(){
        E e;
        //栈为空判断
        if(queue1.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //先将q1的元素都转到q2去
        while (queue1.size()!=1){
            queue2.add(queue1.poll());
        }
        e=queue1.poll();
        //q2元素再回来
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return e;
    }
}
//第一种方法最大的问题就是每弹出一个元素，数据都会要从Q2转回到q1，太耗费时间了。
//改进：用2个指针，一个指针(pQueue)需要进行入栈出栈操作的队列，另外一个指针(pAir)指向中转站的队列，
//入栈：pQueue指向的队列入队
//出栈：pQueue指向的队列除了最后一个元素外，其他的全部入队到pAir指向的队列中,然后pQueue指向的队列剩下的1个元素出队列。然后更新2个指针
//这样就节省了回来的步骤。节省了大量的时间
class QueueToStack2<E>{
    Queue<E> queue1 = new LinkedList<>();
    Queue<E> queue2 = new LinkedList<>();
    Queue<E> pQueue;//指向入队出队的队列
    Queue<E> pAir;//指向中转站队列
    //入栈
    public void push(E e) {
        if(!queue1.isEmpty()){//q1不为空
            pQueue=queue1;
            pAir=queue2;
        }else {
            pQueue=queue2;
            pAir=queue1;
        }
        pQueue.add(e);
    }
    //出栈
    public E pop(){
        E e;
        if(!queue1.isEmpty()){//q1不为空
            pQueue=queue1;
            pAir=queue2;
        }else {
            pQueue=queue2;
            pAir=queue1;
        }
        //栈为空判断
        if(pQueue.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        while (pQueue.size()!=1){
            pAir.add(pQueue.poll());
        }
        e = pQueue.poll();
        return e;
    }
}