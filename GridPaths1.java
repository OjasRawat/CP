import java.io.*;
import java.util.*;

public class GridPaths1 {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n = nextInt();
        char[][] mat = new char[n][n];
        for (int i = 0; i<n; i++) {
            mat[i]=next().toCharArray();
        }


        long[][] dp = new long[n][n];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (i==0 && j==0) {
                    if (mat[i][j]=='*') {
                        dp[i][j]=0;
                    } else dp[i][j] = 1;
                    continue;
                }
                if (mat[i][j]=='*') continue;
                if (i-1>=0 ) dp[i][j] += dp[i-1][j];
                if (j-1>=0) dp[i][j] += dp[i][j-1];
                dp[i][j] %= MOD;
            }
        }

        out.println(dp[n-1][n-1]);

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