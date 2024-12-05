package org.jb10pigeonskyracesecurity.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jb10pigeonskyracesecurity.utils.csvConverters.LocalTimeConverter;
import org.jb10pigeonskyracesecurity.utils.csvConverters.PigeonConverter;
import org.jb10pigeonskyracesecurity.utils.csvConverters.RaceConverter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "rankings")
public class Ranking {
    @Id
    @CsvBindByName
    private String id;

    @CsvCustomBindByName(converter = LocalTimeConverter.class)
    private LocalTime startTime;
    @CsvBindByName
    private double distance;
    @CsvBindByName
    private double adjustedSpeed;
    @CsvBindByName
    private double score;

    @DBRef
    @CsvCustomBindByName(converter = PigeonConverter.class)
    private Pigeon pigeon;

    @DBRef
    @CsvCustomBindByName(converter = RaceConverter.class)
    private Race race;
}
