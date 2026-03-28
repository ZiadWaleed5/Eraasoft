

public class LinkedIn extends Post implements execution {
    @Override
    public Post executePost(Post post){
        System.out.println("you are on LinkedIn application");
        return post;
    }
}
