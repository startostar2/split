package Split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class split2 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\beizhu.txt");
        BufferedReader reader = null;
        String temp = null;
        int line = 1;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                if (temp.contains("'")){
                    String[] split = temp.split("'");
                    String s = split[1];
                    System.out.println(s);
                    line++;
                }
            }
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
