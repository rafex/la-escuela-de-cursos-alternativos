package mx.rafex.tutum.school.rest.util;

public interface IntegerUtils {

    default Integer convert(final String str) {
        if (str != null && !str.isBlank()) {
            return Integer.valueOf(str);
        }

        return 0;
    }

}
