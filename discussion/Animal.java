public class Animal {
    protected String name;
    protected String noise;

    protected  int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
        this.noise = "Huh?";
    }

    public String makeNoise(){
        if (age < 5){
            return noise.toUpperCase();
        } else {
            return noise;
        }
    }

    public void greet(){
        System.out.println("AnimaL" + name + "says: " + makeNoise());
    }
}
