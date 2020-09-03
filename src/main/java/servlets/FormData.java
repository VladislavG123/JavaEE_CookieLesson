package servlets;

// Этот класс должен быть в отдельном пакете, не бейте
public class FormData {
    private String name;
    private String surname;
    private int age;
    private String country;
    private boolean isMale;

    @Override
    public String toString() {
        return name + "`" + surname + "`" + age + "`" + country + "`" + isMale;
    }

    public FormData(String data){
        var attrs = data.split("`");
        name = attrs[0];
        surname = attrs[1];
        age = Integer.parseInt(attrs[2]);
        country = attrs[3];
        isMale = Boolean.parseBoolean(attrs[4]);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public FormData() {
    }

    public FormData(String name, String surname, int age, String country, boolean isMale) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.isMale = isMale;
    }
}
