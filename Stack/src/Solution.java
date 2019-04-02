import java.util.Stack;

/**
 * leetcode 20题
 */
public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0 ;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='['|| c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if(c==')'&& topChar !='('){
                    return false;
                }else if(c==']' && topChar!='['){
                    return false;
                }else if(c=='}'&& topChar !='{'){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        boolean success = new MySolution().isValid("{{}}");
        System.out.println(success);
    }
}
