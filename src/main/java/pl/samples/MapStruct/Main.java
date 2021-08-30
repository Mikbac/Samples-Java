package pl.samples.MapStruct;

import lombok.extern.log4j.Log4j2;

/**
 * Created by MikBac on 30.08.2021
 */

@Log4j2
public class Main {

    public static void main(String[] args) {

        UserModel user = UserModel.builder()
                .username("Admin")
                .password("admin1")
                .addressOne("Lorem ipsum")
                .build();

        UserData userData = UserPopulator.USER_POPULATOR.sourceToTarget(user);

        log.info("username: {}, address: {}", userData.getUsername(), userData.getAddress());

    }

}
