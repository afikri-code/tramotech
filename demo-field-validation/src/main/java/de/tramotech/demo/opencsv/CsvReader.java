package de.tramotech.demo.opencsv;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvReader<T> {
    Class clazz;
    CsvReader(Class clazz) {
        this.clazz = clazz;
    }
    public List<T> beanBuilder(String file) throws Exception {
        return  new CsvToBeanBuilder(new FileReader(file)).withType(clazz)
                .withSeparator(';').build()
                .parse();
    }
}
