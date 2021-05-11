package lesson10.examples;
/*
 * @(#)FileLoad.java 0.1 22/03/2010
 */
import java.io.*;

/**
 * Methods for read file
 *
 * @author TanT
 * @version 0.1  22/03/2010
 */
public class FileLoad {

    /**
     * Read file and return as string
     *
     * @param encoding the code file
     * @param file the file to reading
     * @throws java.io.IOException  if error open file
     * @return file to string
     */
    public static String loadFileAsString(File file, String encoding)
            throws IOException {

        InputStreamReader f=
                (encoding==null ? new FileReader(file):new InputStreamReader( new FileInputStream(file),encoding));

        StringBuffer sb= new StringBuffer();

        try {
            char[] buf= new char[1000];
            int len;
            while ((len=f.read(buf,0,buf.length))>=0) {
                sb.append(buf,0,len);
            }
            return sb.toString();
        }catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException: " + file + " exc: " + ex);
        } finally {
            try {f.close();} catch (Exception e) {};
        }

        return null;
    }
}