package com.blackhorse.utils.modules.text;

import com.blackhorse.utils.api.IUtility;
import com.blackhorse.utils.api.RunNow;
import com.blackhorse.utils.exceptions.UtilityExecutionException;

/**
 * Created by Valentin
 */
@RunNow
public class Sh2BatConverter implements IUtility {
    public static final String MODULE_NAME = "sh-2-bat-converter";

    public String getUtilityName() {
        return MODULE_NAME;
    }

    public void executeUtility() throws UtilityExecutionException {

    }
}
