package IO;

import java.io.*;

public class Exercise9 {
    public static boolean folderCopy(String sFolder, String destFolder, boolean moved) {
        File src = new File(sFolder);
        if (!src.exists()) {
            throw new RuntimeException("Not existed");
        }
        File dest = new File(destFolder + "\\" + src.getName());
        dest.mkdirs();
        if (src.listFiles() != null) {
            for (File file : src.listFiles()) {
                if (file.isFile()) {
                    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                         BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest.getAbsolutePath() + "\\" + file.getName()))) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = bis.read()) != -1) {
                            bos.write(length);
                        }
                        bis.close();
                        bos.close();
                        if (moved) {
                            file.delete();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else if (file.isDirectory()) {
                    folderCopy(file.getAbsolutePath(), dest.getAbsolutePath(), moved);
                }
            }
        }
        if (moved) {
            src.delete();
        }
        return true;
    }

    public static void main(String[] args) {
        String sFolder = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Test - Copy";
        String destFolder = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Test - Copy1";
        System.out.println(folderCopy(sFolder, destFolder, true) ? "Successfully" : "Fail");
    }
}
