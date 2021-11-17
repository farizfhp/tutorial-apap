package apap.tutorial.cineplux.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "bioskop")
@JsonIgnoreProperties(value = {"listPenjaga","listFilm"}, allowSetters = true)
public class BioskopModel implements Serializable, Comparable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noBioskop;

    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    private String namaBioskop;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String alamatBioskop;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahStudio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;

    //Relasi dengan PenjagaModel
    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenjagaModel> listPenjaga;

    //Relasi dengan FilModel
    @ManyToMany
    @JoinTable(
            name = "film_bioskop",
            joinColumns = @JoinColumn(name = "no_bioksop"),
            inverseJoinColumns = @JoinColumn(name = "no_film"))
    List<FilmModel> listFilm;


    @Override
    public int compareTo(Object o) {
        return namaBioskop.compareTo(o.toString());
    }

    public String toString() {
        return namaBioskop;
    }
}