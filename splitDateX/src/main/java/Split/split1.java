package Split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class split1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.txt");
        BufferedReader reader = null;
        String temp = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                String[] split = temp.split(",");
                for (int i = 0 ; i < split.length ;i++){
//                    System.out.println(split[i]);
                    String[] split1 = split[i].split("&");
//                    System.out.println(split1[0]);
                    System.out.println(split1.length);

                }



            }
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