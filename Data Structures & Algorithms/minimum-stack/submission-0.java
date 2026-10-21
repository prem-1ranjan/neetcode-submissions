class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();;

    public MinStack() {
       
    }
    
    public void push(int val) {
        mainStack.push(val);
        
        // Agar minStack khali hai, ya naya value current minimum se chota/barabar hai,
        // toh isko minStack mein bhi daal do.
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // Agar mainStack se pop hone wala value hi humara current minimum hai,
        // toh use minStack se bhi nikal do, taaki uske neeche wala purana minimum wapas aa jaye.
        // Note: .equals() use kiya hai kyunki Java mein Integer objects compare ho rahe hain
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}