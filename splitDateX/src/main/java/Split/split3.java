package Split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class split3 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Downloads\\2\\11.sql");
        BufferedReader reader = null;
        BufferedReader reader1 = null;
        String temp = null;
        String temp1 = null;
        int line = 1;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
            System.out.println(temp + ";");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        /*
        try {
            while ((temp = reader.readLine()) != null) {
                String[] split = temp.split("_");
                if (split[0].contains("operator")){
                    System.out.println(split[1]);

                    while ((temp1 = reader1.readLine()) != null) {
                        if (temp1.contains("'")){
                            String[] split1 = temp1.split("'");
                            System.out.println(split1[1]);
                        }
                    }


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
           */
    }
}
