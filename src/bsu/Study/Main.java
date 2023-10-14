package bsu.Study;

import bsu.Study.color.Gradient;
import bsu.Study.color.Transformation;
import bsu.Study.reading.OutputImage;
import bsu.Study.reading.ReadingFile;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        startActionColor();
    }

    private static void startActionColor(){
        BufferedImage bufferedImage = ReadingFile.read("src/Resources/cat.jpg", "jpg");
        OutputImage.output(bufferedImage);

        Gradient gradient = new Gradient(bufferedImage);
        BufferedImage imageOutline = gradient.gradientMatrix();
        OutputImage.output(imageOutline);

        BufferedImage imageSum = Transformation.getSum(bufferedImage, imageOutline);
        OutputImage.output(imageSum);

        System.out.println(Transformation.min);

        Transformation.getWithoutMin(imageSum);
        OutputImage.output(imageSum);
    }

}
