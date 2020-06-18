package br.com.codenation.centraldeerros.entity.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EnumConverter implements Converter<String, Level> {

    @Override
    public Level convert(String s) {
        return Level.valueOf(s.toUpperCase());
    }
}
