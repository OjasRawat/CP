import java.io.*;
import java.util.*;

public class DistinctNumbers {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i<n; i++) a[i]=nextInt();

        Arrays.sort(a);
        int cnt = 1;
        for (int i = 1; i<n; i++) {
            if (a[i] != a[i-1]) cnt++;
        }
        out.println(cnt);

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