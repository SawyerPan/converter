package com.sawyer.tools.converter;

import com.sawyer.tools.converter.json.Json2ExcelConverter;

import java.util.Objects;

/**
 * Starter of converter.
 *
 * @author sawyer
 * Created at 2018/11/22 22:15
 * @version com.sawyer.tools.converter.ConverterStarter v0.1
 */
public class ConverterStarter {
    private static final int ERROR_ILLEGAL_ARGS = -1;

    private static final int ARG_SIZE_ALL = 3;

    public static void main(String[] args) {
        if (Objects.isNull(args) || ARG_SIZE_ALL != args.length) {
            printHelp();
            System.exit(ERROR_ILLEGAL_ARGS);
        }

        int type;

        try {
            type = Integer.valueOf(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(String.format("Type %s is not numeric. ", args[0]));
            System.exit(ERROR_ILLEGAL_ARGS);
            return;
        }

        String inputFileName = args[1];
        String outputFileName = args[2];

        Converter converter;

        switch (type) {
            case 1:
                converter = new Json2ExcelConverter();
                converter.execute(inputFileName, outputFileName);
                break;
            default:
                break;
        }
    }

    private static void printHelp() {

    }
}
