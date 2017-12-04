package esmbits.itsjavabasic.practices.brainteaser;

public class DiamondPrinter {

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
        int i = 4;
        print(i);
    }

    private static void print(int size) {
        String str = "○";
        String space = "●";
        int length = size * 2 - 1;

        for(int i = 1; i <= length; i++) {
            String row = "";
            for(int j = 1; j <= length; j++) {
                if(Math.abs(j - size) + Math.abs(i - size) < size) {
                    row += str;
                } else {
                    row += space;
                }
            }
            System.out.println(row);
        }
    }
}
