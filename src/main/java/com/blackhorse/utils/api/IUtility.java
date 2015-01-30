package com.blackhorse.utils.api;

import com.blackhorse.utils.exceptions.UtilityExecutionException;

/**
 * Created by Valentin
 */
public interface IUtility {
    String getName();
    void execute() throws UtilityExecutionException;
}
