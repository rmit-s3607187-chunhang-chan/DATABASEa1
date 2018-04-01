import java.io.*;

public class dbquery {

    private static int pagesize;

    public static void main(String[] args) throws IOException {

       if(args.length != 2){
            System.out.println("java dbload text pagesize");
        }else{

            if(isStringInt(args[2])){
                readd(args[0]);
            }else{
                System.out.println("java dbload text pagesize");
            }

        }

    }

    private static boolean isStringInt(String s)
    {
        try
        {
            pagesize = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    private static void readd(String name) throws IOException{

        DataInputStream test = new DataInputStream(new FileInputStream("./heap.1024"));


        StringBuilder sb = new StringBuilder();
        int ch;

        for (int i = 0; i < 250; i++) {
            while (true){

                ch = test.read();

                if (ch <= 0){
                    break;
                }else{
                    if(ch == 5){            // 5 is my delimiter
                        if(sb.toString().toLowerCase().contains(name.toLowerCase())){
                            System.out.println(sb.toString());
                        }
                        sb.setLength(0);            // reset
                    }else{

                        if(ch != 10){           // 10 special character for a new page.
                            i=0;
                            sb.append((char) ch);
                        }
                    }
                }
            }
        }

    }
}
