package IO;

import java.io.*;

public class Exercise8 {
    public static boolean fileCopy(String sFile, String destFile, boolean moved) {
        File file = new File(sFile);
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new RuntimeException("This is not a file");
            }
            if (file.isFile()) {
                try (FileInputStream fis = new FileInputStream(sFile);
                     BufferedInputStream bis = new BufferedInputStream(fis);
                     FileOutputStream fos = new FileOutputStream(destFile);
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    long start = System.currentTimeMillis();
                    while ((length = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, length);
                    }
                    System.out.println("Copy/move time: " + (System.currentTimeMillis() - start) + "ms");
                    bis.close();
                    bos.close();
                    fis.close();
                    fos.close();
                    if (moved) {
                        boolean deleted = file.delete();
                        if (deleted) {
                            return true;
                        } else {
                            File dest = new File(destFile);
                            if (dest.exists()) {
                                dest.delete();
                                return false;
                            }
                        }
                    }
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String sFile = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Lab\\Net-Program-Exercise.docx";
        String destFile = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Lab\\Net-Program-Exercise Copy.docx";
        System.out.println(fileCopy(sFile, destFile, true) ? "Successfully" : "Fail");
    }
}
