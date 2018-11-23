package com.sawyer.tools.converter;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Description.
 *
 * @author sawyer
 * Created at 2018/11/22 22:30
 * @version com.sawyer.tools.converter.AbstractConverter v0.1
 */
public abstract class AbstractConverter implements Converter {
    @Override
    public void execute(String inputFileName, String outputFileName) {
        validate(inputFileName);
        try {
            doExecute(inputFileName, outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private boolean validate(String inputFileName) {
        return true;
    }

    /**
     * Do execution.
     *
     * @param inputFileName
     * @param outputFileName
     */
    protected abstract void doExecute(String inputFileName, String outputFileName) throws IOException;
}
