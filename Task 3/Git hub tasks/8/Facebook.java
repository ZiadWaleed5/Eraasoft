

public class Facebook extends Post implements execution{
    
    @Override
    public Post executePost(Post post){
        System.out.println("you are on Facebook application");
        return post;
    }

}
