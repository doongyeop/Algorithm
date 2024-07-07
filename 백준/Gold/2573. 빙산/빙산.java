import java.util.Scanner;

public class Main {

	static int n, m, iceberg[][];
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		iceberg = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				iceberg[i][j] = sc.nextInt();
			}
		}

		int year = 0;
		while (true) {
			int cnt = 0;
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (iceberg[i][j] != 0 && !visited[i][j]) {
						cnt++;
						separate(i, j);
					}
				}
			} // dfs

			melt();

			if (cnt > 1) {
				break;
			} else if (cnt == 0) { // 모든 빙산이 녹았을 때
				year = 0;
				break;
			}
			year++;
		}

		System.out.println(year);
		sc.close();
	}

	static void melt() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (iceberg[i][j] != 0) {
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (0 <= nx && nx < n && 0 <= ny && ny < m && iceberg[nx][ny] == 0) {
							count++;
						}
					}
					temp[i][j] = Math.max(iceberg[i][j] - count, 0);
				}
			}
		}
		iceberg = temp;
	}

	static void separate(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (iceberg[nx][ny] != 0 && !visited[nx][ny]) {
					separate(nx, ny);
				}
			}
		}
	} // separate
}
