/* NomNom created on 5/29/2020 inside the package - CTDL.Homework_7.LineSegmentIntersection */

package CTDL.Homework_7.LineSegmentIntersection;

public class Line {
    public int id = 0;
    public Point p1 = null, p2 = null;

    public Line() {
    }

    public Line(int id, Point p1, Point p2) {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
    }
}
