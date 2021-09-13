import java.util.Hashtable;

class TestClass1 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("device", "iPhone 12 Pro");
        capsHashtable.put("os_version", "14");
        capsHashtable.put("browserName", "ios");
        capsHashtable.put("realMobile", "true");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 1");
        MainClass r1 = new MainClass();
        r1.executeTest(capsHashtable);
    }
}