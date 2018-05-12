import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michelbrueger on 12.05.18.
 */
public class ExpressionStackerTest {
    Token operand1;
    Token operand2;
    Token operatorPlus;
    Token operatorMinus;
    Token operatorAsterisk;
    Token operatorSlash;
    Token dummy;


    @Before
    public void setup() throws Exception {
        operand1 = new Token(10);
        operand2 = new Token(20);
        operatorPlus = new Token('+');
        operatorMinus = new Token('-');
        operatorAsterisk = new Token('*');
        operatorSlash = new Token('/');
        dummy = new Token('(');
    }

    @Test
    public void computePartialExpression() throws Exception {
        assertEquals(30, ExpressionStacker.computePartialExpression(operand1.getOperand(), operand2.getOperand(), operatorPlus.getOperator()));
        assertEquals(-10, ExpressionStacker.computePartialExpression(operand1.getOperand(),operand2.getOperand(), operatorMinus.getOperator()));
        assertEquals(200, ExpressionStacker.computePartialExpression(operand1.getOperand(), operand2.getOperand(), operatorAsterisk.getOperator()));
        assertEquals(0, ExpressionStacker.computePartialExpression(operand1.getOperand(), operand2.getOperand(), operatorSlash.getOperator()));
    }

}