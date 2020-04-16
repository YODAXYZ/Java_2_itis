//package JSON_YAML;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
//
//
//
//class Employee_1 {
//
//    public Employee_1(String name, int wage, String position, List<Employee_1> colleagues) {
//        this.name = name;
//        this.wage = wage;
//        this.position = position;
//        this.colleagues = colleagues;
//    }
//
//    public Employee_1() {
//    }
//
//    private String name;
//    private int wage;
//    private String position;
//    private List<Employee_1> colleagues;
//
//
//    @Override
//    public String toString() {
//        return "\nName: " + name + "\nWage: " + wage + "\nPosition: " + position + "\nColleagues: " + colleagues + "\n";
//    }
//}
//public class WriteYAML {
//    public static void main(String[] args) {
//        List<Employee_1> colleagues = new ArrayList<Employee_1>();
//
//        colleagues.add(new Employee_1("Mary", 1800, "Developer", null));
//        colleagues.add(new Employee_1("Jane", 1200, "Developer", null));
//        colleagues.add(new Employee_1("Tim", 1600, "Developer", null));
//        colleagues.add(new Employee_1("Vladimir", 1000, "Developer", null));
//
//        Employee_1 employee = new Employee_1("David", 1500, "Developer", colleagues);
//
//
//        ObjectMapper om = new ObjectMapper(new YAMLFactory());
//
//        om.writeValue(new File("/src/main/resources/person2.yaml"), employee);
//    }
//}
