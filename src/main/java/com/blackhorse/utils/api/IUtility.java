package com.blackhorse.utils.api;

import com.blackhorse.utils.exceptions.UtilityExecutionException;

/**
 * Created by Valentin
 */
public interface IUtility {
    String getUtilityName();
    void executeUtility() throws UtilityExecutionException;
}
