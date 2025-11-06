package testings.reflections;

public class Container<T> {
    Class<? extends T> aClass;

    Container(Class<? extends T> aClass) {
    this.aClass = aClass;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return aClass.newInstance();
    }
}