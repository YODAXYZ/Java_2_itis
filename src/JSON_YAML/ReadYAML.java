package JSON_YAML;

public class ReadYAML {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("person.yaml").getFile());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        Employee employee = om.readValue(file, Employee.class);

        System.out.println("Employee info " + employee.toString());

        System.out.println("Accessing first element: " + employee.getColleagues().get(0).toString());
    }
}
