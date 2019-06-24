package ru.job4j.inputoutput;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void files() {
        String tmp = System.getProperty("java.io.tmpdir");
        tmp = tmp + "/tmpiodir";
        try {

            new File(tmp + "/dir1/dir1_1/").mkdirs();
            new File(tmp + "/dir1/dir1_2/").mkdirs();
            new File(tmp + "/dir2/dir2_1/").mkdirs();

            File txt1 = new File(tmp + "//txt1.txt");
            txt1.createNewFile();


            File bmp1 = new File(tmp + "/bmp1.bmp");
            bmp1.createNewFile();

            File txt2 = new File(tmp + "/txt2.txt");
            txt2.createNewFile();

            File xls1 = new File(tmp + "/xls1.xlsx");
            xls1.createNewFile();

            File txt3 = new File(tmp + "/dir1//dir1_1/txt3.txt");
            txt3.createNewFile();


            File xls2 = new File(tmp + "/dir1/dir1_1/xls2.xlsx");
            xls2.createNewFile();

            File xls3 = new File(tmp + "/dir1/dir1_2/xls3.xlsx");
            xls3.createNewFile();

            File bmp2 = new File(tmp + "/dir2/bmp2.bmp");
            bmp2.createNewFile();

            File doc2 = new File(tmp + "/dir2/doc2.docx");
            doc2.createNewFile();

            File doc1 = new File(tmp + "/dir1//dir1_1/doc1.docx");
            doc1.createNewFile();

            File bmp3 = new File(tmp + "/dir2/dir2_1/bmp3.bmp");
            bmp3.createNewFile();

            File xls4 = new File(tmp + "/dir2/dir2_1/xls4.xlsx");
            xls4.createNewFile();


        Search search = new Search();
        List<String> exts = new ArrayList<>();
//        exts.add("txt");
//        exts.add("bmp");
        exts.add("docx");
        exts.add("xlsx");
        List<File> exp = new ArrayList<>();
        exp.add(xls1);
        exp.add(doc1);
        exp.add(xls2);
        exp.add(xls3);
        exp.add(doc2);
        exp.add(xls4);
        List<File> list = search.files(tmp, exts);
       assertEquals(exp, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}