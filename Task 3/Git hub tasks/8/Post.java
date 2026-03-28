

public abstract class Post{

    private int id;
    private String text;
    private String image;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }
}