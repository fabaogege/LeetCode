package exercise;
import java.util.Stack;
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //入队：即为stack1的入栈
    public void push(int node) {
        stack1.push(node);
    }
    //出队
    public int pop() {
        //队列为空判断
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("队列为空");
        }
        //分stack2是否为空进行判断。
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}