package prg47;

import java.util.Objects;

public record Country(String name, double imf) {

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Country country = (Country) object;
        return Double.compare(imf, country.imf) == 0 && Objects.equals(name, country.name);
    }

}
