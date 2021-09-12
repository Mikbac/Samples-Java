package pl.samples.MapStruct;

import lombok.Builder;
import lombok.Data;

/**
 * Created by MikBac on 30.08.2021
 */

@Data
@Builder
public class UserModel {

    private String username;
    private String addressOne;

}
