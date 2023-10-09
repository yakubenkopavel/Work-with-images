package bsu.Study.color;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.nio.file.Paths;

public class Transformation {
    public static int min = Integer.MAX_VALUE;

    public static int[][] getMatrixOfImage(BufferedImage bufferedImage) {
        int width = bufferedImage.getWidth(null);
        int height = bufferedImage.getHeight(null);
        int[][] pixels = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferedImage.getRGB(i, j);
                pixels[i][j] = (color & 0xff0000) >> 16;
            }
        }

        return pixels;
    }

    public static BufferedImage getDifference(BufferedImage standard, BufferedImage image1, BufferedImage image2){
        BufferedImage result = new BufferedImage(standard.getWidth(), standard.getHeight(), standard.getType());

        for(int i = 0; i < standard.getWidth(); i++){
            for(int j = 0; j < standard.getHeight(); j++){
                int dif = Math.abs(image1.getRGB(i, j) - image2.getRGB(i, j));

                result.setRGB(i, j , dif);
            }
        }

        return result;
    }

    public static BufferedImage getSum(BufferedImage image1, BufferedImage image2){
        int width = image1.getWidth();
        int height = image1.getHeight();
        BufferedImage result = new BufferedImage(width, height, image1.getType());

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                int sum = image1.getRGB(i, j) + image2.getRGB(i, j);
                result.setRGB(i, j, sum);

                if (sum < min){
                    min = sum;
                }
            }
        }

        if (min > 255){
            min = 255;
        }

        return result;
    }

    public static void getWithoutMin(BufferedImage image){
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                image.setRGB(i, j, image.getRGB(i, j) - 255);
            }
        }
    }

}
