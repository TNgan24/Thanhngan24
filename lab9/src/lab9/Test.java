package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {

		Faculty faculty = new Faculty();
		faculty.setName("Khoa CNTT");
		faculty.setAddress("Đại học Nông Lâm");

		List<Course> courses = new ArrayList<>();
		Course course1 = new Course();
		course1.setId("01");
		course1.setTitle("Cấu trúc dữ liệu");
		course1.setType("thực hành");

		List<Student> students1 = new ArrayList<>();
		students1.add(new Student("22130111", "Hoang Van A", 2022));
		students1.add(new Student("22130748", "Le Van B", 2022));
		students1.add(new Student("22130363", "Nguyen Kim D", 2022));
		course1.setStudents(students1);

		courses.add(course1);

		Course course2 = new Course();
		course2.setId("02");
		course2.setTitle("Nhập môn trí tuệ nhân tạo");
		course2.setType("lý thuyết");

		List<Student> students2 = new ArrayList<>();
		students2.add(new Student("22130179", "Le Hoang Ngan", 2022));
		students2.add(new Student("22130741", "Vo Viet Hoang", 2023));
		course2.setStudents(students2);

		courses.add(course2);

		
		faculty.setCourse(courses);

		Course maxPracticalCourse = faculty.getMaxPracticalCourse();

		if (maxPracticalCourse != null) {
			System.out.println("Học phần thực hành có nhiều sinh viên đăng ký nhất:");
			System.out.println("Mã số: " + maxPracticalCourse.getId());
			System.out.println("Tiêu đề: " + maxPracticalCourse.getTitle());
		} else {
			System.out.println("Không có học phần thực hành.");
		}
		System.out.println();

		Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();

		if (!studentsByYear.isEmpty()) {
			System.out.println("Danh sách sinh viên theo năm vào học:");
			for (Map.Entry<Integer, List<Student>> entry : studentsByYear.entrySet()) {
				int year = entry.getKey();
				List<Student> students = entry.getValue();

				System.out.println("Năm " + year + ":");
				for (Student student : students) {
					System.out.println("Mã số sinh viên: " + student.getId());
					System.out.println("Họ tên sinh viên: " + student.getName());
				}
				System.out.println();
			}
		} else {
			System.out.println("Không có sinh viên.");
		}

		String type = "thực hành";

		Set<Course> filteredCourses = faculty.filterCourses(type);
		if (!filteredCourses.isEmpty()) {
			System.out.println("Danh sách học phần theo loại " + type + ":");
			for (Course course : filteredCourses) {
				System.out.println("Mã khóa học: " + course.getId());
				System.out.println("Tên khóa học: " + course.getTitle());
				System.out.println("Số lượng sinh viên đăng ký: " + course.getStudents().size());
				System.out.println();
			}
		} else {
			System.out.println("Không có khóa học theo loại đã cho.");
		}

	}
}
