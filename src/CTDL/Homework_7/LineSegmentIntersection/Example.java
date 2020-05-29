/* NomNom created on 5/29/2020 inside the package - CTDL.Homework_7.LineSegmentIntersection */

package CTDL.Homework_7.LineSegmentIntersection;

import CTDL.Homework_7.OneDRangeSearch.ODRS;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Example {
    public static void init(Line[] hLines, Line[] vLines) {
        hLines[0] = new Line(0, new Point(2, 6), new Point(7, 6));
        hLines[1] = new Line(1, new Point(4, 3), new Point(9, 3));
        hLines[2] = new Line(2, new Point(5, 8), new Point(7, 8));
        hLines[3] = new Line(3, new Point(8, 9), new Point(11, 9));
        hLines[4] = new Line(4, new Point(10, 6), new Point(11, 6));
        hLines[5] = new Line(5, new Point(11, 8), new Point(12, 8));
        hLines[6] = new Line(6, new Point(12, 5), new Point(16, 5));
        hLines[7] = new Line(7, new Point(14, 7), new Point(17, 7));

        vLines[0] = new Line(0, new Point(4, 2), new Point(4, 7));
        vLines[1] = new Line(1, new Point(6, 7), new Point(6, 9));
        vLines[2] = new Line(2, new Point(7, 1), new Point(7, 4));
        vLines[3] = new Line(3, new Point(10, 3), new Point(10, 10));
        vLines[4] = new Line(4, new Point(14, 3), new Point(14, 8));
    }

    private static class Dataset implements Comparable{
        public int coordidate = 0;
        public int y = 0;
        public int y1 = 0;
        public boolean isH = false;
        public boolean isOpen = false;

        public Dataset(int coordidate, int y, boolean isH, boolean isOpen) {
            this.coordidate = coordidate;
            this.y = y;
            this.y1 = y;
            this.isH = isH;
            this.isOpen = isOpen;
        }

        public Dataset(int coordidate, int y, int y1, boolean isH, boolean isOpen) {
            this.coordidate = coordidate;
            this.y = y;
            this.y1 = y1;
            this.isH = isH;
            this.isOpen = isOpen;
        }

        @Override
        public int compareTo(Object o) {
            Dataset x = (Dataset) o;
            double keyCompare = this.coordidate - x.coordidate;
            if (keyCompare == 0) {
                if (this.isH == true) return -1;
                else return 1;
            }
            else {
                if (keyCompare < 0) return -1;
                else return 1;
            }
        }

        @Override
        public String toString() {
            return "Dataset{" +
                    "coordidate=" + coordidate +
                    ", y=" + y +
                    ", y1=" + y1 +
                    ", isH=" + isH +
                    ", isOpen=" + isOpen +
                    '}';
        }
    }

    public static void main(String[] args) {
        Line[] hLines = new Line[8];
        Line[] vLines = new Line[5];
        init(hLines, vLines);

        ArrayList<Dataset> ls = new ArrayList<Dataset>();

        for (Line x: hLines) {
            ls.add(new Dataset(x.point.x, x.point.y, true, true));
            ls.add(new Dataset(x.point1.x, x.point.y, x.point.y, true, false));
        }

        for (Line x: vLines) {
            ls.add(new Dataset(x.point.x, x.point.y, x.point1.y, false, true));
        }

        Collections.sort(ls);
        // Print list
        for (Dataset x: ls) {
            System.out.println(x);
        }

        ODRS<Integer> tree = new ODRS<>();

        for (Dataset dts: ls) {
            if (dts.isH == true) {
                if (dts.isOpen == true) {
                    tree.addNode(dts.y);
                }
                else {
                    tree.delNode(dts.y1);
                }
            }
            else {
                int count = tree.count(dts.y, dts.y1);
                System.out.println("Count: " + count);
            }
//            tree.printTree();
//            System.out.println("------------------------------");
        }
    }
}

//    Dataset{coordidate=2.0, y=6.0, y1=6.0, isH=true, isOpen=true}
//    Dataset{coordidate=4.0, y=3.0, y1=3.0, isH=true, isOpen=true}
//    Dataset{coordidate=4.0, y=2.0, y1=7.0, isH=false, isOpen=true}
//    Dataset{coordidate=5.0, y=8.0, y1=8.0, isH=true, isOpen=true}
//    Dataset{coordidate=6.0, y=7.0, y1=9.0, isH=false, isOpen=true}
//    Dataset{coordidate=7.0, y=8.0, y1=8.0, isH=true, isOpen=false}
//    Dataset{coordidate=7.0, y=6.0, y1=6.0, isH=true, isOpen=false}
//    Dataset{coordidate=7.0, y=1.0, y1=4.0, isH=false, isOpen=true}
//    Dataset{coordidate=8.0, y=9.0, y1=9.0, isH=true, isOpen=true}
//    Dataset{coordidate=9.0, y=3.0, y1=3.0, isH=true, isOpen=false}
//    Dataset{coordidate=10.0, y=6.0, y1=6.0, isH=true, isOpen=true}
//    Dataset{coordidate=10.0, y=3.0, y1=10.0, isH=false, isOpen=true}
//    Dataset{coordidate=11.0, y=8.0, y1=8.0, isH=true, isOpen=true}
//    Dataset{coordidate=11.0, y=6.0, y1=6.0, isH=true, isOpen=false}
//    Dataset{coordidate=11.0, y=9.0, y1=9.0, isH=true, isOpen=false}
//    Dataset{coordidate=12.0, y=5.0, y1=5.0, isH=true, isOpen=true}
//    Dataset{coordidate=12.0, y=8.0, y1=8.0, isH=true, isOpen=false}
//    Dataset{coordidate=14.0, y=7.0, y1=7.0, isH=true, isOpen=true}
//    Dataset{coordidate=14.0, y=3.0, y1=8.0, isH=false, isOpen=true}
//    Dataset{coordidate=16.0, y=5.0, y1=5.0, isH=true, isOpen=false}
//    Dataset{coordidate=17.0, y=7.0, y1=7.0, isH=true, isOpen=false}
