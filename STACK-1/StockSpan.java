import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int stocks [] = {100, 80 , 60 , 70, 60 , 85, 100};
        int span [] = new int[stocks.length];

        stockSpan(stocks , span);

        for(int i =1 ; i<stocks.length;i++){
            System.out.println(span[i] + " ");
        } 
    }


    public static void stockSpan(int[] stock , int[] span){
        Stack <Integer> s = new Stack<>();

        span[0] = 1;
        s.push(0);
        for(int i =1 ; i< stock.length ; i++){
           // pop only if the current stock price is greater than or equal to the stack prices 

            while(!s.isEmpty() && stock[i] >=  stock[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    
}
