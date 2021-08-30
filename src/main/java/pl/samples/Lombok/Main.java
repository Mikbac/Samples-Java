package pl.samples.Lombok;

/**
 * Created by MikBac on 30.08.2021
 */
class Main {

    public static void main(String[] args) {
        User u1 = new User();
        u1.setUsername("Admin");
        u1.setPassword("admin1");

        User u2 = User.builder()
                .username("Admin 2")
                .password("admin2")
                .build();

    }

}
