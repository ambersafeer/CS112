package avengers;

public class Generator {
    public int id; // generator number
    public double functionality; // functionality of the generator

    public Generator(int i, double f){
        id = i;
        functionality = f;
    }
    
    public Generator(){
        this(0, 0.0);
    }

    public int getId(){
        return id;
    }

    public double getFunct(){
        return functionality;
    }

}
