package org.jb10pigeonskyracesecurity.utils.csvConverters;

import com.opencsv.bean.AbstractBeanField;
import org.jb10pigeonskyracesecurity.models.Race;

import java.util.UUID;

public class RaceConverter extends AbstractBeanField<Race, String> {
    @Override
    protected Race convert(String value) {

        Race race = new Race();
        race.setId(UUID.fromString(value));
        return race;
    }
}
