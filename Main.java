import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Obținem instanța de OperatingSystemMXBean
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        // Creăm un executor programat care va rula sarcina la fiecare 5 secunde
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Definim sarcina de monitorizare
        Runnable monitorTask = () -> {
            // Obținerea sarcinii CPU
            double cpuLoad = osBean.getSystemCpuLoad();
            System.out.println("CPU Load: " + (cpuLoad * 100) + "%");

            // Obținerea memoriei libere
            long freeMemory = osBean.getFreePhysicalMemorySize();
            System.out.println("Free Memory: " + (freeMemory / 1024 / 1024) + " MB");

            System.out.println("----------");
        };
        // Programăm sarcina să ruleze la fiecare 5 secunde
        scheduler.scheduleAtFixedRate(monitorTask, 0, 5, TimeUnit.SECONDS);
    }
}
