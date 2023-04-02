public class Triangle {
    
    public int base;
    public int height;
    
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    public int getArea()
    {
        int area = (base * height) / 2;
        return area;
    }
    
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Triangle){
            Triangle other = (Triangle) obj;
            return base == other.base && height == other.height;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + base;
        result = 31 * result + height;
        return result;
    }
    
}
