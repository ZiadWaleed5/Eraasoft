


public class Main{
    public static void main(String[]args){

        Person p1 = new Person("Ziad", 1);
        Person p2 = new Person("Ziad", 1);

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

    }
}