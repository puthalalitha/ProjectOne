package models;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer roleid;

    public User() {
    }

    public User(Integer id, String username, String password, String firstname, String lastname, String email, Integer roleid) {
        this.userid = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roleid = roleid;
    }

    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String username, String password, String firstname, String lastname, String email, Integer roleid) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.roleid = roleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}
