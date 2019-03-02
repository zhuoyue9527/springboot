package com.zhuo.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

public class PDFTest {

	private  static  int al[] = new  int[10];
	
	@Test
	public void test() {
		//168888
		System.out.println(8+8+"88"+8+8);
		String ss = "adfg";
		char[] ar = ss.toCharArray();
		al[0]=2;
		al[1]=3;
		al[2]=4;
		al[3]=5;
		al[4]=1;
		al[5]=6;
		al[6]=7;
		al[7]=8;
		al[8]=9;
		al[9]=10;
		System.out.println(Arrays.toString(al));
		for(int i =0 ;i<al.length ;i++) {
			for(int j=i+1;j<al.length ;j++) {
				if(al[i] > al[j]) {
					int t = al[i] ;
					al[i] = al[j] ;
					al[j] = t;
				}
			}
		}
		System.out.println(Arrays.toString(al));
		
	}
	
	public static void main(String[] args) {
		
        try {
            // 是否排序
            boolean sort = false;
            // 开始提取页数
            int startPage = 1;
            // 结束提取页数
            int endPage = 1;
            String content = null;
            PrintWriter writer = null;
            //pdf文本路径
            String path = "F:/配货项目资料/test2.pdf";
            //输出txt文本路径
            String target="F:/配货项目资料/test2.txt";
            PDDocument document = PDDocument.load(new File(path));
            PDFTextStripper pts = new PDFTextStripper();
            endPage = document.getNumberOfPages();
            System.out.println("Total Page: " + endPage);
            pts.setStartPage(startPage);
            pts.setEndPage(endPage);
            try {
                //content就是从pdf中解析出来的文本
                content = pts.getText(document);
                writer = new PrintWriter(new FileOutputStream(target));
                writer.write(content);// 写入文件内容
                writer.flush();
                writer.close();
            } catch (Exception e) {
                throw e;
            }finally {
                if (null != document)
                    document.close();
            }
            System.out.println("Get PDF Content ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
