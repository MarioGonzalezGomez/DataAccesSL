package utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppProperties {
    private final Properties appProperties;

    public AppProperties() {
        appProperties = new Properties();
        try {
            appProperties.load(getClass().getClassLoader().getResourceAsStream("application.appProperties"));

        } catch (IOException ex) {
            System.err.println("IOException Ocurrido al leer el fichero de propiedades: " + ex.getMessage());
            Logger.getLogger(getClass().getName()).log(Level.ALL, "IOException Ocurrido al leer el fichero de propiedades: " + ex.getMessage());
        }
    }

    public String readProperty(String keyName) {
        // Logger.getLogger(getClass().getName()).log(Level.INFO, "Leyendo propiedad " + keyName);
        return appProperties.getProperty(keyName, "No existe esa clave en el fichero de propiedades");
    }
}
