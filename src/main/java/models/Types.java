package models;

public class Types {
    private Integer id;
    private String type;

    public Types(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Types() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
