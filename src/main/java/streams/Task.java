package streams;

import java.util.*;

public class Task {
    public static void createData(List<User> users){
        Random random = new Random();
        List<String> names = List.of("Sam","Nick","Jack","Sandy","Kira","Anna","Britni","Jessica");
        for (int i = 0; i < 8; i++) {
            User user = new User(names.get(i), random.nextInt(80)+1);
            users.add(user);
        }
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        createData(users);
        for(User user:users){
            System.out.print(user.getName() +" "+ user.getAge());
            System.out.println();
        }
        users.stream()
                .sorted(Comparator.comparing(User::getName)) //
                .filter(u -> u.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);
    }
}
