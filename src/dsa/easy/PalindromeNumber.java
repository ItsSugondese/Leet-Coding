package dsa.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] listOfChar = String.valueOf(x).toCharArray();

        String merge = "";
        for(int i=listOfChar.length-1; i>=0; i--){
            merge += listOfChar[i];
        }
        try{
            int val = Integer.parseInt(merge);
            if(val == x)
                return  true;
        }catch (Exception e){
        }
        return  false;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome(-121));
        System.out.println(palindromeNumber.isPalindrome(10));
        System.out.println(palindromeNumber.isPalindrome(543212345));
    }
}
