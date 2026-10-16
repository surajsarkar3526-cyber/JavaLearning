package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class EmployeeImportance {
    static class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    static Map<Integer, Employee> map = new HashMap<>();
    public static int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public static int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        for (int subordinateId : employee.subordinates) {
            total += dfs(subordinateId);
        }
        return total;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        int id = 1;
        System.out.println("Total Importance: " + getImportance(employees, id));
    }
}
