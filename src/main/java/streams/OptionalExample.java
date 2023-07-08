package streams;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<User> user = findUser();
        user.ifPresent(user1 -> System.out.println(user1.getName()));

    }

    public static Optional<User> findUser() {
        User user = null; //= new User("ben",22);
        return Optional.ofNullable(user);
    }
}