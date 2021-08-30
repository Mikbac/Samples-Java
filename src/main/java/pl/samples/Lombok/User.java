package pl.samples.Lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by MikBac on 30.08.2021
 */

@Getter
@Setter
@NoArgsConstructor
@Builder
public class User {

    private String username;
    private String password;

}
