public class Persona {
    private int age;
    private String name;
    private String surname;

    public Persona(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Override del metodo toString per vedere meglio le stringhe
    @Override
    public String toString(){
        return "age : " + age + " name: " + name;
    }
}
