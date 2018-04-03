package com.netcracker.edu.task3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Injector {
    public static <T> T inject(T ob) {
        try {
            Class c = ob.getClass();
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
            String str;
            Set states = prop.keySet();

            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoInjectable.class)) {
                    Iterator itr = states.iterator();
                    while(itr.hasNext()) {
                        str = (String) itr.next();
                        if (str.equals(field.getType().getTypeName())) {
                            Class cl = Class.forName(prop.getProperty(str));
                            Object inst1 = cl.newInstance();
                            field.setAccessible(true);
                            field.set(ob, inst1);

                        }
                    }
                }
            }
            return ob;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace(System.out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
