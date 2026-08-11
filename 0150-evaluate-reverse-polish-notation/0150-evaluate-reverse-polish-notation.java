class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": case "-": case "*": case "/": {
                    int b = st.pop(); 
                    int a = st.pop(); 
                    switch(token){
                        case "+": st.push(a + b); break;
                        case "-": st.push(a - b); break;
                        case "*": st.push(a * b); break;
                        case "/": st.push(a / b); break;
                    }
                    break;
                }
                default:
                    st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}