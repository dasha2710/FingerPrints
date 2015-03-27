package binarization;

import skeletonization.TemplatesBase;
import skeletonization.TemplatesMethod;
import specialPoints.CheckingHelper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static binarization.Util.colorToRGB;

/**
 * Created by Dasha on 22.03.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        File original_f = new File("Image3.jpg");
        //Binarization
        BufferedImage original = ImageIO.read(original_f);
        BufferedImage grayscale = Util.toGray(original);
        BufferedImage binarized = Util.binarize(grayscale);
        Util.writeImage("Image3_bin1", binarized);
        //Skeletonization
        BufferedImage skeletonized = TemplatesMethod.makeSkeletonization(binarized);
        Util.writeImage("Image3_skelet", skeletonized);
        //Special points
        CheckingHelper helper = new CheckingHelper(skeletonized);
        helper.pointsToClasses();
        java.util.Set<Point> endPoints = helper.getEndPoints();
        java.util.Set<Point> branchPoints = helper.getBranchPoints();

    }
}
