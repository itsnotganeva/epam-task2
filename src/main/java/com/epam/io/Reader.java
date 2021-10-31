package com.epam.io;

import com.epam.entity.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Reader {

    private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);

    public static Text readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        Text txt = new Text(stringBuilder.toString());
        LOGGER.debug("Source text was read from {}" , filePath);
        return txt;
    }
}
