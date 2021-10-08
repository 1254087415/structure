	package com.zab.recursion;
	
	import java.io.OutputStream;
	
	public class MiGong {
		public static void main(String[] args) {
			int[][] list = new int[8][7];
			
			for (int i = 0; i < 7; i++) {
				list[0][i] = 1;
				list[7][i] = 1;
			}
			
			for (int i = 1; i < 7; i++) {
				list[i][0] = 1;
				list[i][6] = 1;
	    }
			list[3][1] = 1;
			list[3][2] = 1;
			
			sayWays(list, 1, 1);
			
			for (int[] ints : list) {
				for (int anInt : ints) {
					System.out.printf("%d" + " ",anInt);
				}
				System.out.println();
			}
			
		}
		
		/**
		 * 使用递归来给小球找路
		 * 0:无 1:可以走 2:走过了 4:走不通
		 * @param map 表示地图
		 * @param i 从地图的哪个位置出发
		 * @param j 从地图的哪个位置结束
		 * @return 是否走出地图
		 */
		public static boolean sayWays(int[][] map,int i, int j) {
			if (map[6][5] == 2) {
				return true;
			}
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (sayWays(map, i + 1, j)) {
					return true;
				} else if (sayWays(map, i, j + 1)) {
					return true;
				} else if (sayWays(map, i - 1, j)) {
					return true;
				} else if (sayWays(map, i, j - 1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}
