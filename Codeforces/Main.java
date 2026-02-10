
import java.io.*;
import java.util.*;

public class Main {

    public static long compute(long[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                flag = false;
            }
        }
        if (flag) {
            return 0;
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            long l = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                long r = arr[j];
                min = Math.min(min, 1 + r - (r + l + 1) / 2);
            }
        }
        return (min == Long.MAX_VALUE || min < 0) ? 0 : min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }
            sb.append(compute(arr));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
