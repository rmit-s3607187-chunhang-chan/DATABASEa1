import java.io.*;

public class dbquery {

    private static int pagesize;
    private static String find;

    public static void main(String[] args) throws IOException {

       if(args.length != 2){
            System.out.println("java dbload text pagesizefile");
        }else{

            if(isStringInt(args[1])){
                find = args[0];
                readd();
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

    private static void readd() throws IOException{
        //System.out.println("heap."+ Integer.toString(pagesize));
        DataInputStream in = new DataInputStream(new FileInputStream("heap."+ Integer.toString(pagesize)));


        StringBuilder sb = new StringBuilder();
        int ch;
// READS CHARACTER PER CHARACTER
        for (int i = 0; i < 10000; i++) {
            while (true){


                ch = in.read();

                if (ch <= 0){
                    break;
                }else{

                    if(ch == 5){            // 5 is my delimiter
                        if(sb.toString().toLowerCase().contains(find.toLowerCase())){
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
