import java.util.ArrayList;
import java.lang.Math;

public class Cluster {

    private Point centroid, prevCentroid;
    private ArrayList<Point> points;

    Cluster(Point p) {
        centroid = p;
        prevCentroid = p;

        points = new ArrayList<>();
    }

    void addPoint(Point p) {
        points.add(p);
    }

    double getDistanceFromCentroid(Point x) {
        double sum = 0;
        for(int i = 0; i < centroid.getAttributes().size(); i++) {
            sum += Math.pow(centroid.getAttributes().get(i) - x.getAttributes().get(i), 2);
        }

        return Math.sqrt(sum);
    }

    void reCalculateCentroid() {
        int n = points.size();
        ArrayList<Double> sums = new ArrayList<>();
        for(int i = 0; i < points.get(0).getAttributes().size(); i++) {
            sums.add(new Double(0));
        }

        for(int i = 0; i < points.size(); i++) {
            for(int j = 0; j < sums.size(); j++) {
                sums.set(j,sums.get(j) + points.get(i).getAttributes().get(j));
            }
        }

        for(int i = 0; i < sums.size(); i++) {
            sums.set(i,sums.get(i) / n);
        }

        prevCentroid = centroid;
        centroid = new Point(sums);
    }

    boolean checkCentroidChange() {
        return centroid.equals(prevCentroid);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Points: { ");
        s.append("\n");
        for(int i = 0; i < points.size(); i++) {
            s.append(points.get(i).toString());
            s.append("\n");
        }
        s.append("}");
        s.append("\n");
        s.append("Centroid: ");
        s.append(centroid.toString());
        return s.toString();
    }
}
