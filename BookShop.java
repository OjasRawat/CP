import java.io.*;
import java.util.*;

public class BookShop {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n = nextInt();
        int x = nextInt();

        int[] price = new int[n];
        for (int i = 0; i<n; i++){
            price[i]=nextInt();
        }

        int[] page = new int[n];
        for (int i = 0; i<n; i++) {
            page[i]=nextInt();
        }

        int[][] dp = new int[n][x+1];
        for (int i=0; i<=x; i++){
            if (i>=price[0]) dp[0][i]=page[0];
        }

        for (int i =1; i<n; i++){
            for (int j = 0; j<=x; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-price[i]>=0) dp[i][j]= Math.max(dp[i][j], dp[i-1][j-price[i]]+page[i]);
            }
        }

        out.println(dp[n-1][x]);

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