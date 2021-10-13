package IO;

import java.io.*;

public class Exercise8 {

    public static boolean fileCopy(String sFile, String destFile, boolean moved) {
        File file = new File(sFile);
        if (file.exists() && file.isFile()) {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sFile));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))) {
                int length;
                long start = System.currentTimeMillis();
                while ((length = bis.read()) != -1) {
                    bos.write(length);
                }
                System.out.println("Copy/move time: " + (System.currentTimeMillis() - start) + "ms");
                bis.close();
                bos.close();
                if (moved) {
                    file.delete();
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String sFile = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Test - Copy";
        String destFile = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Test - Copy1";
        System.out.println(fileCopy(sFile, destFile, false) ? "Successfully" : "Fail");
    }
}
