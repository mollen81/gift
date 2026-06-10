package org.mollen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.mollen.entity.entity_type.MathTaskType;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "math_tasks")
@NoArgsConstructor
public class MathTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID uuid;

    @Column(name = "result", nullable = false)
    private int result;

    @Column(name = "task_type", nullable = false)
    private MathTaskType taskType;

    @Column(name = "task_description", nullable = true)
    private String taskDescription;

    @Column(name = "task_text", nullable = false)
    private String taskText;
}
