import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ConcertTickets {
    static final int MINV = Integer.MIN_VALUE;
    static final int MAXV = Integer.MAX_VALUE;
    static final int MOD = 1_000_000_007;

    static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();

        int[] a= new int[n];
        int[][] b= new int[m][2];
        for (int i = 0; i<n; i++){
            a[i]=nextInt();

        }

        for (int i = 0; i<m; i++) {
            b[i][0]=nextInt();
            b[i][1] = i;
        }


        Arrays.sort(a);
        Arrays.sort(b, (l, mm)->Integer.compare(l[0], mm[0]));

        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        int l = 0 ,h = 0;
        while (l<n && h <m) {
            if (b[h][0] >= a[l]) {
                ans[b[h][1]]=a[l];
                l++;
                h++;

            } else if (b[h][0] < a[l]) {
                h++;
            }
        }

        for (int e: ans) {
            out.println(e+" ");
        }
//        out.println();


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