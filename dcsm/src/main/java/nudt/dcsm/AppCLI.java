package nudt.dcsm;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import javax.annotation.RegEx;

/**
 * dcsm工程交互式运行命令行，用于jar运行选择运行模式
 */
public class AppCLI {
    private static final String RUN_MODE_SECMANAGER = "sm";
    private static final String RUN_MODE_SECAGENT = "sa";
    private static final String RUN_MODE_MANMADE = "mm";

    @Parameter(names = "--help", help = true, order = 0)
    private boolean help;
    @Parameter(names = "-runmode",
            description = "run as SecManager(sm), SecAgent(sa) or ManMade(mm), eg. -runmode sa", required = true, order = 1)
    //@RegEx("(sm|sa|mm)")
    private String runmode;

    public static void main(String[] args) {
        AppCLI cli = new AppCLI();
        JCommander jCommander = JCommander.newBuilder().addObject(cli).build();
        jCommander.parse(args);
        cli.run(jCommander);
    }

    public void run(JCommander jCommander) {
        if (help) {
            jCommander.setProgramName("java -jar swagger-diff.jar");
            jCommander.usage();
            return;
        }
        switch(runmode){
            case "sm" :
                System.out.println("Run as a secManager");
                break; //可选
            case "sa" :
                System.out.println("Run as a secAgent");
                break; //可选
            case "mm" :
                System.out.println("Run as a manMade");
            default : //可选
                //语句
        }
    }
}
