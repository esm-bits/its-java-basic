package esmbits.itsjavabasic.practices.brainteaser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DiamondPrinter {

	/**
	 * ひし形(◆)を出力します.
	 * 
	 * @param args 大きさ
	 */
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
    	
    	// i行目
    	// 大きさ：n
    	// 空白：n-i
    	// *:i*2-1
    	
    	// 大きさをコンソールで入力
    	InputStreamReader in = new InputStreamReader(System.in);
    	BufferedReader reader = new BufferedReader(in);
    	
    	// int size = 5;
    	int size = 0;
		try {
			size = Integer.parseInt(reader.readLine());
			
		} catch (NumberFormatException e) {
			System.out.println(e);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
    	System.out.println("大きさ：" + size);
    	
    	// ひし形の上半分を格納する
    	List<String> lines = new ArrayList<>();
    	
    	// ひし形の上半分を作成する
    	for (int i = 1; i <= size; i++) {
    		
    		lines.add(createLine(size, i));
    	}
    	
    	// ひし形を出力する
    	// 上半分を出力
    	for (int i = 0; i < size; i++) {
    		System.out.println(lines.get(i));
    	}
    	
    	// 下半分を出力
    	for (int i = size - 2; i >= 0; i--) {
    		System.out.println(lines.get(i));
    	}
    	
    }
    
    /**
     * ひし形の1行分（空白+アスタリスク）を作成します.
     * 
     * @param size 大きさ
     * @param lineNumber 行数
     * @return ひし形の1行分
     */
    private static String createLine(int size, int lineNumber) {
    	
    	return createSpace(size, lineNumber) + createAsterisk(size, lineNumber);
    }
    
    /**
     * 1行分の空白を作成します.
     * 
     * @param size 大きさ
     * @param lineNumber 行数
     * @return 空白
     */
    private static String createSpace(int size, int lineNumber) {
    	
    	int times = size - lineNumber;
    	String space = "";
    	
    	for (int i = 0; i < times; i++) {
    		
    		space += " ";
    	}
    	
    	return space;
    }
    
    /**
     * 1行分のアスタリスク（ひし形部分）を作成します.
     * 
     * @param size 大きさ
     * @param lineNumber 行数
     * @return アスタリスク（ひし形部分）
     */
    private static String createAsterisk(int size, int lineNumber) {
    	
    	int times = lineNumber * 2 - 1;
    	String space = "";
    	
    	for (int i = 0; i < times; i++) {
    		
    		space += "*";
    	}
    	
    	return space;
    }
    
    
}
