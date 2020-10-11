import java.util.*;
public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.next();
            char[] chars = strs.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'w' && chars[i] <= 'z') {
                    chars[i] = (char)(chars[i] - 22);
                } else if (chars[i] >= 'W' && chars[i] <= 'Z') {
                    chars[i] = (char)(chars[i] - 22);
                } else if ((chars[i] >= 'a' && chars[i] < 'w') || (chars[i] >= 'A' && chars[i] < 'W')) {
                    chars[i] = (char)(chars[i] + 4);
                } else if (chars[i] >= '0' && chars[i] <= '7') {
                    chars[i] = (char)(chars[i] + 2);
                } else if (chars[i] == '8') {
                    chars[i] = '0';
                } else if (chars[i] == '9') {
                    chars[i] = '1';
                }
            }
            for (int j = chars.length - 1; j >= 0; j--) {
                System.out.print(chars[j]);
            }
        }
    }

    static int ret = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char key = sc.next().charAt(0);
            int n = sc.nextInt();
            char[][] ch = new char[n][2];
            for (int i = 0; i < ch.length; i++) {
                String[] s = sc.next().split("->");
                ch[i][0] = s[0].charAt(0);
                ch[i][1] = s[1].charAt(0);
            }
            ret = 0;
            HashSet<Character> set = new HashSet<>();
            set.add(key);
            dfs(ch,key,set);
            System.out.println(ret);

        }
    }

    private static void dfs(char[][] ch, char key,HashSet<Character> set) {
        for (int i = 0; i < ch.length; i++) {
            if(key == ch[i][0] && !set.contains(ch[i][1])) {
                set.add(ch[i][1]);
                ret++;
                dfs(ch,ch[i][1],set);
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(func(n,m));
        }
    }

    private static int func(int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i == 1 || j == 1) {
                    dp[i][j] = 1;
                }else if(i == j) {
                    dp[i][j] = 1 + dp[i][j - 1];
                }else if (i < j) {
                    dp[i][j] = dp[i][i];
                }else {
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}

