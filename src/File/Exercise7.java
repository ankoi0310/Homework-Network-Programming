package File;

import java.io.File;

public class Exercise7 {

    public static void copyAll(String sDir, String dDir, String[] extensions) {
        File src = new File(sDir);
        if (!src.exists()) {
            throw new RuntimeException("Not existed");
        }
        File dest = new File(dDir + "\\" + src.getName());
        dest.mkdirs();
        if (src.listFiles() != null) {
            for (File file : src.listFiles()) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
