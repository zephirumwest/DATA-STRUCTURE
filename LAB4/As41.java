public class As41 {
    private static int[] visit;
    private static int[] order;
    private static MyArrayList<int[]> graph;
    private static MyArrayList<int[]> result;

    public static boolean[] getRed(int n, int m, int[] x, int[] y) {
        // 그래프 초기화
        graph = new MyArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new int[0]);
        }
        for (int i = 0; i < m; i++) {
            int u = x[i];
            int v = y[i];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 필요한 변수 초기화
        visit = new int[n + 1];
        order = new int[n + 1];
        result = new MyArrayList<>();

        // DFS로 방문 순서와 단절선 탐색
        dfs(1, -1, 1);

        // 결과 반환
        boolean[] redundant = new boolean[m];
        for (int[] edge : result) {
            int u = edge[0];
            int v = edge[1];
            int index = findEdgeIndex(u, v, x, y);
            redundant[index] = true;
        }
        return redundant;
    }

    private static void dfs(int curr, int prev, int count) {
        visit[curr] = prev;
        order[curr] = count;

        for (int next : graph.get(curr)) {
            if (visit[next] == 0) {
                dfs(next, curr, count + 1);
            } else if (next != prev && order[curr] > order[next]) {
                order[curr] = order[next];
            }
        }

        if (prev != -1 && order[curr] == count) {
            result.add(new int[]{Math.min(curr, prev), Math.max(curr, prev)});
        }
    }

    private static int findEdgeIndex(int u, int v, int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if ((x[i] == u && y[i] == v) || (x[i] == v && y[i] == u)) {
                return i;
            }
        }
        return -1;
    }
}
