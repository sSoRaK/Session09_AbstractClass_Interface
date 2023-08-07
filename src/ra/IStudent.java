package ra;

import ra.impl.Student;

import java.util.Scanner;

public interface IStudent {
    public final byte MARK_PASS = 5;

    void inputData(Scanner scanner, Student[] students, int numStudent);

    public abstract void displayData();

    public abstract float calAvgMark();
}
