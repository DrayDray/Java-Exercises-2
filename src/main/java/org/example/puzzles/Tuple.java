package main.java.org.example.puzzles;

public class Tuple {

    private Integer a;
    private Integer b;

    public Tuple(Integer a, Integer b){
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Tuple)){
            return false;
        }
        Tuple objAsTuple = (Tuple) obj;

        if (objAsTuple.getA() == this.getA() && objAsTuple.getB() == this.getB()){
            return true;
        }
        if (objAsTuple.getA() == this.getB() && objAsTuple.getB() == this.getA()){
            return true;
        }
        
        return false;
    }
}
