package RegExPattenMatching;

import jdk.management.VirtualThreadSchedulerMXBean;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.*;

public class Client {

    // . single char match
    // * multi char match
    public static void main(String[] args) {

        String s = "aaab";

        boolean b = s.matches("a*b");

        System.out.println(b);

        VirtualThreadSchedulerMXBean virtualThreadSchedulerMXBean =
                ManagementFactory.getPlatformMXBean(VirtualThreadSchedulerMXBean.class);
        virtualThreadSchedulerMXBean.getPoolSize();
        virtualThreadSchedulerMXBean.getQueuedVirtualThreadCount();

    }
}
