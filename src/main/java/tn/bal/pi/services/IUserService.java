package tn.bal.pi.services;

import tn.bal.pi.dto.UserDto;
import tn.bal.pi.entities.User;

public interface IUserService extends AbstractService<UserDto>{

    Long validateAccount(Long id);
    Long invalidateAccount(Long id);
}
