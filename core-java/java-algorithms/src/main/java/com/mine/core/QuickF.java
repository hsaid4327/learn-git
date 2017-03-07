package com.mine.core;
//http://www.cs.princeton.edu/~rs/Algs3.java1-4/code.txt

public class QuickF {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int id[] = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		for (In.init(); !In.empty();) {
			int p = In.getInt(), q = In.getInt();
			int t = id[p];
			if (t == id[q])
				continue;
			for (int i = 0; i < N; i++)
				if (id[i] == t)
					id[i] = id[q];
			Out.println(" " + p + " " + q);
		}
	}
}