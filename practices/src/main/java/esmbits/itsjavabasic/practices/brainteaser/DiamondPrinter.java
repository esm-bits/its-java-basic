package esmbits.itsjavabasic.practices.brainteaser;

public class DiamondPrinter {

    public static void main(String[] args) {

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
    	int countX;
    	int countY;
    	int size = Integer.parseInt(args[0]);
    	String linePrint = new String();

    	// 中心点から距離で出力の判定を行う
    	for (countY = 1; countY <= size * 2 - 1; countY++) {
        	for (countX = 1; countX <= size * 2 - 1; countX++) {
        		if (Math.abs(countX - size) + Math.abs(countY - size) <= size - 1) {
           			linePrint = linePrint + "*";
           		} else {
           			linePrint = linePrint + " ";
        		}
        	}

    		System.out.println(linePrint);
    		linePrint = new String();
    	}

    }
}
