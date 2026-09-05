import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Predicate;  
import java.util.function.Function; 
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;
import java.util.Comparator;    
import java.util.stream.Collectors;   



public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 10, 0, -3, 4);


        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

        
        //   Task 1 

        Predicate<Integer> isEven = num -> num % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);


        Predicate<String> select = (name) -> name.startsWith("A"); 
        List<String> selectedNames = names.stream().filter(name -> name != null).filter(select).collect(Collectors.toList());        
        System.out.println("Names starting with A: " + selectedNames);


        Function<String, String> convert = name -> name.toUpperCase();
        List<String> convertedList = names.stream().filter(name -> name != null).map(convert).collect(Collectors.toList());
        System.out.println("Uppercase Names " + convertedList);

        
        Comparator<Integer> sort = (a,b) -> b.compareTo(a);
        List<Integer> sortedNums = numbers.stream().sorted(sort).collect(Collectors.toList());
        System.out.println("Sorted Numbers " + sortedNums);


        List<Integer> distinctedList = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("Distincted List "+ distinctedList);
        System.out.println("\n\n\n");


        //   Task 2

        long count = names.stream().filter(name -> name != null).filter(name -> name.length() > 5).count();
        System.out.println("Count the number of strings longer than 5 characters= " + count);


        String firstMatch = names.stream().filter(n -> n != null ).filter(name -> name.startsWith("N")).findFirst().get();
        System.out.println("First matching element: " + firstMatch);
        // findFirst بترجع optional و عشان اقدر افتحها لازم get
        // ال get دي معمولة عشان لو متاكد ان ال optional مش فاضي هتفهم الحتة دي اكتر ف الداتا بيز


        boolean check = numbers.stream().anyMatch(num -> num % 5 == 0);
        System.out.println("Check if any number is divisible by 5 in a list: " + check);


        Set<Integer> newSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("the set: "+ newSet);


        List<Integer> restList = numbers.stream().skip(3).collect(Collectors.toList());
        System.out.println("Skip the first 3 elements and return the rest: "+ restList);
        System.out.println("\n\n\n");
     

        //   Task 3

        int total = numbers.stream().reduce(0, (sum, num) -> sum + num);
        System.out.println("The sum is: " + total);


        Comparator<Integer> theMax = (a,b) -> a.compareTo(b);
        Comparator<Integer> theMin = (a,b) -> a.compareTo(b);
        int maxNum = numbers.stream().max(theMax).get();
        int minNum = numbers.stream().min(theMin).get();
        System.out.println("the maximum: "+ maxNum + "     the minimum: "+ minNum);
        

        double average = (double)total / (numbers.stream().count());
        System.out.println("the average of a list of doubles: "+ average);


        double multiply = numbers.stream().reduce(1,(mul,num) -> mul*num);
        System.out.println("the multiply is: "+ multiply);


        long posNum = numbers.stream().filter(num -> num > 0).count();// ال count function ف الجافا دايما بترجع long
        System.out.println("the number of positive integers is: "+ posNum);
        System.out.println("\n\n\n");

        //   Task 4

        List<Student> students = Arrays.asList(
        new Student("Ali", "IT", 85),
        new Student("Mona", "CS", 92),
        new Student("Ahmed", "IT", 60),
        new Student("Sara", "CS", 70),
        new Student("Omar", "IS", 45),
        new Student("Laila", "IS", 78)
        );

        // مهمة اوي دي و رخمة ركز فيها و شوف لو عايز تخلي ال value ايه عشان دي الصعوبة كلها

        Function<Student,String> extractDep = sObj -> sObj.getDepartment();
        Function<Student, String> extractName = sObj -> sObj.getName();
        Map<String,List<String>> depOfStudent = students.stream().collect(Collectors.groupingBy(extractDep,  // لو ال value محددنهاش تحت ف اللي هيتطبع هو ال student object
            Collectors.mapping(extractName,Collectors.toList())        ));         // السطر دا كله عشان نحدد ال value       
        System.out.println("Group a list of students by their department: \n"+ depOfStudent);

        
        Map<Boolean,List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("Partition a list of numbers into even and odd using partitioningBy: "+ partition);


        String commaSeparated = names.stream().collect(Collectors.joining(", "));
        System.out.println(" comma-separated string: "+commaSeparated);


        List<Employee> employees = Arrays.asList(
        new Employee("Ali", 30, "HR", 5000),
        new Employee("Mona", 25, "IT", 7000),
        new Employee("Ahmed", 30, "HR", 5500),
        new Employee("Sara", 27, "IT", 7200),
        new Employee("Omar", 40, "Finance", 8000),
        new Employee("Laila", 35, "Finance", 8200)
        );


        Function<Employee,Integer> extractAge = eObj -> eObj.getAge();
        Map<Integer,Long> employeeAge = employees.stream().collect(Collectors.groupingBy(extractAge,Collectors.counting()));
        System.out.println("Group employees by age and count how many per age: "+employeeAge);


        Function<Employee,String> employeeDep = eObj -> eObj.getDepartment();
        //Function<Employee,Double> employeeSalary = eObj -> eObj.getSalary();  //averaging functions don't accept functional interface (Function)
        ToDoubleFunction<Employee> employeeSalary = eObj -> eObj.getSalary();
        Map<String,Double> avgSalary = employees.stream().collect(Collectors.groupingBy(employeeDep,
            Collectors.averagingDouble(employeeSalary)   ));
        System.out.println("Average salary per department: "+avgSalary);
        System.out.println("\n\n\n");


        //   Task 5
        
        
        List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("Java", "Stream"),
            Arrays.asList("API", "Lambda"),
            Arrays.asList("FlatMap", "Map")
        );


        Function<List<String>,Stream<String>> flatList = listObj -> listObj.stream();
        List<String> words = nestedWords.stream().flatMap(flatList).collect(Collectors.toList());
        System.out.println("Flatten list: "+words);


        Function<String,Stream<String>> chars = charObj -> Arrays.stream(charObj.split(""));
        List<String> uniqueChars = names.stream().filter(name -> name!=null && name!="").flatMap(chars).distinct().collect(Collectors.toList());
        System.out.println("Unique Characters: "+ uniqueChars);


        List<Optional<String>> namesOptional = Arrays.asList(
            Optional.of("Ali"), 
            Optional.of("Mona"), 
            Optional.of("Ahmed"), 
            Optional.of("Sara"), 
            Optional.of("Amr"), 
            Optional.of("Laila"), 
            Optional.of("Kareem"), 
            Optional.of("Nada"), 
            Optional.of("Nour"), 
            Optional.of("Samy"), 
            Optional.of(""),              
            Optional.empty()             
        );


        Function<Optional<String>,String> unboxing = name -> name.get();
        List<String> filteredOptional = namesOptional.stream().filter(name -> name.isPresent() && !name.get().isEmpty()).map(unboxing)
            .collect(Collectors.toList());
        System.out.println("Filter a list of Optionals and collect non-empty values: "+filteredOptional);


        Function<String,Integer> len = name -> name.length();
        List<Integer> lenString = names.stream().filter(name -> name != null).map(len).collect(Collectors.toList());
        System.out.println("the Length of names: "+lenString);


        Predicate<Optional<String>> aLetter = name -> name.isPresent() && name.get().startsWith("A");
        Function <Optional<String>,String> aToA = name -> name.get().toUpperCase();
        List<String> upperedList = namesOptional.stream().filter(aLetter).map(aToA).collect(Collectors.toList());
        System.out.println("uppercased words that start with A: "+upperedList);


        //   Task 6


        Function<Employee,Double> empSal = salObj -> salObj.getSalary();
        Function<Employee,String> empName = nameObj -> nameObj.getName();
        List<String> salAndName = employees.stream().sorted(Comparator.comparing(empSal).thenComparing(empName))
            .map(emp -> "Name: " + emp.getName() + " | Salary: " + emp.getSalary()).collect(Collectors.toList());
        System.out.println("Sort a list of employees by salary then by name: "+salAndName);


        Comparator<Integer> maxim = (a,b) -> b.compareTo(a);
        int maxi = numbers.stream().distinct().sorted(maxim).skip(1).findFirst().get();
        System.out.println("The second highest number in a list: "+maxi);


        Set<Integer> enrolled = new HashSet();
        List<Integer> enrolledSet = numbers.stream().filter(num -> !enrolled.add(num)).distinct().collect(Collectors.toList());
        System.out.println("Duplicated elements: "+enrolledSet);


        List<String> cleanList = names.stream().filter(name -> name != null && !name.strip().isEmpty()).collect(Collectors.toList());
        System.out.println("Names without null or empty elements: "+cleanList);


        Map<Boolean,List<Student>> result = students.stream().collect(Collectors.partitioningBy(std -> std.getGrade() > 70)); 
        List<String> pass = result.get(true).stream().map(std -> std.getName()).collect(Collectors.toList());
        List<String> fail = result.get(false).stream().map(std -> std.getName()).collect(Collectors.toList());
        System.out.println("Partition students into pass/fail groups based on grade: ");
        System.out.println("Passed students: "+pass);
        System.out.println("Failed students: "+fail);



        // الحمدلله خلصت اطول تاسك ف حياتي بس كان في شوية مرقعة برضو

    }


}

