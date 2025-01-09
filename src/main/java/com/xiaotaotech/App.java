package com.xiaotaotech;

import com.xiaotaotech.tfgse.FileUtil;
import com.xiaotaotech.tfgse.jframe.MainJFrame;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    /*    public static void main( String[] args )
        {
            System.out.println( "Hello World!" );
        }*/
    public static ArrayList<String> settings = new ArrayList<String>();
    public static void main(String args[]) throws IOException {
        //FileIO fio = new FileIO();
        //System.out.print(fio.readLinesFromFile("WebRoot\\accessed_files\\test.txt"));

        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame();
            System.out.println("启动成功！");
        });


/*        String filepath1="D:\\software\\游戏\\三角符文\\存档\\2\\filech1_0";
        String fc= FileUtil.readLinesFromFile(filepath1,settings);

        String filepath2="D:\\software\\游戏\\三角符文\\存档\\2\\filech1_1";

        settings.set(0,"dolphin");
        settings.set(1,"dolphin");
        settings.set(70,"999");
        settings.set(71,"999");
        //settings.set(72,"999");
        FileUtil.writeLinesToFile(filepath2,settings);
        fc= FileUtil.readLinesFromFile(filepath2,settings);

        for (int i = 0; i < settings.size(); i++) {
            System.out.println(settings.get(i));
        }*/
    }




}
