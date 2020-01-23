package com.mine.core.datastructure.array;

class CoinFlip {
	static boolean heads() {
		return Math.random() < 0.5;
	}

	public static void main(String[] args) {
		int i, j, cnt;
		int N = 32;
		int M = 100000;
		int[] f = new int[N + 1];
		for (j = 0; j <= N; j++)
			f[j] = 0;
		for (i = 0; i < M; i++, f[cnt]++)
			for (cnt = 0, j = 0; j <= N; j++)
				if (heads())
					cnt++;
		for (j = 0; j <= N; j++) {
			if (f[j] == 0)
				System.out.print(j+": .");
			for (i = 0; i < f[j]; i += 10) {
				if(i == 0) {
					System.out.print(j+": ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
