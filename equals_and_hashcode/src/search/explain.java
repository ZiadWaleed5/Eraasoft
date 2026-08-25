package search;

public class explain {
    /*
* EX1
        Set<Student> students = new HashSet<>();
        students.add(new Student(1, "ahmed"));
        students.add(new Student(1, "ahmed"));
        students.add(new Student(2, "osama"));
        students.add(new Student(2, "osama"));
        students.add(new Student(3, "ali"));

        System.out.println(students);


   الاجابة دي هتبقي بناء ع اني عملت override لل equals و ال hashcode
   مش بناء خالص ع ال reference او memory location اللي جافا عاملاها
  او هقول الحالتين احسن


   ال set هنا بعد ال override هترفض ال تكرار و هيطبع ال 3 obj المختلفين بس
   طب حلو الكلام دا بس انا برضو مش فاهم ازاي يعني لما مكنتش عامل override ال 5 obj اطبعوا
   عشان ال hashcode بتاع الجافا بيعتمد ع مكان الميموري و انت عامل 5 new يعني 5 اماكن جديدة ف كدا خلاص مفيش تكرار

   نرجع بقي بالنسبة لل case بتاعتنا لما نعمل override
   ال hashcode اللي معمولها override هتبص ع الاسم و ال id وتطلع رقم من عملية حسابية قول يعم مثلا 112
   الرقم دا بقي هتعمل بيه ايه ؟؟؟ هتحدد بيه مكان معين زي مثلا رف ف دولاب و الرف دا رقمه 112
   م الاخر بنحط ال obj دا ف الرف اللي ال hashcode عمله و لغاية دلوقتي مش محتاجين equals

  لا ركز معايا كدا حاسك بدات تتوه دا شرح مش هتلاقي زيه

   طيب دلوقتي عايزين بقي ندخل ف ال set ال obj التاني الجافا هتنادي ع ال hashcode و بما انه نفس الاسم و ال id
   يبقي كدا هاخد نفس الرقم 112 هنروح للرف 112 عشان نحط ال obj وهنا الاكشن هيبدا
   بنبص ف الرف لقيناه مش فاضي و كدا حصل معانا collision في حد تاني قاعد معانا
   كدا الجافا هيبقي قدامها حاجة م الاتنين ي اما بالصدفة البحتة اللي صعب تحصل الجافا جابتلنا نفس الرقم
   ي اما بتقول ممكن يكون ال obj الجديد هو هو القديم طب و بعدين نعرف ازاي بقي ؟؟؟
   ف الحالات دي بلجأ ل حل واحد بس و هو ال equals اللي عاملها override
  هتخش ب قلب جامد و تقول وريني بطاقتك يبني انت و هو عاملين قلق ليه
  هتقارن الاسم و ال id بتاع الاتنين هتلاقيهم زي بعض هترجع true و هنا ال hashset هتقول للتاني اثبت عندك
  هي وكالة من غير بواب ولا ايه يلا امشي مش عايز تكرار هنا و يترمي ف الزبالة ال garbage collector يشوف شغله معاه
  و لو ال equals كانت طلعت false يبقي مش شبه بعض و ي دار م دخلت شر و الاتنين يدخلوا ال set

   بس كدا يمعلم هنعيد الكلام دا كله ع كل obj و نشوف ال values بتاعته نعمل بيها ال hashcode
   و لو طلع هو هو بنحطه ف نفس الرف و ننادي ع equals
   عشان كدا اللي هيتطبع بس التلاتة المختلفين في حالة ان ال hashcode و ال equals معمولهم override






* EX2
        Student student1 = new Student(1, "ahmed");
        Student student2 = new Student(2, "osama");
        Student student3 = new Student(1, "ali");

        Set<Student> students = new HashSet<>();
        students.add(new Student(1, "ahmed"));
        students.add(new Student(2, "osama"));

        System.out.println(students.contains(student1));
        System.out.println(students.contains(student2));
        System.out.println(students.contains(student3));

       هفترض ان اتعمل override يقارن بالاسم و ال id مع بعض

      اول حاجة عايزك تعرفها ان contains بتشتغل زي add بالظبط بمعني انها بتشوف ال hashcode عشان تحدد الرف
      بعدين equals لو لقينا حد ف نفس الرف و عايزين نقارن

      contains(student1)
      اول حاجة هنحسب ال hashcode بتاع اسم و id بتوع student 1
      هيطلع نفس الرقم بتاع ال obj اللي ضفته ف تاني سطر يبقي كدا حصل collision و الرف بقي فيه اكتر من obj
      يبقي هنعمل ايه بقي ؟؟؟ بالظبط هنجيب اللي بيحصل كل مشاكلنا equals
      هتقارنهم تلاقي نفس ال id و ال obj ف الاتنين يبقي true كدا

      contains(student2)
      نفس الكلام اللي حصل فوق هيحصل هنا بالظبط ال هنلاقي ال values بتاعة ال obj موجودة ف ال set ف هتبقي true

      contains(student3)
      هنا بقي ال values اللي ف student 3 مش موجودة ف اي obj ف ال set ف هتبقي false
      اول حاجة مش هيطلع نفس ال hascode لانها قيم مختلفة ولو طلع بالصدفة ف ال equals هتقارن و هتطلع false


* EX3
        Student student1 = new Student(1, "ahmed");
        Student student2 = new Student(2, "osama");
        Student student3 = new Student(1, "ali");

        HashMap<Student, Student> map = new HashMap<>();
        map.put(new Student(1, "ahmed"), new Student(1, "ahmed"));
        map.put(new Student(2, "osama"), new Student(2, "osama"));

        System.out.println(map.containsKey(student1));
        System.out.println(map.containsKey(student2));
        System.out.println(map.containsKey(student3));

        System.out.println(map.containsValue(student1));
        System.out.println(map.containsValue(student2));
        System.out.println(map.containsValue(student3));


        عيب بقي ي هندسة المفروض انت اللي تشرح دا و اشوفك فهمت من شرحي ولا لا

        اول حاجة ال hashmap دا بيتكون من key و value و معلومة ليك كدا دي مش synchronized

        بص هي ال keys طلعت مع البشمهندس ب false كلها و ال value اول اتنين true و التالتة false
        معني كدا انه كان عامل override ل equals بس و ساب ال hashcode زي م هو من غير م يعمل override

        عايزك تعرف ان ال keys بتبقي عبارة عن ادراج مترقمة ف دولاب عشان تدور ع قيمة value لازم يبقي معاك رقم ال key
        انما ال values بقي عبارة عن مكان محطوط في الحاجات كلها مع بعض عشان تدور ع حاجة لازم تمسكهم و تقارنهم ببعض
        يعني المفروض لو عايز تقارن ع حاجة ف ال values تستعمل equals م الاخر يعني

        * map.put(new Student(1, "ahmed"),
        طيب احنا هنا عملنا اسم و id و حطيته ف ال key حلو الجافا هتعمل ايه هتشغل ال hashcode
        و بما انها مش معمولها override هتحط الرقم ع حسب ال memory location مش ع حسب اسم الطالب و ال id
        يعني دلوقتي ال key دا مثلا هيتحط ف الدرج 9
        هنيجي بقي دلوقتي نسال
        *System.out.println(map.containsKey(student1));
        هيقولك لا يا سعة البيه مفيش
        ازاي يبني م هو نفس ال values هيقولك معرفش يا بييييييه
        انا بقي اقولك يا معلم ال hashcode بيعمل الرقم بتاعه بناء ع المكان اللي خزن فيه ال student 1 ف ال memory
        ف مش هيبقي نفس ال hashcode ف لما يجي يعمل containskey هيطلع hashcode مختلف غير اللي اتعمل ف الاول و انا بعمل ال key ف هيطلع false
        نفس الكلام بالظبط مع الباقي ف كدا كله هيطلع false لان ال memory location كل مرة هتبقي مختلفة و هي اللي هتحدد ال hashcode



       بالنسبة بقي لل values ف هي جمييييلة اوي بتقولك سيبك م العبط اللي عامله ال keys دا الدنيا مش مستاهلة
       System.out.println(map.containsValue(student1));
       انت هنا بتسال هل student 1 موجود ف ال values الجافا هتعمل ايه ؟؟؟
       فاكر الادراج اللي كل رقم فيها بيبقي key معين اهو هنا هنفتح بقي درج درج و ندور ع كل حاجة جوا
       و بيستخدم equals اللي ف الادراج بال value اللي بدور عليها
       و طبعا عاملين override ليها ع حسب الاسم و ال id ف هتطلع اول اتنين true  و التالتة false

       بس للاسف محدش بياخد م الدنيا كل حاجة عشان الحوار دا كله يحصل ال containsValue هتاخد شوية وقت لانها بتفتح كل حاجة عشان تدور
       ف هنا ال time complexity هيبقي o(n)
       ال n هنا عدد ال values اللي اتفتحت في الادراج و انا بدور

       و عشان نكمل المعلومة ف ال containKeys ال time complexity بتاعه o(1)
       لانه مش محتاج يدور هو معاه رقم ال hashcode ف بيروح للدرج علطول

       دي حتة كدا algorithm اكتر مادة كنت بعاني منها الترم اللي فات


* */
}
