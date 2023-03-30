import java.util.Comparator;

public class Pointer3DCompare implements Comparator<Pointer3D> {
    @Override
    public int compare(Pointer3D p1, Pointer3D p2){
        return (p1.x + p1.y + p1.z) - (p2.x + p2.y + p2.z);

    }
}