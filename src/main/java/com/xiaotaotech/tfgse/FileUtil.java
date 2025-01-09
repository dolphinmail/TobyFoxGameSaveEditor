package com.xiaotaotech.tfgse;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public static String readLinesFromFile(String filepath, ArrayList<String> settings) throws IOException {
        String result = "";
        String line;
        File f = new File(filepath);
        if (!f.exists()) {
            System.out.println("文件" + f.getAbsolutePath() + "不存在！");
            return "";
        } else {
            FileInputStream fis = new FileInputStream(f);//创建对应f的文件输入流
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                //System.out.println( line );
                settings.add(line.trim());
                //result = result + line + "\n";
            }
            System.out.println(f.getName()+" 打开成功");
            return result;
        }
    }


    public static void writeLinesToFile(String filepath,ArrayList<String> settings)throws IOException
    {
        File f=new File(filepath);
        if(!f.exists())
        {
            f.createNewFile();
            System.out.println("文件"+f.getPath()+"已创建");
        }
        FileOutputStream fos=new FileOutputStream(f);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        for(int i=0;i<settings.size();i++)
        {
            bw.write(settings.get(i)+" ");
            bw.newLine();
        }
        System.out.println(f.getName()+" 保存成功");
        bw.close();
        osw.close();
        fos.close();
    }
}
