/**
 * Created by michelbrueger on 12.05.18.
 */
public class Token {
    private int operand;
    private char operator;

    public Token(int operand){
        this.operand = operand;
        this.operator = 'X';
    }
    public Token(char operator){
        this.operand = 0;
        this.operator = operator;
    }

    public int getOperand(){
        return operand;
    }

    public char getOperator(){
        return operator;
    }

    public void setOperand(int newOperand){
        this.operand = newOperand;
    }

    public void setOperator(char newOperator){
        this.operator = newOperator;
    }

}
