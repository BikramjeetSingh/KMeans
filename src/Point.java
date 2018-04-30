import java.util.ArrayList;

public class Point {
    private ArrayList<Double> attributes;

    Point(ArrayList<Double> attributes) {
        this.attributes = attributes;
    }

    ArrayList<Double> getAttributes() {
        return attributes;
    }

    boolean equals(Point p) {
        boolean flag = true;

        for(int i = 0; i < attributes.size(); i++) {
            if(!attributes.get(i).equals(p.getAttributes().get(i))) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("( ");
        for(int i = 0; i < attributes.size(); i++) {
            s.append(attributes.get(i) + " ");
        }
        s.append(")");

        return new String(s);
    }
}
