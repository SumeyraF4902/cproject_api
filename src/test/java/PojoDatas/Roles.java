package PojoDatas;


import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Roles {

    private Integer id;
    private String name;
    private Integer appId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Roles() {
    }

    /**
     *
     * @param appId
     * @param name
     * @param id
     */
    public Roles(Integer id, String name, Integer appId) {
        super();
        this.id = id;
        this.name = name;
        this.appId = appId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }



    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Roles.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("appId");
        sb.append('=');
        sb.append(((this.appId == null)?"<null>":this.appId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
