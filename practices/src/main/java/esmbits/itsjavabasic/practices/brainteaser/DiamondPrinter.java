package esmbits.itsjavabasic.practices.brainteaser;
import java.io.*;
public class DiamondPrinter {

    public static void main(String... args) {

        // コンソールにひし形(◆)を出力する.
        // 大きさは任意に変えられるようにする.

    	int maxlength;
    	maxlength =4;

    	//上半分
    	for (int i=1 ; i <= maxlength;i++) {
    	    lineout(i,maxlength);
    	}
    	//下半分
        for (int i=maxlength-1 ;1<=i ;i--) {
            lineout(i,maxlength);
        }
    }

    private static void lineout(int i,int maxlength){
        StringBuilder s = new StringBuilder();

        //左の空白
        for (int j=1; j <= maxlength-i;j++) {
            s.append(' ');
        }
        //*
        for (int j=1; j <=1+(2*(i-1));j++) {
            s.append('*');
        }
        //右の空白
        for (int j=1; j <= maxlength-i;j++) {
            s.append(' ');
        }

        System.out.println(s);
    }
//  System.out.println(s);

    // 大きさ:2   縦の長さ＝大きさ＋大きさ-１
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
    // 大きさ:4
    //    *        1      = 1 = 1+2*(1-1)  左側空白：3=4-1
    //   ***       1+2*1  = 3 = 1+2*(2-1)  左側空白：2=4-2
    //  *****      1+2*2  = 5 = 1+2*(3-1)  左側空白：1=4-3
    // *******     1+2*3  = 7 = 1+2*(4-1)  左側空白：0=4-4
    //  *****
    //   ***
    //    *


    // 対応したいこと
    // ・最初にスペースを埋めてreplaceできないか
    // ・上と下のロジックを変更せずにできないか
}
