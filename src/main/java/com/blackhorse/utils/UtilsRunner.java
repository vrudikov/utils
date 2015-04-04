package com.blackhorse.utils;

import com.blackhorse.utils.api.IUtility;
import com.blackhorse.utils.api.RunNow;
import com.blackhorse.utils.utils.jcf.JavaClassFinder;

import java.util.List;

/**
 * Created by Valentin
 */
public class UtilsRunner {
    public static void main(String[] args) {
        JavaClassFinder classFinder = new JavaClassFinder();
        List<Class<? extends IUtility>> classes = classFinder.findAllMatchingTypes(IUtility.class);

        for (Class<? extends IUtility> clazz : classes) {
            if (clazz.isAnnotationPresent(RunNow.class)) {
                try {
                    IUtility instance = clazz.newInstance();
                    System.out.println("Running " + instance.getUtilityName());
                    instance.executeUtility();
                    System.out.println("Finished " + instance.getUtilityName());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
