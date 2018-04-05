package PrintM;

import org.junit.Test;

public class PrintM_duogeshu {

	/*
	 * 
	 * 3 7 2 4 6 8 1 5 9 平面图形(二维数组)
	 * 
	 */
	public static void test1(int num) {

		int height = (num / 4) + 1; // 4条边

		int atr[][] = new int[height][num];
		// 产生9个数，放入对应位置
		boolean flag = false; // false代表横坐标在减小，true代表在增大
		// 初始位置
		int x = height-1;
		int y = 0;
		for (int i = 1; i <= num; i++) {

			// 放入第一个数
			atr[x][y] = i;
			// y始终在增大
			y++;

			if (!flag) { // 如果x在减小让其自减
				x--;
			}

			if (flag) {
				x++;
			}

			if (x < 0) { // x减到0，再减为-1
				flag = true;
				x = x + 2;
			}

			if (x > height-1) { // x加2，再加为3
				flag = false;
				x = x - 2;
			}
		}

		for (int i = 0; i < atr.length; i++) {
			for (int j = 0; j < atr[i].length; j++) {
				if (atr[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(atr[i][j]);
				}
			}
			System.out.println();
		}

	}
	
	@Test
	public void test(){
		PrintM_duogeshu.test1(25);
	}
}
