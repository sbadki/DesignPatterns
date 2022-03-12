package com.study.dp.creational.singleton;

import java.io.*;

public class BasicSingleton {
    public static final BasicSingleton basicSingleton = new BasicSingleton();
    private BasicSingleton(){}
}

class StaticBlockSingleton {
    public static StaticBlockSingleton singleton;;

    private StaticBlockSingleton(){}

    static {
        try {
            singleton = new StaticBlockSingleton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LazyLoadingSingleton {
    private static LazyLoadingSingleton singleton;

    private LazyLoadingSingleton(){}

    public static LazyLoadingSingleton getSingleton() {
        if(null == singleton) {
            singleton = new LazyLoadingSingleton();
        }
        return singleton;
    }
}

class SynchronizeSingleton {
    private static SynchronizeSingleton singleton;

    private SynchronizeSingleton(){}

    public static synchronized SynchronizeSingleton getSingleton() {
        if(null == singleton) {
            singleton = new SynchronizeSingleton();
        }
        return singleton;
    }
}

class ThreadSafeSingleton implements Serializable {
    private static ThreadSafeSingleton INSTANCE;

    private ThreadSafeSingleton(){}

    public static ThreadSafeSingleton getInstanceUsingDoubleChecking() {
        if(null == INSTANCE) {
            synchronized (ThreadSafeSingleton.class) {
                if(null == INSTANCE) {
                    INSTANCE = new ThreadSafeSingleton();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method to rescue for serializable singleton object
     * @return
     */
    protected Object readResolve() {
        return INSTANCE;
    }
}

class BillPughSingleton {

    private BillPughSingleton(){}

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getSingleton() {
        return SingletonHelper.INSTANCE;
    }
}

enum Singleton {
}

class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BasicSingleton basicSingleton = BasicSingleton.basicSingleton;
        System.out.println(basicSingleton.getClass().hashCode());
        System.out.println(basicSingleton.getClass().hashCode());

        StaticBlockSingleton staticBlockSingleton = StaticBlockSingleton.singleton;
        System.out.println(staticBlockSingleton.getClass().hashCode());
        System.out.println(staticBlockSingleton.getClass().hashCode());

        LazyLoadingSingleton singleton = LazyLoadingSingleton.getSingleton();
        System.out.println(singleton.getClass().hashCode());
        System.out.println(singleton.getClass().hashCode());

        SynchronizeSingleton synchronizeSingleton = SynchronizeSingleton.getSingleton();
        System.out.println(synchronizeSingleton.getClass().hashCode());
        System.out.println(synchronizeSingleton.getClass().hashCode());

        BillPughSingleton billPughSingleton = BillPughSingleton.getSingleton();
        System.out.println(billPughSingleton.getClass().hashCode());
        System.out.println(billPughSingleton.getClass().hashCode());

        System.out.println(Singleton.class.hashCode());
        System.out.println(Singleton.class.hashCode());

        ThreadSafeSingleton doubSafeSingleton = ThreadSafeSingleton.getInstanceUsingDoubleChecking();
        System.out.println(doubSafeSingleton.getClass().hashCode());
        System.out.println(doubSafeSingleton.getClass().hashCode());

        System.out.println("==============Serializable singleton=============");

        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstanceUsingDoubleChecking();

        ObjectOutput instance = new ObjectOutputStream(new FileOutputStream("file.ser"));
        instance.writeObject(instance1);
        instance.close();

        ObjectInput input = new ObjectInputStream(new FileInputStream("file.ser"));
        ThreadSafeSingleton instance2 = (ThreadSafeSingleton) input.readObject();
        input.close();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}