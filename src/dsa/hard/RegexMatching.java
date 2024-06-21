package dsa.hard;


// https://leetcode.com/problems/regular-expression-matching/description/
public class RegexMatching {
//    public static boolean isMatch(String s, String p) {
//        int length = s.length();
//
//        for(int i=0; i<length; i++){
//            try {
//
//            if(p.charAt(i) == '.')
//                continue;
//            if(p.charAt(i) == '*')
//                return true;
//            if( s.charAt(i) != p.charAt(i)){
//                return  false;
//            }
//            }catch (StringIndexOutOfBoundsException e){
//                return  false;
//            }
//        }
//        return true;
//    }

//    public static boolean isMatch(String s, String p) {
//        int length = s.length();
//        int patternLength = p.length();
//        int patternIndex = 0;
//        try {
//            for (int i = 0; i < length; i++) {
//                char sChar = s.charAt(i);
//                char pChar = p.charAt(patternIndex);
//                if (p.charAt(patternIndex) == '.'){
//                    if(patternIndex+1 < patternLength){
//
//                    if( (patternIndex+2 > patternLength - 1 && p.charAt(patternIndex+1) == '*')){
//                        return  true;
//                    }
//                    }
//                    patternIndex++;
//                    continue;
//                }
//                else if (p.charAt(patternIndex) == '*') {
//                    if( p.charAt(patternIndex - 1) == '.'){
//                        patternIndex++;
//                        i--;
//                        continue;
//                    }
//                   else  if (p.charAt(patternIndex - 1) == s.charAt(i) )
//                        continue;
//                    else if (p.charAt(patternIndex + 1) == s.charAt(i) || p.charAt(patternIndex + 1) == '.') {
//                        patternIndex += 2;
//                         continue;
//                    }
//                }
//
//                 if (s.charAt(i) != p.charAt(patternIndex) && p.charAt(patternIndex) != '.'
//                        && (patternIndex + 1 < patternLength && p.charAt(patternIndex + 1) != '*')) {
//                    return false;
//                }
//
//               else  if(s.charAt(i) != p.charAt(patternIndex) && p.charAt(patternIndex + 1) == '*')  {
//                    i--;
//                }
//
//               if(i == length - 1 && patternIndex != patternLength-1) {
//                   return false;
//               }
//                patternIndex++;
//
//            }
//        }catch (StringIndexOutOfBoundsException e){
//            return false;
//        }
//        return true;
//    }

    public static boolean isMatch(String s, String p) {
       int patternLength = p.length();
       int stringLength = s.length();

       int stringIndex = 0;
       for (int i = 0; i < patternLength; i++) {
//           if(p.charAt(i) == '.') {
//               if(p.charAt(i+1) == '*'&& i+2 < patternLength) {
//
//               }
//               continue;
//           }
char pChar = p.charAt(i);
char sChar = s.charAt(stringIndex);
           if(p.charAt(i) == '.'){
               if(stringIndex == stringLength-1 && i+1 == patternLength){
                   return true;
               }
               if(stringIndex)
               stringIndex++;
               continue;
           }
           else if(p.charAt(i) == '*'){
               if(p.charAt(i-1) == s.charAt(stringIndex) || p.charAt(i-1) == '.'){
                   if(stringIndex == stringLength-1 && i+1 == patternLength){
                       return true;
                   }else if(p.charAt(i-1) == '.' && i+1 < patternLength - 1){
                       String pSub = s.substring(stringIndex, i+1);
                       return s.endsWith(pSub);

                   }
                   i--;
               }
               else if(s.charAt(stringIndex) != p.charAt(i-1)){
                   continue;
               }
                   stringIndex++;
                   continue;
           }


           if(s.charAt(stringIndex) != p.charAt(i) && p.charAt(i) != '.' ) {
               if(i+1 < patternLength && p.charAt(i+1) == '*'){
                   continue;
               }
               return false;
           }else if (s.charAt(stringIndex) == p.charAt(i) ) {
               if(stringIndex == stringLength-1 && i+1 == patternLength){
                   return true;
               }
           }

           stringIndex++;

       }

       return  false;
    }





    public static void main(String[] args) {

//        System.out.println(isMatch("aa", "a")); // false
//        System.out.println(isMatch("aa", "a*")); // true
//        System.out.println(isMatch("ab", ".*")); // true
//        System.out.println("--------------------------------");
//        System.out.println(isMatch("aab", "c*a*b")); // true
//        System.out.println(isMatch("mississippi", "mis*is*p*.")); // false
//        System.out.println(isMatch("mississippi", "mis*is*ip*.")); // true
//        System.out.println("----------------------------------");
        System.out.println(isMatch("ab", ".*c")); // false
//        System.out.println(isMatch("aaa", "aaaa")); // false
//        System.out.println(isMatch("a", ".")); // true
//        System.out.println(isMatch("a", "a*")); // true
//        System.out.println(isMatch("a", "ab*")); // true
    }
}
