package prg34;

public class UserBuilder implements UserBuilderInterface {

    private User user = new User();

    @Override
    public UserBuilder phone(String phoneNumber) {
        this.user.setPhone(phoneNumber);
        return this;
    }

    @Override
    public UserBuilder address(String address) {
        this.user.setAddress(address);
        return this;
    }

    @Override
    public UserBuilder name(String name) {
        this.user.setName(name);
        return this;
    }

    @Override
    public UserBuilder surname(String surname) {
        this.user.setSurname(surname);
        return this;
    }

    @Override
    public UserBuilder birthday(String birthday) {
        this.user.setBirthday(birthday);
        return this;
    }

    @Override
    public void reset() {
        this.user = new User();
    }

    @Override
    public UserInterface getUser() {
        User resultedUser = this.user;
        reset();
        return resultedUser;
    }
}
