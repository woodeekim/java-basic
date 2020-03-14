package dataStructure.stack;

/**
    1) int Stack 본체 구현
    2) push, pop 메소드 구현
 **/
public class IntStack {

    private int max;
    private int pointer;
    private int[] stackArray;

    public IntStack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            stackArray = new int[max];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }
    //비어있는 stack에 값을 pop 할 경우 예외처리
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    //가득찬 stack에 값을 push 할 경우 예외처리
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }

    //push()
    public int push(int x) throws OverflowIntStackException {
        if(pointer >= max){
            throw new OverflowIntStackException();
        }
        return stackArray[pointer++] = x;
    }

    //pop()
    public int pop() throws EmptyIntStackException {
        if(pointer <= 0){
            throw new EmptyIntStackException();
        }
        return stackArray[--pointer];
    }

    public static void main(String[] args) {
        IntStack intStack = new IntStack(3);
        intStack.push(5);
        intStack.push(10);

        for(int i = 0 ; i<intStack.stackArray.length; i++){
            System.out.println("stackArray["+i+"] : "+intStack.stackArray[i]);
        }
        System.out.println(intStack.pointer);
        intStack.pop();
        intStack.pop();
        for(int i = 0 ; i<intStack.stackArray.length; i++){
            System.out.println("stackArray["+i+"] : "+intStack.stackArray[i]);
        }
        System.out.println(intStack.pointer);

    }



}
