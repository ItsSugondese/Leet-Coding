package dsa.easy;

// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/?envType=daily-question&envId=2024-04-04
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VPS {

    public int maxDepth(String s) {
        char[] listOfChar = s.toCharArray();

        if(s.isBlank())
            return 0;
        else {
            if(listOfChar.length > 100 && listOfChar.length < 1) {
                throw new RuntimeException("Constraint didn't match");
            }

            int startBarcesCount = 0;
            int intoCount = 0;
            int endBarcesCount = 0;
            int noOfClosingBraces = 0;
            List<Character> validChar = new ArrayList<>(Arrays.asList('+', '-', '*', '/', '(', ')' ));
            for(int i=0; i<10; i++) {
                validChar.add(String.valueOf(i).toCharArray()[0]);
            }
            int maxDepthCount = 1;
            for(int i=0; i< listOfChar.length; i++) {
                if(!validChar.contains(listOfChar[i])) {
                    throw new RuntimeException("Not a valid input");
                }
                if(listOfChar[i] == '(') {
                    startBarcesCount += 1;
                    intoCount += 1;
                }
                else if(listOfChar[i] == ')') {
                    endBarcesCount += 1;
                    if(maxDepthCount < intoCount)
                        maxDepthCount = intoCount;
                    intoCount -=1;
                }
            }

            if(startBarcesCount != endBarcesCount)
                throw new RuntimeException("Not a valid VPS");

            if(startBarcesCount == 0) {
                return 0;
            }
            return maxDepthCount;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VPS VPS = new VPS();

        System.out.println(VPS.maxDepth("1")); //0
        System.out.println(VPS.maxDepth("(1)+((2))+(((3)))")); //3
        System.out.println(VPS.maxDepth("(1+(2*3)+((8)/4))+1")); //3
        System.out.println(VPS.maxDepth("1+(2*3)/(2-1)")); //1
        System.out.println(VPS.maxDepth("(1+2)/(5+((4-9+8)*((1+8+(5*7)*4)/(7+9-5)))/(7/3-8-4-8))")); //5
    }

}