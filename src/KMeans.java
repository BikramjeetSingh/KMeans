import java.util.ArrayList;
import java.util.Scanner;

public class KMeans {

    public static void main(String[] args) {

        int k;
        boolean flag = false;
        ArrayList<Cluster> clusterList = new ArrayList<>();
        ArrayList<Point> dataPointList;

        String dataFile = "Hepatitis - data only.csv";
        DataReader dataReader = new DataReader(dataFile);
        dataPointList = dataReader.readData();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of clusters k: ");
        k = scan.nextInt();

        for(int i = 0; i < k; i++) {
            clusterList.add(new Cluster(dataPointList.get(i)));
        }

        do {
            for (int i = 0; i < dataPointList.size(); i++) {
                double minDist = clusterList.get(0).getDistanceFromCentroid(dataPointList.get(i));
                int minK = 0;

                for (int j = 0; j < clusterList.size(); j++) {

                    double dist = clusterList.get(j).getDistanceFromCentroid(dataPointList.get(i));
                    if (dist < minDist) {
                        minDist = dist;
                        minK = j;
                    }
                }

                clusterList.get(minK).addPoint(dataPointList.get(i));
                clusterList.get(minK).reCalculateCentroid();
            }

            for(int i = 0; i < clusterList.size(); i++) {

                if(clusterList.get(i).checkCentroidChange()) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        } while(flag);

        for(int i = 0; i < clusterList.size(); i++) {
            System.out.println();
            System.out.println("Cluster " + Integer.toString(i) + ": ");
            System.out.println(clusterList.get(i).toString());
        }
    }
}
