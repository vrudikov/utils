package com.blackhorse.utils.utils.jcf;

public class JavaClassFileWalker extends FileWalker {

    public JavaClassFileWalker() {
        super(FileFilters.JAVA_CLASS_FILE_FILTER);
    }

    public JavaClassFileWalker(FileFindHandler handler) {
        super(FileFilters.JAVA_CLASS_FILE_FILTER, handler);
    }


}
