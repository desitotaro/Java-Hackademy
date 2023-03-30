public class Pointer3D {
    public int x;
    public int y;
    public int z;
    
    public Pointer3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public String print(){ return "x: " + x + " y: " + y + " z: " + z; }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Pointer3D){
            Pointer3D other = (Pointer3D) obj;
            return x == other.x && y == other.y && z == other.z;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return x + y + x;
    }
    
}
