package codes.neuralkatana.nkforum.dto;

import codes.neuralkatana.nkforum.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static List<UserDTO> userListToUserDTOList(List<User> list){
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public static UserDTO converterUserToUserDTO(User user){
        return new UserDTO(user);
    }
}
