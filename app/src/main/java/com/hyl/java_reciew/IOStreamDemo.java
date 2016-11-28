package com.hyl.java_reciew;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.Types.ARRAY;

/**
 * 1. 作用  练习  输入流和输出流
 * 2. 作者 侯永亮
 * 3. 时间 2016/11/28.
 */

public class IOStreamDemo {
    /*判断文件是否存在，不存在创建文件*/
    public static void isFileExist(String path, String filename) {
        File file = new File(path + filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /*判断文件夹是否存在，不存在创建文件夹*/
    public static void isFilesExist(String path, String filename) {
        File file = new File(path + filename);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /*字节输入流转字符串 ByteArrayOutputStream*/
    public static String stream2String(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                baos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    /*字节输入流转字符串 bufferedReader */
    public static String streamToString(InputStream inputStream) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
            br.close();/*关流*/
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    /*复制文件  将文件复制到文件夹中*/
    public static void copyFile(File filePath, File file) {
        try {
            if (filePath.isDirectory() && file.isFile()) {/*如果前面为文件，后面为复制的文件*/
            /*字符读取流*/
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            /*拼接复制后的文件地址*/
                String st = filePath.getPath().replace("\\", "/") + "/" + file.getName();
//            System.out.println(st);
                PrintWriter pw = new PrintWriter(st);
                String length = "";
                while ((length = br.readLine()) != null) {
                    pw.println(length);
                    pw.flush();
                }
                pw.close();
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*判断是否有文件，将存在将文件复制，不存在创建文件*/
    public static void fileCopy(File sourfile, File targetfile, String name) {
        try {
            if (sourfile != null && sourfile.isFile()) {
                FileInputStream fis = new FileInputStream(sourfile);
                FileOutputStream fos = new FileOutputStream(targetfile.getPath().replace("\\", "/") + "/" + name);
                int count = 0;
                byte[] b = new byte[1024];
                while ((count = fis.read(b)) > 0) {
                    fos.write(b, 0, count);
                    fos.flush();
                }
                fos.close();
                fis.close();
            } else if (sourfile == null) {
                File file = new File(targetfile.getPath().replace("\\", "/") + "/" + name);
                file.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*判断是否包含文件,若包含文件则将文件存入集合中  采用递归的方式*/
    public static void fileFind(File sourfile, String name, List<File> list) {
        if (sourfile.isDirectory() && list != null) {
            File[] files = sourfile.listFiles();//获取元文件的文件和文件夹
            if (files != null && files.length > 0) { //若文件数组有数据
                for (File file : files) {
                    if (file.isDirectory()) {
                        fileFind(file, name, list);
                    } else if (file.isFile()) {
                        if (file.getName().equals(name)) {
                            list.add(file);
                        }
                    }
                }
            }
        }

    }

    /*查找以。。结尾的文件*/
    public static void search(File sourFile, String endName, List<File> list) {
        File[] files = sourFile.listFiles();    // 查找文件下的所有内容
        if (files != null && files.length > 0) {    // 判断，如果文件集合不为空，则遍历集合
            for (File file : files) {
                if (file.isDirectory()) {// 如果为文件夹
                    // find(file,endName,list);
                    search(file, endName, list);
                } else if (file.isFile()) {    // 如果为文件
                    if (file.getName().endsWith(endName)) {// 判断是否已endname结尾
                        list.add(file);
                    }
                }
            }
        }
    }

    /*获取文件的大小集合*/
    public static List<String> getFileLength(List<File> list) {
        List<String> fileName = new ArrayList<String>();
        if (list != null && list.size() > 0) {
            for (File file : list) {//循环遍历
                fileName.add("文件名为" + file + "大小为" + file.length() / 1024 / 1024 + "兆");
            }
        }
        return fileName;
    }

//    /*文件名过滤*/
//    public static List<String> ListFileNameFileter(File file) {
//        if (file.isDirectory()) {
//            String[] files = file.list(new FilenameFilter() {//使用匿名内部类的方法
//
//                @Override
//                public boolean accept(File dir, String name) {
//                    // TODO Auto-generated method stub
//                    //System.out.println("dir:"+dir+"name....."+name);//测试说明dir表示指定目录,name表示指定目录的名称
//                    return name.endsWith(".java");//通过匿名内部类的返回值来控制指定目录下面的文件和文件夹的显示，只显示.java文件
//                }
//            });
//
//            return Arrays.asList(files);
//        }
//        return null;
//    }

    /*现在要求输入一个文件的目录，之后将里面所有的备份文件删除，备份文件都是以“.bak”或".BAK"结尾，过滤文件类型为.bak文件*/
    public static void ListFileFileter(File dir, final String endName) {
        if (dir.exists()) {
            //匿名内部类，把FileFilter接口对象作为参数
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isDirectory()) {
                        return true;
                    }
                    String name = pathname.getName();//获取文件的名称E:\复件 demodir\Learn\sgim_piccell.v1.bin.bak
                    System.out.println("****************" + pathname);
                    return name.endsWith(endName) ;//过滤文件类型为.bak或者.BAK文件，而不包含.BAK或者.bak的文件
                }
            });
            //深度遍历文件，递归
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {//如果遍历到的是文件，直接删除
                    files[i].delete();
                } else {//还是目录，继续遍历，直到是文件，再删除
                    ListFileFileter(files[i],endName);
                }
            }
        } else {
            throw new RuntimeException("操作的文件或者目录不存在！");
        }
    }

    /*使用二分法*/

}
