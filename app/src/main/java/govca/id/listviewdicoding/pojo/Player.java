package govca.id.listviewdicoding.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstname",
        "lastname"
})

public class Player {
    @JsonProperty("name")
    private String player_name;
    @JsonProperty("position")
    private String player_position;
    @JsonProperty("nationality")
    private String player_nationality;
    @JsonProperty("number")
    private String player_number;
    @JsonProperty("photo")
    private String player_photo;
    @JsonProperty("comment")
    private String player_comment;

    public Player(){

    }

    @JsonProperty("name")
    public String getPlayer_name() {
        return player_name;
    }

    @JsonProperty("name")
    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    @JsonProperty("position")
    public String getPlayer_position() {
        return player_position;
    }

    @JsonProperty("position")
    public void setPlayer_position(String player_position) {
        this.player_position = player_position;
    }

    @JsonProperty("nationality")
    public String getPlayer_nationality() {
        return player_nationality;
    }

    @JsonProperty("nationality")
    public void setPlayer_nationality(String player_nationality) {
        this.player_nationality = player_nationality;
    }

    @JsonProperty("number")
    public String getPlayer_number() {
        return player_number;
    }

    @JsonProperty("number")
    public void setPlayer_number(String player_number) {
        this.player_number = player_number;
    }

    @JsonProperty("photo")
    public String getPlayer_photo() {
        return player_photo;
    }

    @JsonProperty("photo")
    public void setPlayer_photo(String player_photo) {
        this.player_photo = player_photo;
    }

    @JsonProperty("comment")
    public String getPlayer_comment() {
        return player_comment;
    }

    @JsonProperty("comment")
    public void setPlayer_comment(String player_comment) {
        this.player_comment = player_comment;
    }
}
