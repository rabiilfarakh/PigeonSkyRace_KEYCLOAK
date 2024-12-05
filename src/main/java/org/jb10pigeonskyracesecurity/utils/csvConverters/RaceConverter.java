package org.jb10pigeonskyracesecurity.utils.csvConverters;

import com.opencsv.bean.AbstractBeanField;
import org.jb10pigeonskyracesecurity.models.Race;

public class RaceConverter extends AbstractBeanField<Race, String> {
    @Override
    protected Race convert(String value) {

        Race race = new Race();
        race.setId(value);
        return race;
    }
}
