import java.io.*;
import java.util.*;

public class CoinComb2 {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n = nextInt();
        int x = nextInt();
        int[] a =new int[n];
        for (int i = 0; i<n ;i++) {
            a[i]=nextInt();
        }

        long[] dp = new long[x + 1];
        dp[0]= 1L;
            for (int coin: a) {
                for (int i = 1; i<=x; i++){
                if (i - coin >= 0)dp[i]+=dp[i-coin];

                dp[i]%=MOD;
            }
        }


        out.println(dp[x]);

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