package bsu.Study.rotate;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.text.ParseException;

public class RotateImage {
    private double m00 = 1;
    private double m01;
    private double m02;
    private double m10;
    private double m11 = 1;
    private double m12;

    private final double rads;
    private final double sin;
    private final double cos;
    private final int w;
    private final int h;

    private final BufferedImage rotatedImage;
    private final BufferedImage image;
    private int count = 0;


    public RotateImage(int theta, BufferedImage image){
        rads = Math.toRadians(theta);
        sin = Math.sin(rads);
        cos = Math.cos(rads);
        //w = (int) Math.floor(image.getWidth() * Math.abs(cos) + image.getHeight() * Math.abs(sin));
        //h = (int) Math.floor(image.getHeight() * Math.abs(cos) + image.getWidth() * Math.abs(sin));
        w = image.getWidth();
        h = image.getHeight();
        rotatedImage = new BufferedImage(w, h, image.getType());
        this.image = image;

        for(int i = 0; i < w; i++){
            for(int j =0; j < h; j++){
                rotatedImage.setRGB(i, j, 16777215);
            }
        }
    };

    public BufferedImage actionRotate(){
        //translate(w / 2, h / 2);
        rotate(rads, sin, cos);
        //translate(-image.getWidth() / 2, -image.getHeight() / 2);

        try{
            rotateImage();
        }catch (IndexOutOfBoundsException e){
            System.out.println("index out bound! " + e);
        }catch (ParseException e){
            System.out.println("exception " + e);
        }


        return rotatedImage;
    }

    private void rotateImage() throws ParseException{
        int x;
        int y;
        int x1;
        int y1;

        for(int j = 0; j < image.getHeight(); j++){
            for(int i = 0; i < image.getWidth(); i++){
                int board = 256;
                x = i - board;
                y = board - j;

                x1 = (int)Math.round(m00*x + m01*y);
                y1 = (int)Math.round(m10*x + m11*y);

                if (x1 > -board-1 && x1 < w-board && y1 > board - h && y1 < board+1){
                    rotatedImage.setRGB(board+x1, board-y1, image.getRGB(i, j));
                }else{
                    count++;
                }
            }
        }

        System.out.println(count);
    }



    private void rotate(double theta, double sin, double cos){
        m00 = cos;
        m10 = sin;
        m01 = -sin;
        m11 = cos;
    }

    private void translate(double tx, double ty){
        m02 = tx * m00 + ty * m01 + m02;
        m12 = tx * m10 + ty * m11 + m12;
    }
}
