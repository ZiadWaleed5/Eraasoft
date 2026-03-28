import java.util.Scanner;


class Main{
public static void main(String[]args){
    Scanner s = new Scanner (System.in);

    System.out.println("Enter ID");
    int id = s.nextInt();
    s.nextLine();
    System.out.println("Enter Text");
    String text = s.nextLine();
    System.out.println("Enter Image");
    String image = s.nextLine();


    Facebook face = new Facebook();
        face.setId(id);
        face.setText(text);
        face.setImage(image);

        
        System.out.println(face.executePost(face).getId());
        System.out.println(face.executePost(face).getText());
        System.out.println(face.executePost(face).getImage());


    LinkedIn li = new LinkedIn();
        li.setId(id);
        li.setText(text);
        li.setImage(image);


        System.out.println(li.executePost(li).getId());
        System.out.println(li.executePost(li).getText());
        System.out.println(li.executePost(li).getImage());

        s.close();
    }
}