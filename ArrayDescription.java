import java.io.*;
import java.util.*;

public class ArrayDescription {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n  = nextInt();
        int m = nextInt();

        int[] a = new int[n];
        for (int i = 0; i<n; i++) {
            a[i]=nextInt();
        }

        long[][] dp = new long[n][m+1];
        if (a[0]==0) {
            for (int i = 1; i<=m; i++) {
                dp[0][i]=1;
            }
        } else {
            dp[0][a[0]] = 1;
        }

        for (int i = 1; i<n; i++) {
            if (a[i]==0) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    if (j+1<=m) dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= MOD;
                }
            } else {
                dp[i][a[i]] = dp[i-1][a[i]-1] + dp[i-1][a[i]];
                if (a[i]+1<=m) dp[i][a[i]]+=dp[i-1][a[i]+1];

                dp[i][a[i]]%=MOD;
            }


        }

        long ans = 0;
        for (int i = 0; i<=m; i++) {
            ans += dp[n-1][i];
            ans %=MOD;
        }



out.println(ans);




    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String nextLine() throws IOException {
        st = null;
        return in.readLine();
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            int T = 1;
//            T = nextInt();
            while (T-- > 0) solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
        out.flush();
    }
}