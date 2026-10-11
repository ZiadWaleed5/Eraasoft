import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args){

        String input = "swiss";

        List<String> charList = Arrays.asList(input.split(""));

        Function<String, String> getChar = ch -> ch;

        Map<String, Long> charCount = charList.stream()
                .collect(Collectors.groupingBy(getChar, Collectors.counting()));

        Predicate<String> isUnique = ch -> charCount.get(ch) == 1;

        String firstNonRepeated = charList.stream().filter(isUnique).findFirst().get();

        System.out.println("First non repeated character: " + firstNonRepeated);



        System.out.println("\n\n\n");



        List<Integer> numbers = Arrays.asList(10, 20, 30, 20, 40, 10, 50, 30);

        Set<Integer> seen = new HashSet<>();

        Predicate<Integer> isDuplicate = num -> !seen.add(num);

        List<Integer> duplicates = numbers.stream().filter(isDuplicate).distinct()
                .collect(Collectors.toList());

        System.out.println("Duplicate elements: " + duplicates);



        System.out.println("\n\n\n");



        List<Integer> numbers1 = Arrays.asList(10, 5, 20, 20, 8, 15, 10);

        Comparator<Integer> maxim = (a,b) -> b.compareTo(a);
        int maxi = numbers1.stream().distinct().sorted(maxim).skip(1).findFirst().get();

        System.out.println("The second highest number in a list: " + maxi);



        System.out.println("\n\n\n");


        String sentence = "Java Spring Java Hibernate Spring Java";

        List<String> words = Arrays.asList(sentence.split(" "));
        Function<String, String> lowerCase = word -> word.toLowerCase();

        Map<String, Long> wordFrequency = words.stream().collect(Collectors
                .groupingBy(lowerCase, Collectors.counting()));

        System.out.println("Word Frequency: \n" + wordFrequency);


        System.out.println("\n\n\n");


        List<String> words1 = Arrays.asList(
                "Java", "SpringBoot", "Microservices",
                "Hibernate", "Docker"
        );

        Function<String, Integer> wordLen = word -> word.length();

        Comparator<String> longest = Comparator.comparing(wordLen);
        String longestWord = words1.stream().max(longest).get();

        System.out.println("The longest string: " + longestWord);



        System.out.println("\n\n\n");



        List<Employee> employees = Arrays.asList(
                new Employee("Ahmed", "IT", 10000),
                new Employee("Mohamed", "IT", 15000),
                new Employee("Sara", "HR", 8000),
                new Employee("Omar", "HR", 12000),
                new Employee("Ali", "Finance", 20000)
        );

        Function<Employee, String> employeeDep = eObj -> eObj.getDepartment();
        ToDoubleFunction<Employee> employeeSalary = eObj -> eObj.getSalary();

        Map<String, Double> avgSalary = employees.stream().collect(Collectors
                .groupingBy(employeeDep, Collectors.averagingDouble(employeeSalary)
                ));

        avgSalary.forEach((dep, avg) -> System.out.println(dep + " = " + avg));



        System.out.println("\n\n\n");


        Function<Employee, String> extractDep = eObj -> eObj.getDepartment();
        Function<Employee, Double> extractSal = eObj -> eObj.getSalary();
        Comparator<Employee> maxSalComp = Comparator.comparing(extractSal);
        Function<Optional<Employee>, String> getNameFromOpt = optEmp -> optEmp.get().getName();

        Map<String, String> highestPaid = employees.stream()
                .collect(Collectors.groupingBy(
                        extractDep,Collectors.collectingAndThen
                                (Collectors.maxBy(maxSalComp), getNameFromOpt)));

        highestPaid.forEach((dep, name) -> System.out.println(dep + " = " + name));



        System.out.println("\n\n\n");



        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 4);

        Predicate<Integer> existsInList2 = num -> list2.contains(num);

        List<Integer> commonElements = list1.stream()
                .filter(existsInList2).distinct().collect(Collectors.toList());

        System.out.println("Common elements: " + commonElements);



        System.out.println("\n\n\n");



        List<Integer> numbers2 = Arrays.asList(
                1, 2, 2, 3, 3, 3, 4, 4, 4, 4,
                5, 5, 5, 6
        );

        Function<Integer, Integer> getNum = num -> num;

        Map<Integer, Long> frequencyMap = numbers2.stream()
                .collect(Collectors.groupingBy(getNum, Collectors.counting()));

        Function<Map.Entry<Integer, Long>, Long> extractCount = entry -> entry.getValue();
        Function<Map.Entry<Integer, Long>, Integer> extractValue = entry -> entry.getKey();

        Comparator<Map.Entry<Integer, Long>> countDesc = Comparator.comparing(extractCount).reversed();
        Comparator<Map.Entry<Integer, Long>> valueAsc = Comparator.comparing(extractValue);
        Comparator<Map.Entry<Integer, Long>> finalSort = countDesc.thenComparing(valueAsc);


        System.out.println("Top 3 Most Frequent Numbers:");
        frequencyMap.entrySet().stream()
                .sorted(finalSort)
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue() + " occurrences"));




        System.out.println("\n\n\n");



        List<Employee> employees2 = Arrays.asList(
                new Employee("Ahmed", "IT", 10000),
                new Employee("Mohamed", "IT", 18000),
                new Employee("Ali", "IT", 15000),
                new Employee("Omar", "IT", 22000),
                new Employee("Sara", "HR", 12000),
                new Employee("Mona", "HR", 16000),
                new Employee("Nour", "HR", 14000),
                new Employee("Hana", "HR", 9000),
                new Employee("Khaled", "Finance", 20000),
                new Employee("Youssef", "Finance", 25000),
                new Employee("Mostafa", "Finance", 18000)
        );

        Function<Employee, String> getDep = eObj -> eObj.getDepartment();
        Function<Employee, Double> getSal = eObj -> eObj.getSalary();
        Function<Employee, String> getName = eObj -> eObj.getName();

        Comparator<Employee> salDesc = Comparator.comparing(getSal).reversed();
        Comparator<Employee> nameAsc = Comparator.comparing(getName);
        Comparator<Employee> finalSort2 = salDesc.thenComparing(nameAsc);

        Function<List<Employee>, List<Employee>> getTop3 = listObj ->
                listObj.stream().sorted(finalSort2).limit(3)
                        .collect(Collectors.toList());

        Map<String, List<Employee>> topEmployeesPerDep = employees2.stream()
                .collect(Collectors.groupingBy(
                        getDep,Collectors.collectingAndThen(Collectors.toList(), getTop3)));

        topEmployeesPerDep.forEach((dep, topList) -> {
            System.out.println(dep + ":");
            topList.forEach(emp -> System.out.println(emp.getName() + " \t " + emp.getSalary()));
        });
    }
}