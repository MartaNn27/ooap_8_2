// Abstract Expression
interface Expression {
    int interpret();
}

// Terminal Expression for Integer
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

// Non-Terminal Expression for Addition
class AddExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public AddExpression(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}

// Non-Terminal Expression for Subtraction
class SubtractExpression implements Expression {
    private Expression leftOperand;
    private Expression rightOperand;

    public SubtractExpression(Expression left, Expression right) {
        this.leftOperand = left;
        this.rightOperand = right;
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}

// Client or Context
public class InterpreterDemo {
    public static void main(String[] args) {
        // 10 + (5 - 2)
        Expression expression = new AddExpression(
                new NumberExpression(10),
                new SubtractExpression(
                        new NumberExpression(5),
                        new NumberExpression(2)
                )
        );

        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 13
    }
}
