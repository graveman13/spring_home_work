package spring.intro;
public class UserResponseDto {
    private String name;
    private String email;

    public UserResponseDto(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
