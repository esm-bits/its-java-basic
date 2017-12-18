package esmbits.itsjavabasic.practices.brainteaser;

public class DiamondPrinter {


	private void printDia(int n) {
		int max = (n % 2) == 0 ? n+1 : n; // 最大幅
		int spaceCnt = 0; // 半角スペースの数
		int end = max / 2; // 終了条件

		for (int i = 0; i < max; i++) {
			if (i <= max / 2) { // 半分から上
				spaceCnt = (max / 2) - i;
				end++;
			} else { // 半分より下
				spaceCnt = i - (max / 2);
				end--;
			}

			for (int j = 0; j < end; j++) {
				System.out.print(j < spaceCnt ? " " : "*");
			}
			System.out.println();
		}
	}

    public static void main(String... args) {

        // コンソールにひし形(◆)を出力する.
        // 大きさは任意に変えられるようにする.

        // 大きさ:2
        //  *
        // ***
        //  *
        //
        // 大きさ:3
        //   *
        //  ***
        // *****
        //  ***
        //   *
//    	System.out.println(" *");
//    	System.out.println("***");
//    	System.out.println(" *");

    	int n = 1;
    	if (args.length != 0) {
    	  n = Integer.parseInt(args[0]);
    	}

    	new DiamondPrinter().printDia(n);
    }
}
