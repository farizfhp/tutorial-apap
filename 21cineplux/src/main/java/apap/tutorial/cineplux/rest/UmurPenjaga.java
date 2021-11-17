package apap.tutorial.cineplux.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UmurPenjaga {
//        private String status;
        @JsonProperty("name")
        private String namaPenjaga;
        @JsonProperty("age")
        private Integer umur;
        @JsonProperty("count")
        private Integer count;
}