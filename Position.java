
public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Position(){}
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public boolean equals(Position pos){  // check position of food and circle (use in food class)
        if(this.x == pos.x && this.y == pos.y)
            return true;
        else
            return false;
    }
}
