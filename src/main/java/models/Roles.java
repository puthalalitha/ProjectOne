package models;

public class Roles {
    private Integer id;
    private String roles;

    public Roles() {
    }

    public Roles(Integer id, String roles) {
        this.id = id;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roles='" + roles + '\'' +
                '}';
    }
}
