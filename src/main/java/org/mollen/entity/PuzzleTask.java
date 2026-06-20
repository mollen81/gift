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
@Table(name = "puzzle_tasks")
public class PuzzleTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "result", nullable = false)
    private String result;
}
