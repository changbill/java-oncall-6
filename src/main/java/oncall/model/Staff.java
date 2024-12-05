package oncall.model;

import java.util.Objects;

public class Staff {
    private final String name;

    private Staff(String name) {
        this.name = name;
    }

    public static Staff of(String name) {
        return new Staff(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Staff staff = (Staff) o;
        return Objects.equals(name, staff.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
