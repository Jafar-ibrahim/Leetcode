import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MinStack {

    Stack<Node> stack ;
    int min= Integer.MAX_VALUE;

    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int val) {
        //update the min value
        if(val < min) {
            min = val;
        }
        // push to the stack
        stack.push(new Node(val,min));

    }

    public void pop() {
        Node temp = stack.pop();
        if(stack.empty()) min=Integer.MAX_VALUE;
        else 
            if(temp.value == min)
                min = stack.peek().min;
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return min;
    }
    class Node{
        int value;
        int min;
        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    };
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */