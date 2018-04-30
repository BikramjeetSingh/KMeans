import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReader {
    private String loc;
    private ArrayList<Point> dataPointList = new ArrayList<>();

    DataReader(String loc) {
        this.loc = loc;
    }

    ArrayList<Point> readData() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(DataReader.class.getResourceAsStream(loc)));

            while(reader.ready()) {
                String line = reader.readLine();
                String[] temp = line.split(",");

                ArrayList<Double> readValues = new ArrayList<>();

                for(int i = 0; i < temp.length; i++) {
                    readValues.add(Double.parseDouble(temp[i]));
                }

                dataPointList.add(new Point(readValues));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataPointList;
    }
}
