package co.istad.elearningapi.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String familyName;
    private String givenName;
    @Column(length = 30, unique = true, nullable = false)
    private String nationalIdCard;
    @Column(columnDefinition = "TEXT")
    private String biography;
}
