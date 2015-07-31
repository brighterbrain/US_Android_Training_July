package nd.sevakkalpesh.app.pattern;

/**
 * Created by kalpesh on 03/03/2015.
 */
public class Singleton {
    //Step 1: Create static instance of the class
    private static Singleton mInstance = null;

    private String mString;

    //Step 2: Create the private constructor of the class
    private Singleton(){
        mString = "Hello";
    }

    //Step 3: Create a static method which returns the object of the class
    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public String getString(){
        return this.mString;
    }

    public void setString(String value){
        mString = value;
    }
}