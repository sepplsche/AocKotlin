import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AocCoordinates {

    public record Point(int x, int y) implements Comparable<Point> {
        public static Point of(int x, int y) {
            return new Point(x, y);
        }

        public Point add(Point o) {
            return new Point(x + o.x, y + o.y);
        }

        public Point sub(Point o) {
            return add(o.neg());
        }

        public Point neg() {
            return new Point(-x, -y);
        }

        public boolean isNachbar(Point p) {
            return (x == p.x - 1 && y == p.y)
                    || (x == p.x + 1 && y == p.y)
                    || (y == p.y - 1 && x == p.x)
                    || (y == p.y + 1 && x == p.x)
                    || (x == p.x + 1 && y == p.y + 1)
                    || (x == p.x - 1 && y == p.y - 1)
                    || (x == p.x + 1 && y == p.y - 1)
                    || (x == p.x - 1 && y == p.y + 1);
        }

        public Set<Point> nachbars(Set<Point> points) {
            return points.stream()
                    .filter(this::isNachbar)
                    .collect(Collectors.toSet());
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

        @Override
        public int compareTo(Point o) {
            int i = x - o.x;
            return i != 0 ? i : y - o.y;
        }
    }

    public record Straight(Point p1, Point p2) {
        public static Straight of(Point p1, Point p2) {
            return new Straight(p1, p2);
        }

        public static Straight ofOrdered(Point p1, Point p2) {
            return p1.compareTo(p2) < 0 ? new Straight(p1, p2) : new Straight(p2, p1);
        }

        public Set<Point> points() {
            Set<Point> points = new HashSet<>();
            for (int i = min(p1.x, p2.x); i <= max(p1.x, p2.x); i++) {
                for (int j = min(p1.y, p2.y); j <= max(p1.y, p2.y); j++) {
                    points.add(Point.of(i, j));
                }
            }
            return points;
        }

        public Point length() {
            return Point.of(p2.x - p1.x, p2.y - p1.y);
        }

        @Override
        public String toString() {
            return "[" + p1 + ", " + p2 + "]";
        }
    }
}