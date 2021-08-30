package pl.samples.MapStruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by MikBac on 30.08.2021
 */

@Mapper
public interface UserPopulator {

    UserPopulator USER_POPULATOR = Mappers.getMapper(UserPopulator.class);

    @Mapping(source = "addressOne", target = "address")
    UserData sourceToTarget(UserModel userModel);

    @InheritInverseConfiguration
    UserModel targetToSource(UserData userData);

}
