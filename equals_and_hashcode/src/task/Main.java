package task;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Main{
    public static void main(String[]args){

        PersonById p1 = new PersonById("Ziad", 1);
        PersonById p2 = new PersonById("Ziad", 1);

        System.out.println(p1==p2);  //    equals هي هي ==
        //System.out.println(p1.equals(p2)); دا بيعمل بالظبط نفس اللي بيعمله السطر اللي فوق طب مكتبتش كدا ليه م الاول ؟؟؟
        // عشان انا عملت override ع equals و غيرت اللي الجافا بتخليها تعمله by default
        // بدل م تقارن حسب ال reference خليتها تقارن حسب ال id
        // عشان كدا كتبت == لانها بتقارن زي equals حسب ال reference و عايز النتيجتين يكونوا هنا عشان كدا استعملت ==


        // دي هتبقي false لان هنا مش بيقارن بال values هنا بيقارن بال reference او ال memory location
        // طب ايه الفرق يعني الفرق ان حتي لو نفس ال values ف هتبقي false برضو
        //لان لما بعمل new ال variable دا بيروح يتخزن ف reference مختلف و كل new بتتخزن ف reference مختلف
        //م الاخر كدا الجافا شايفة ان كل واحد قاعد ف مكان مختلف يعني مش نفس ال reference
        // و دي اللي بتعمله equals by default من غير اي override انها بتقارن حسب المكان ف الميموري
        //الحالة الوحيدة اللي هتبقي true انك تعمل كدا
        // Person p2 = p1        true و ساعتها هتكون بتشاور ع نفس المكان وتبقي



        System.out.println(p1.equals(p2));
        // هنا هتبقي true عشان عملت override ل equals خليتها بدل م تقارن بال reference او المكان ف الميموري بقت تقارن حسب الid


        System.out.println("\n\n\n");


/*
        What happens if you override equals() but NOT hashCode()?
        اي collection بتعتمد ع ال hashing زي ال hashset و hashmap و hashtable مش هتشتغل صح
        و بكدا equals مش هيبقي ليها اي لازمة لان ال hashcode كنت بعدله ع حسب اي حاجة انا عايزها
        مثلا عامله override ع حسب الاسم ف لو لقي نفس الاسم مرتين هيديني نفس الرقم و اتاكد بقي ب equals
        لو يساوا بعض ولا لا انما من غير override لل hashcode ف كدا هيتحسب حسب ال memory location اللي كدا كدا هيبقي مختلف


*/
        Set<Person> set = new HashSet<>();
        set.add(new Person("Ziad", 10));
        set.add(new Person("Zoz", 5));
        set.add(new Person("Ali", 10));
        set.add(new Person("Omar", 5));

        System.out.println(set);

        // هنا الاتنين هيتضافوا عشان معدلناش ع ال hashcode ف الرقم طلع بناء ع ال memory location
        // اللي اكيد مختلف ف الااتين عشان new و مستعملناش equals و الجافا شافتهم اتنين مختلفين


        Set<PersonById> setById = new HashSet<>();
        setById.add(new PersonById("Ziad", 10));
        setById.add(new PersonById("Zoz", 5));
        setById.add(new PersonById("Ali", 10));
        setById.add(new PersonById("Omar", 5));

        System.out.println(setById);

        //هنا بعد م عدلنا ال hashcode يطلع الرقم حسب ال id ف كدا طلع نفس الرقم ف الاتنين obj
        //ال obj التاني هيروح نفس الدرج اللي فيه ال obj الاول بعدين عشان نتاكد هم شبه بعض ولا صدفة هنستعمل equals
        //لو ادتني true يبقي شبه بعض و مش هاخدها ال set لو false يبقي رقم ال hashcode طلع هو هو بالصدفة اللي مبتحصلش كتير


        Set<PersonByName> setByName = new HashSet<>();
        setByName.add(new PersonByName("Ziad", 10));
        setByName.add(new PersonByName("Zoz", 20));
        setByName.add(new PersonByName("Ziad", 30));
        setByName.add(new PersonByName("Zoz", 40));

        System.out.println(setByName);



        Set<PersonByIdAndName> setByIdAndName = new HashSet<>();
        setByIdAndName.add(new PersonByIdAndName("Ziad", 10));
        setByIdAndName.add(new PersonByIdAndName("Zoz", 20));
        setByIdAndName.add(new PersonByIdAndName("Ali", 30));
        setByIdAndName.add(new PersonByIdAndName("Omar", 40));
        setByIdAndName.add(new PersonByIdAndName("Ali", 30));
        setByIdAndName.add(new PersonByIdAndName("Omar", 40));

        System.out.println(setByIdAndName);


        System.out.println("\n\n\n");



        Map<Person, String> map = new HashMap<>();

        map.put(new Person("Messi", 120), " Nagar");
        map.put(new Person("Ronaldo", 100), " Makwagy");
        map.put(new Person("Suarez", 120), " Komsary");
        map.put(new Person("Iniesta", 100), " Sbak");

        System.out.println(map);
        System.out.println(map.get(new Person("Messi", 120))); // هنا ال obj بالنسباله جديد


        //  هنا طبعا ال hashcode بشتغل by default ف الرقم طالع حسب ال memory location ف كله هيتطبع
        // عايز اقولك حاجة لو ناسيها ف ال map ال hashcode بتشتغل ع ال keys بس انما ال values لو عايز تدور عليها
        // ف بنشتغل ب equals بس و لو بندور ع حاجة ف ال values بتعمل زي ال ArrayList و ال LinkedList
        // بتدور عليهم element by elememt بال linear search
        // لو عايز تعرف ليه مبرمجين الجافا محطوش ال hashcode مع ال values ابعتلي ع الواتس و انا اقولك


        Map<PersonById, String> mapById = new HashMap<>();

        mapById.put(new PersonById("Messi", 120), " Nagar");
        mapById.put(new PersonById("Ronaldo", 100), " Makwagy");
        mapById.put(new PersonById("Suarez", 120), " Komsary");
        mapById.put(new PersonById("Iniesta", 100), " Sbak");

        System.out.println(mapById);
        System.out.println(mapById.get(new PersonById("Messi", 120)));

        //شرحنا بقي كتير اوي هنا احنا عاملين override ع ال hashcode بال id ف عدلت ال values بس بنفس ال keys


        Map<PersonByIdAndName, String> mapByIdAndName = new HashMap<>();

        mapByIdAndName.put(new PersonByIdAndName("Messi", 120), " Nagar");
        mapByIdAndName.put(new PersonByIdAndName("Ronaldo", 100), " Makwagy");
        mapByIdAndName.put(new PersonByIdAndName("Messi", 120), " Komsary");
        mapByIdAndName.put(new PersonByIdAndName("Ronaldo", 100), " Sbak");

        System.out.println(mapByIdAndName);
        System.out.println(mapByIdAndName.get(new PersonByIdAndName("Ronaldo", 100)));



        System.out.println("\n\n\n");


        
        Set<Product> productSet = new HashSet<>();

        productSet.add(new Product("111", 120));
        productSet.add(new Product("222", 220));
        productSet.add(new Product("333", 70));
        productSet.add(new Product("222", 150));
        productSet.add(new Product("111", 100));
        productSet.add(new Product("555", 70));

        System.out.println(productSet);


        System.out.println("\n\n");


        Set<StudentById> studentByIdSet = new HashSet<>();

        studentByIdSet.add(new StudentById("SpongeBob.com", "24100"));
        studentByIdSet.add(new StudentById("Ben 10.com", "24300"));
        studentByIdSet.add(new StudentById("Jerry.com", "24200"));
        studentByIdSet.add(new StudentById("Tom.com", "24100"));
        studentByIdSet.add(new StudentById("Timmy Turner.com", "24300"));

        System.out.println(studentByIdSet);

        System.out.println("\n\n");


        Set<StudentByEmail> studentByEmailSet = new HashSet<>();

        studentByEmailSet.add(new StudentByEmail("SpongeBob.com", "24100"));
        studentByEmailSet.add(new StudentByEmail("Ben 10.com", "24300"));
        studentByEmailSet.add(new StudentByEmail("Jerry.com", "24100"));
        studentByEmailSet.add(new StudentByEmail("Ben 10.com", "24100"));
        studentByEmailSet.add(new StudentByEmail("SpongeBob.com", "24300"));
        studentByEmailSet.add(new StudentByEmail("Timmy Turner.com", "24300"));

        System.out.println(studentByEmailSet);

        System.out.println("\n\n");



        Map<Car, String> car = new HashMap<>();

        car.put(new Car("a u o 234", "Red"), " SpongeBob");
        car.put(new Car("m b c 576", "Blue"), " Shamshon");
        car.put(new Car("k o g 339", "Moka"), " Spider man");
        car.put(new Car("p l b 734", "Red"), " Batman");
        car.put(new Car("m b c 576", "Blue"), " Wolverine");
        car.put(new Car("a u o 234", "Red"), " DeadPool");

        System.out.println(car);

        System.out.println("\n");


        System.out.println(car.get(new Car("m b c 576", "Blue")));



    }
}



