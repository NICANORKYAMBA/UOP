import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * EmployeeStreamProcessor.java
 * Demonstrates the Function interface and Stream API for processing employee data.
 *
 * Features:
 * 1. Reads dataset and stores in a collection
 * 2. Uses Function interface to concatenate name and department
 * 3. Uses streams to generate a new collection of concatenated strings
 * 4. Calculates average salary using stream built-in functions
 * 5. Filters employees by age threshold
 * 6. Additional: department statistics, salary ranking, parallel stream performance
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 8
 */
public class EmployeeStreamProcessor {

    /**
     * Reads and stores the employee dataset in an ArrayList collection.
     * In a real application, this could read from a file or database.
     * @return List of Employee objects
     */
    public static List<Employee> loadDataset() {
        return Arrays.asList(
            new Employee("Alice Johnson", 28, "Engineering", 82000),
            new Employee("Bob Martinez", 35, "Marketing", 67000),
            new Employee("Carol White", 42, "Engineering", 95000),
            new Employee("David Lee", 31, "HR", 58000),
            new Employee("Emma Davis", 26, "Marketing", 61000),
            new Employee("Frank Wilson", 38, "Finance", 88000),
            new Employee("Grace Taylor", 45, "Engineering", 105000),
            new Employee("Henry Brown", 29, "HR", 54000),
            new Employee("Isla Clark", 33, "Finance", 79000),
            new Employee("James Moore", 40, "Marketing", 72000),
            new Employee("Karen Adams", 27, "Engineering", 76000),
            new Employee("Liam Scott", 36, "Finance", 91000)
        );
    }

    public static void main(String[] args) {
        // ═══════════════════════════════════════════════════════════════════
        // STEP 1: Read dataset and store in a collection
        // ═══════════════════════════════════════════════════════════════════
        List<Employee> employees = loadDataset();
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("  EMPLOYEE STREAM PROCESSOR — Function Interface & Streams");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("\n[Step 1] Dataset loaded: " + employees.size() + " employees");
        System.out.println("─────────────────────────────────────────────────────────");
        employees.forEach(System.out::println);

        // ═══════════════════════════════════════════════════════════════════
        // STEP 2: Function interface — concatenate name and department
        // The Function<T, R> interface represents a function that takes
        // an input of type T and produces an output of type R.
        // ═══════════════════════════════════════════════════════════════════
        Function<Employee, String> nameDeptConcatenator = employee ->
            employee.getName() + " [" + employee.getDepartment() + "]";

        System.out.println("\n[Step 2] Function Interface: nameDeptConcatenator");
        System.out.println("  Input:  Employee object");
        System.out.println("  Output: \"Name [Department]\" string");
        System.out.println("  Example: " + nameDeptConcatenator.apply(employees.get(0)));

        // ═══════════════════════════════════════════════════════════════════
        // STEP 3: Use streams to generate new collection of concatenated strings
        // ═══════════════════════════════════════════════════════════════════
        List<String> nameDeptList = employees.stream()
            .map(nameDeptConcatenator)
            .collect(Collectors.toList());

        System.out.println("\n[Step 3] Stream-generated collection (name + department):");
        System.out.println("─────────────────────────────────────────────────────────");
        nameDeptList.forEach(s -> System.out.println("  • " + s));

        // ═══════════════════════════════════════════════════════════════════
        // STEP 4: Calculate average salary using stream's built-in functions
        // ═══════════════════════════════════════════════════════════════════
        OptionalDouble averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average();

        System.out.println("\n[Step 4] Average salary (all employees):");
        System.out.printf("  Average: $%,.2f%n", averageSalary.orElse(0.0));

        // Also demonstrate sum and max using stream built-ins
        double totalSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .sum();
        OptionalDouble maxSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .max();

        System.out.printf("  Total payroll: $%,.2f%n", totalSalary);
        System.out.printf("  Highest salary: $%,.2f%n", maxSalary.orElse(0.0));

        // ═══════════════════════════════════════════════════════════════════
        // STEP 5: Filter employees by age threshold (above 30)
        // Uses Predicate<T> — a functional interface that returns boolean
        // ═══════════════════════════════════════════════════════════════════
        int ageThreshold = 30;
        Predicate<Employee> aboveThreshold = emp -> emp.getAge() > ageThreshold;

        List<Employee> filteredEmployees = employees.stream()
            .filter(aboveThreshold)
            .collect(Collectors.toList());

        System.out.println("\n[Step 5] Employees above age " + ageThreshold + ":");
        System.out.println("─────────────────────────────────────────────────────────");
        filteredEmployees.forEach(e -> System.out.println("  " + e));
        System.out.println("  Count: " + filteredEmployees.size() + " employees");

        // Average salary of filtered employees
        double filteredAvg = filteredEmployees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        System.out.printf("  Average salary (age > %d): $%,.2f%n", ageThreshold, filteredAvg);

        // ═══════════════════════════════════════════════════════════════════
        // ADDITIONAL FEATURES — Beyond requirements
        // ═══════════════════════════════════════════════════════════════════

        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("  ADDITIONAL FEATURES");
        System.out.println("═══════════════════════════════════════════════════════════");

        // Feature A: Department statistics using groupingBy collector
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println("\n[Feature A] Average salary by department:");
        avgSalaryByDept.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> System.out.printf("  %-12s: $%,.2f%n",
                entry.getKey(), entry.getValue()));

        // Feature B: Employee count per department
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("\n[Feature B] Employee count by department:");
        countByDept.forEach((dept, count) ->
            System.out.printf("  %-12s: %d employees%n", dept, count));

        // Feature C: Top 3 highest-paid employees using sorted + limit
        System.out.println("\n[Feature C] Top 3 highest-paid employees:");
        employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .forEach(e -> System.out.println("  " + e));

        // Feature D: Function composition — chaining multiple Functions
        Function<Employee, String> toUpperName = emp -> emp.getName().toUpperCase();
        Function<String, String> addPrefix = name -> "EMP: " + name;
        Function<Employee, String> composedFunction = toUpperName.andThen(addPrefix);

        System.out.println("\n[Feature D] Function composition (andThen):");
        employees.stream()
            .map(composedFunction)
            .limit(5)
            .forEach(s -> System.out.println("  " + s));

        // Feature E: Parallel stream performance comparison
        // Demonstrates performance benefit with a larger dataset
        System.out.println("\n[Feature E] Parallel stream performance (large dataset):");
        List<Employee> largeDataset = new ArrayList<>(100000);
        Random random = new Random(42);
        String[] depts = {"Engineering", "Marketing", "Finance", "HR", "Operations"};
        for (int i = 0; i < 100000; i++) {
            largeDataset.add(new Employee(
                "Employee_" + i, 20 + random.nextInt(40),
                depts[random.nextInt(depts.length)], 40000 + random.nextInt(80000)));
        }

        long startSeq = System.nanoTime();
        double seqAvg = largeDataset.stream()
            .filter(e -> e.getAge() > 30)
            .mapToDouble(Employee::getSalary)
            .average().orElse(0);
        long seqTime = System.nanoTime() - startSeq;

        long startPar = System.nanoTime();
        double parAvg = largeDataset.parallelStream()
            .filter(e -> e.getAge() > 30)
            .mapToDouble(Employee::getSalary)
            .average().orElse(0);
        long parTime = System.nanoTime() - startPar;

        System.out.printf("  Dataset size: 100,000 employees%n");
        System.out.printf("  Sequential: avg=$%,.2f (time: %,d ns)%n", seqAvg, seqTime);
        System.out.printf("  Parallel:   avg=$%,.2f (time: %,d ns)%n", parAvg, parTime);
        System.out.printf("  Speedup: %.2fx%n", (double) seqTime / parTime);

        // Feature F: Demonstrating lazy evaluation with peek()
        // peek() shows that elements are processed one-at-a-time through the pipeline
        // and short-circuits when findFirst() gets a result
        System.out.println("\n[Feature F] Lazy evaluation demonstration (short-circuiting):");
        System.out.println("  Finding first employee in Finance with salary > 80000:");
        Optional<Employee> result = employees.stream()
            .peek(e -> System.out.println("    Processing: " + e.getName()))
            .filter(e -> e.getDepartment().equals("Finance"))
            .filter(e -> e.getSalary() > 80000)
            .findFirst();
        result.ifPresent(e -> System.out.println("  Found: " + e));
        System.out.println("  (Notice: stream stopped after finding first match — lazy evaluation)");

        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("  Program completed successfully.");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
}
