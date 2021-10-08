package com.zab.sparsearray;

public class SparseArray {


	public static void main(String[] args) {

		// 1.二维数组转稀疏数组
		// 1.1创建一个二维数组
		int[][] chessArr1 = new int[11][11];

		// 0:表示没有旗子，1表示黑子，2表示蓝子
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;

		// 1.2输出二维数组
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		// 1.3遍历二维数组，得到有效数据个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("有效数据个数："+sum);

		// 1.4根据sum创建稀疏数组
		int[][] sparseArray = new int[sum + 1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;

		// 1.5将二维数组存到稀疏数组中
		int count = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArr1[i][j];
				}
			}
		}

		// 1.6 输出稀疏数组
		System.out.println("得到的稀疏数组是：");
		for (int[] row : sparseArray) {
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}

		// 2.稀疏数组转化为二维数组
		// 2.1根据稀疏数组创建原始二维数组
		int[][] chassArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];

		// 2.2输出原始数组
		System.out.println("原始数组：");
		for (int[] row : chassArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 2.3读取数据将数据存到二维数组
		for (int i = 1; i < sparseArray.length; i++) {
			chassArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		// 2.4输出恢复后的二维数组
		System.out.println("恢复后的二维数组：");
		for (int[] row : chassArr2) {
			for (int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	}
}
