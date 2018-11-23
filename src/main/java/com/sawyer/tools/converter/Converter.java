package com.sawyer.tools.converter;

/**
 * Description.
 *
 * @author sawyer
 * Created at 2018/11/22 22:34
 * @version com.sawyer.tools.converter.Converter v0.1
 */
public interface Converter {
    /**
     * Execute convert.
     *
     * @param inputFileName
     * @param outputFileName
     */
    void execute(String inputFileName, String outputFileName);
}
