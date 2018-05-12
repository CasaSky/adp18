/**
 * Created by michelbrueger on 12.05.18.
 */
public class ExpressionStacker {
    private String expression;
    private Stack stack;
    private Token operand1;
    private Token operand2;
    private Token operator;
    private Token dummy;

    public ExpressionStacker(String expression){
        this.expression = expression;
        this.stack = new Stack();
    }

    public static int computePartialExpression(int operand1, int operand2, char operator){
        int result;
        switch (operator){
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            default: throw new IllegalArgumentException("No acceptable operator found (+,-,*,/)") ;
        }

        return result;
    }
}
