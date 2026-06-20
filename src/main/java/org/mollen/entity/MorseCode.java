package org.mollen.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "morse_codes")
public class MorseCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    @Column(name = "morse_translation")
    private String morseTranslation;

    @Column(name = "morse_text", length = 5000)
    private String morseText;

    @Column(name = "question")
    private String question;

    @Column(name = "riddle_answer")
    private String riddleAnswer;

    @Column(name = "result")
    private int result;
}
