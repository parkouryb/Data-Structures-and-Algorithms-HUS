/* NomNom created on 5/29/2020 inside the package - CTDL.Homework_7.LineSegmentIntersection */

package CTDL.Homework_7.LineSegmentIntersection;

public class Line {
    public int id = 0;
    public Point point = null, point1 = null;

    public Line() {
    }

    public Line(int id, Point point, Point point1) {
        this.id = id;
        this.point = point;
        this.point1 = point1;
    }
}
