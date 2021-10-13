package File;

import java.io.File;

public class Exercise6 {

    public static void deleteAll(String path, String[] extensions) {
        File dir = new File(path);
        if (dir.exists()) {
            if (dir.isFile()) {
                for (String extension : extensions) {
                    if (dir.getName().endsWith("." + extension)) {
                        dir.delete();
                    }
                }
            }
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        deleteAll(file.getAbsolutePath(), extensions);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] extensions = { "txt", "pdf", "docx", "pptx" };
        String path = "D:\\NLU\\STUDY\\2021 - 2022\\Semester 1\\Network Programming\\Test - Copy";
        deleteAll(path, extensions);
    }
}
