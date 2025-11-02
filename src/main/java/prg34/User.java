package prg34;

public class User implements UserInterface {
    private String phone;
    private String address;
    private String name;
    private String surname;
    private String birthday;

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
