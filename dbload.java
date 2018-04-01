

import java.io.*;


public class dbload {
    
    private static String filelocationz;
    private static int pagesize;



    public static void main(String[] args) throws IOException {

        if(args.length != 3){
            System.out.println("java dbload -p pagesize datafile");
        }else{
            if(!args[0].equals("-p")){
                System.out.println("java dbload -p pagesize datafile");
            }else{
                if(isStringInt(args[1])){
                    filelocationz = args[2];
                    loadCSV();
                }else{
                    System.out.println("java dbload -p pagesize datafile");
                }
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


    private static void loadCSV() throws IOException {


        try {
            BufferedReader br = new BufferedReader(new FileReader(filelocationz));
            String line;


            DataOutputStream dataOutputStream =
                    new DataOutputStream(
                            new FileOutputStream("heap." + pagesize));

            //StringBuilder builder;
            while ((line = br.readLine()) != null) {
                
                String result[] = line.split("\t");

                for(int j=0; j<result.length;j++){
                    byte[] byt = "".getBytes();

                    if(result.length<=2 ){
                        byt= result[j].getBytes();
                    }
                    if(result.length>=3){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=4){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=5){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=6){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=7){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=8){
                        byt = result[j].getBytes();
                    }
                    if(result.length>=9){
                        byt = result[j].getBytes();
                    }

                    if(byt.length != 0) {
                        for (int i = 0; i < byt.length; i++) {

                            dataOutputStream.writeShort(byt[i]);
                        }
                    }
                    dataOutputStream.writeInt(0);
                }

            }

            //close the output stream
            dataOutputStream.write(10);
            dataOutputStream.close();
            br.close();

        }catch (Exception ex){
            System.out.println("File Not Found");
        }

    }

}
