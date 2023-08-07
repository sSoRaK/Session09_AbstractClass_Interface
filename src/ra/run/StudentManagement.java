package ra.run;

import ra.impl.Student;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100];
        Student student = new Student();
        int numStudent = 0;
        do {
            System.out.println("*************************** MENU *************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số sinh viên: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập thông tin sinh viên thứ " + (i + 1) + "\n");
                        students[numStudent] = new Student();
                        students[numStudent].inputData(scanner, students, numStudent);
                        numStudent++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < numStudent; i++) {
                        students[i].calAvgMark();
                    }
                    System.out.println("Đã tính điểm trung bình của tất cả sinh viên!");
                    break;
                case 3:
                    for (int i = 0; i < numStudent; i++) {
                        students[i].rank();
                    }
                    System.out.println("Đã xếp loại của từng sinh viên!");
                    break;
                case 4:
                    for (int i = 0; i < numStudent; i++) {
                        students[i].status();
                    }
                    System.out.println("Đã xét trạng thái của từng sinh viên!");
                    break;
                case 5:
                    System.out.println("Thông tin sinh viên");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (int i = 0; i < numStudent; i++) {
                        students[i].displayData();
                    }
                    break;
                case 6:
                    Student[] newStudents = new Student[numStudent];
                    for (int i = 0; i < numStudent; i++) {
                        newStudents[i] = students[i];
                    }
                    // selection sort
                    for (int i = 0; i < numStudent - 1; i++) {
                        for (int j = i + 1; j < numStudent; j++) {
                            if (newStudents[i].calAvgMark() > newStudents[j].calAvgMark()) {
                                Student temp = newStudents[i];
                                newStudents[i] = newStudents[j];
                                newStudents[j] = temp;
                            }
                        }
                    }
                    System.out.printf("%-70s%s\n\n", " ", "Danh sách điểm trung bình tăng dần");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (int i = 0; i < numStudent; i++) {
                        newStudents[i].displayData();
                    }
                    break;
                case 7:
                    System.out.print("Nhập tên sinh viên muốn tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    boolean checkSearch = false;
                    System.out.printf("%-70s%s\n\n", " ", "Thông tin sinh viên");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (int i = 0; i < numStudent; i++) {
                        if (students[i].getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                            students[i].displayData();
                            checkSearch = true;
                        }
                    }
                    if (!checkSearch) {
                        System.err.println("Không tìm thấy tên sinh viên " + searchName);
                    }
                    break;
                case 8:
                    student.StudentsByRank(students, numStudent);
                    break;
                case 9:
                    student.studentsByStatus(students, numStudent);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập lựa chọn từ 1 - 10");
                    break;
            }
        } while (true);
    }
}
