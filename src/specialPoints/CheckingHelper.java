package specialPoints;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by Dasha on 24.03.2015.
 */
public class CheckingHelper {

    private Set<Point> endPoints= new HashSet<>();
    private Set<Point> branchPoints= new HashSet<>();
    private BufferedImage image;

    public CheckingHelper(BufferedImage image) {
        this.image = image;
    }

    public void pointsToClasses() {
        for (int i = 1; i < image.getWidth() - 1; i++) {
            for (int j = 1; j < image.getHeight() - 1; j++) {
                if (new Color(image.getRGB(i, j)).getRed() == 0) {
                    int count = getNumberOfBlackNeighbors(i, j);
                    if (count == 1) {
                        endPoints.add(new Point(i, j));
                    } else if (count == 3) {
                        branchPoints.add(new Point(i, j));
                    }
                }
            }
        }
        endPoints.removeAll(branchPoints);
        branchPoints.removeAll(endPoints);
    }

    private int getNumberOfBlackNeighbors( int i, int j) {
        int count = -1;
        for (int index1 = -1; index1 <= 1; index1++) {
            for (int index2 = -1; index2 <= 1; index2++) {
                if (new Color(image.getRGB(i + index1, j + index2)).getRed() == 0) count++;
            }
        }
        return count;
    }


    public Set<Point> getEndPoints() {
        return endPoints;
    }

    public Set<Point> getBranchPoints() {
        return branchPoints;
    }
}
