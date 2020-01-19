package classic;

@SuppressWarnings("unused")
public class Singleton {
    private static Singleton INSTANCE = null;

    /**
     * 饿汉，线程安全
     */
    private static final Singleton HUNGER_INSTANCE = new Singleton();

    /**
     * DCL：懒汉，线程安全
     */
    public static Singleton getInstanceDcl() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 懒汉，线程不安全
     */
    public Singleton getInstanceThreadUnsafe() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    /**
     * synchronized：懒汉，线程安全
     */
    public synchronized Singleton getInstanceThreadSafe() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    /**
     * 枚举实现：饿汉，线程安全
     * 不需要担心double checked locking，而且还能防止反序列化导致重新创建新的对象。
     * 保证只有一个实例（即使使用反射机制也无法多次实例化一个枚举量）。
     */
    enum EnumSingleton {
        INSTANCE;

        public void foo() {
            // do stuff
        }
    }

    /**
     * 内部类实现：懒汉，线程安全
     */
    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
}
