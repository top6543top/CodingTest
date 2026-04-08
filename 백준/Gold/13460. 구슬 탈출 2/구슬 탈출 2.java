import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] board;
    static int oy, ox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') { ry = i; rx = j; }
                else if (board[i][j] == 'B') { by = i; bx = j; }
                else if (board[i][j] == 'O') { oy = i; ox = j; }
            }
        }

        System.out.println(bfs(ry, rx, by, bx));
    }

    static int bfs(int ry, int rx, int by, int bx) {
        boolean[][][][] visited = new boolean[n][m][n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ry, rx, by, bx, 0});
        visited[ry][rx][by][bx] = true;

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cry = cur[0], crx = cur[1], cby = cur[2], cbx = cur[3], cnt = cur[4];

            if (cnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int[] nr = roll(cry, crx, dy[d], dx[d]);
                int[] nb = roll(cby, cbx, dy[d], dx[d]);

                int nry = nr[0], nrx = nr[1];
                int nby = nb[0], nbx = nb[1];
                boolean rIn = nr[2] == 1;
                boolean bIn = nb[2] == 1; 

                if (bIn) continue;

                if (rIn) return cnt + 1;

                if (nry == nby && nrx == nbx) {
                    int rDist = Math.abs(nry - cry) + Math.abs(nrx - crx);
                    int bDist = Math.abs(nby - cby) + Math.abs(nbx - cbx);
                    if (rDist > bDist) {
                        nry -= dy[d];
                        nrx -= dx[d];
                    } else {
                        nby -= dy[d];
                        nbx -= dx[d];
                    }
                }

                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new int[]{nry, nrx, nby, nbx, cnt + 1});
                }
            }
        }

        return -1;
    }

    static int[] roll(int y, int x, int dy, int dx) {
        while (true) {
            int ny = y + dy;
            int nx = x + dx;

            if (ny == oy && nx == ox) {
                return new int[]{ny, nx, 1};
            }

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx] == '#') {
                return new int[]{y, x, 0};
            }

            y = ny;
            x = nx;
        }
    }
}