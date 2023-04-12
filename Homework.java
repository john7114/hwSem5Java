import java.util.NoSuchElementException;
import java.util.Deque;
import java.util.ArrayDeque;
public class Homework {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()")); // true
        System.out.println(isCorrectParentheses("(")); // false
        System.out.println(isCorrectParentheses("())")); // false
        System.out.println(isCorrectParentheses("((()))")); // true
        System.out.println(isCorrectParentheses("()[]{}<>")); // true
        System.out.println(isCorrectParentheses("([)]")); // false
        System.out.println(isCorrectParentheses("][]")); // false
        System.out.println(isCorrectParentheses("[]{<()[]<>>}")); // true
    }

    /**
     * Дана последовательность скобочек. Проверить, что она является корректной.
     */
    static boolean isCorrectParentheses(String parentheses) {
        // TODO: 07.04.2023 Вписать решение!

        String[] strArr = parentheses.split("");
        String openingBrackets = "([{<";
        String closingBrackets = ")]}>";

        if (strArr.length <= 1 || closingBrackets.contains(strArr[0])) {
            return false;
        }
        Deque<String> stack = new ArrayDeque<String>();
        for (String s : strArr) {
            if (openingBrackets.contains(s)) {
                stack.offer(s);
            } else if (closingBrackets.contains(s)) {
                // здесь я сделал обработку исключения, которое вызывает getLast() при пустом stack
                try {
                    if (stack.getLast().equals("(") & s.equals(")")) {
                        stack.pollLast();
                    } else if (stack.getLast().equals("[") & s.equals("]")) {
                        stack.pollLast();
                    } else if (stack.getLast().equals("{") & s.equals("}")) {
                        stack.pollLast();
                    } else if (stack.getLast().equals("<") & s.equals(">")) {
                        stack.pollLast();
                    }
                } catch (NoSuchElementException e) {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
