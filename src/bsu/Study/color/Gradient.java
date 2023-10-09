package bsu.Study.color;

import java.awt.image.BufferedImage;

public class Gradient {
    int[][] pixels;
    int width;
    int height;
    BufferedImage image;
    BufferedImage result;

    public Gradient(){}

    public Gradient(BufferedImage bf){
        pixels = Transformation.getMatrixOfImage(bf);
        image = bf;
        width = bf.getWidth();
        height = bf.getHeight();

        result = new BufferedImage(width, height, bf.getType());
    }

    public BufferedImage gradientMatrix(){
        for(int i = 1; i < width-1; i++){
            for (int j = 1; j < height-1; j++){
                result.setRGB(i, j, gradient(pixels, i, j));
            }
        }
        return result;
    }

    private int gradient(int[][] f, int x, int y){
        int s1 = f[x][y] - f[x-1][y-1];
        int s2 = f[x][y-1] - f[x-1][y];

        return (int)Math.sqrt(Math.pow(s1, 2) + Math.pow(s2, 2));
    }

}
