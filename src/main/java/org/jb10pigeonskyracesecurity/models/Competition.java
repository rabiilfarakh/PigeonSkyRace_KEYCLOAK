package org.jb10pigeonskyracesecurity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "competitions")
public class Competition {
    @Id
    private String id;
    private String name;
    private LocalDateTime closedAt;

    @DBRef
    private List<Race> races;
}
