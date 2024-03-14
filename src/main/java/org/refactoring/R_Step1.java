package org.refactoring;

public class R_Step1 {
    public static void main(String[] args) {
        //25+61=100
        //1 ~ 5자리수 덧셈 수식이 맞는지 확인하는 프로그램
        //띄어쓰기 없음
        String str = "25+61=86"; //PASS
        System.out.println(getResult(str));
        str = "12345+12345=24690"; //PASS
        System.out.println(getResult(str));
        str = "5++5=10"; //ERROR
        System.out.println(getResult(str));
        str = "10000+1=10002"; //FAIL
        System.out.println(getResult(str));

    }

    private static int getCountOf(String str, char c) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int getIndexOf(String str, char c) {
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                idx = i;
            }
        }
        return idx;
    }

    private static boolean isInvalidSymbol(String str) {
        boolean b = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') continue;
            if (str.charAt(i) == '=') continue;
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                b = true;
                break;
            }
        }
        return b;
    }

    private static String getResult(String str) {
        int plusCount = getCountOf(str, '+');
        int plusIndex = getIndexOf(str, '+');
        int equalCount = getCountOf(str, '=');
        int equalIndex = getIndexOf(str, '=');
        boolean isInvalidFormula = isInvalidSymbol(str);

        if (isInvalidFormula) {
            return "ERROR";
        }
        if (equalCount > 1 || plusCount > 1) {
            return "ERROR";
        }
        if (plusIndex >= equalIndex - 1 || equalIndex < 3 || equalIndex >= str.length() - 1) {
            return "ERROR";
        }

        return judgeResult(str, plusIndex, equalIndex);
    }

    private static String judgeResult(String str, int plusSignIndex, int equalSignIndex) {
        int n1 = subStrAndConvertInt(str, 0, plusSignIndex);
        int n2 = subStrAndConvertInt(str, plusSignIndex + 1, equalSignIndex);
        int result = subStrAndConvertInt(str, equalSignIndex + 1, str.length());

        return n1 + n2 == result ? "PASS": "FAIL";
    }

    private static int subStrAndConvertInt(String str, int startIdx, int endIdx) {
        return strToInt(str.substring(startIdx, endIdx));
    }

    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}