import java.util.Stack;

/**
 * Created by liuzhihan on 2017/9/30.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String message = "tomorrow is holiday";
        String result = reverseMsg(message);
        System.out.println(result);
    }

    private static String reverseMsg(String message) {
        StringBuilder result = new StringBuilder(message.length());

        Stack<String> stack = new Stack<>();
        String[] words = split(message, " ");
        if(words==null||words.length <= 1) {
            return message;
        }

        for (String word : words) {
            stack.push(word);
        }

        for (int i = 0, num = words.length; i < num; i++) {
            result.append(stack.pop());
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static String[] split(String message, String spit) {
        return message.split(spit);
    }





   /* public static String reverseMsg(String message) {
        StringBuffer result = new StringBuffer(message.length());
        int wordsNum = 0;
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : message.toCharArray()) {
            stringBuilder.append(c);
            if (' ' == c) {
                wordsNum++;
                stack.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        stack.push(stringBuilder.toString());


        for (int i = 0; i < wordsNum; i++) {
            result.append(stack.pop());
        }
        return result.toString();
    }*/
}
