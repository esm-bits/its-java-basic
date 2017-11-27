package esmbits.itsjavabasic.practices.brainteaser.example;

public class DiamondPrinter {

    /**
     * 指定されたスペース数とドット数の文字列を返す.
     * @param space スペース数
     * @param dot ドット数
     * @return 指定されたスペース数とドット数の文字列
     */
    private String createLine(int space, int dot) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < space; i++) {
            buf.append(" ");
        }
        for (int i = 0; i < dot; i++) {
            buf.append("*");
        }
        return buf.toString();
    }

    /**
     * 指定の高さのひし形を文字列で返す.
     * @param height 高さ
     * @return 指定の高さのひし形の文字列
     */
    private String createDiamond(int height) {

        int lineCount = height * 2 - 1;     // ひし形全体の行数
        String[] lowerHalf = new String[height - 1];    // ひし形の半分保持用
        String newline = System.getProperty("line.separator");
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < lineCount; i++) {
            String line = null;
            if (i < height - 1) {
                // 上半分
                int space = height - i - 1;
                int dot = 2 * (i + 1) - 1;
                line = createLine(space, dot);
                // 後半で使うために保持しておく
                lowerHalf[lowerHalf.length - i - 1] = line;
            } else if (i == height - 1) {
                // 真ん中
                line = createLine(0, height * 2 -1);
            } else {
                // 下半分
                line = lowerHalf[i - height];
            }
            buf.append(line).append(newline);
        }
        return buf.toString();
    }

    public static void main(String... args) {
        int height = 3;
        System.out.print(new DiamondPrinter().createDiamond(height));
    }
}
