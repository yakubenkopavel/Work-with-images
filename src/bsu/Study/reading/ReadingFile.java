package bsu.Study.reading;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ReadingFile {
    private static BufferedImage bImage;

    public static BufferedImage read(String nameFile, String fileFormat){
        try{
            File file = new File(nameFile);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            bImage = ImageIO.read(file);
        }catch (FileNotFoundException e){
            System.out.println("rename a file");
        }
        catch (IOException e){
            System.out.println(e);
        }catch(Exception e){
            e.printStackTrace();
        }

        return bImage;
    }

    public static BufferedImage getBImage(){
        return bImage;
    }
}
