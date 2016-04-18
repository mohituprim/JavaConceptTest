package DynamicProgramming;


public class MessageEncoding {
    private static int[] dp;
    private static int N;
    private static String A;

    public static void main(String[] args) {
        int a = MessageEncoding.numDecodings("123");
        System.out.println(a);
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        int i = 2;
        while (i <= n) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                int[] arrn = dp;
                int n2 = i;
                arrn[n2] = arrn[n2] + dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                int[] arrn = dp;
                int n3 = i;
                arrn[n3] = arrn[n3] + dp[i - 2];
            }
            ++i;
        }
        return dp[n];
    }

    public static int numDecodingsDpRecursive(String a) {
        N = a.length();
        //if (a == null)
            //return 0;
        dp = new int[N];
        int i = 0;
        while (i < N) {
            MessageEncoding.dp[i] = -1;
            ++i;
        }
        A = a;
        return MessageEncoding.waysbyDp(N - 1);
    }

    public static int waysbyDp(int index) {
        if (index < 0) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ways = 0;
        if (A.charAt(index) > '0') {
            ways = MessageEncoding.waysbyDp(index - 1);
        }
        if (MessageEncoding.isValidTwoDigit(index)) {
            ways += MessageEncoding.waysbyDp(index - 2);
        }
        MessageEncoding.dp[index] = ways;
        return MessageEncoding.dp[index];
    }

    private static boolean isValidTwoDigit(int index) {
        if (index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7')) {
            return true;
        }
        return false;
    }

    public static int waysbyBruteForce(String s, int startIndex) {
        if (s.length() <= startIndex) {
            return 1;
        }
        if (s.charAt(startIndex) == '0') {
            return 0;
        }
        int answer = 0;
        if (MessageEncoding.isValid(s.charAt(startIndex) - 48)) {
            answer += MessageEncoding.waysbyBruteForce(s, startIndex + 1);
        }
        if (s.length() > startIndex + 1 && MessageEncoding.isValid((s.charAt(startIndex) - 48) * 10 + (s.charAt(startIndex + 1) - 48))) {
            answer += MessageEncoding.waysbyBruteForce(s, startIndex + 2);
        }
        return answer;
    }

    public static boolean isValid(int i) {
        if (i > 0 && i < 27) {
            return true;
        }
        return false;
    }
}