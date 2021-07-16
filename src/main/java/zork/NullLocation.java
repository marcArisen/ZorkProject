package zork;

public class NullLocation extends Location{

    private static Location nullLocation;

    public NullLocation() {
        super("-");
    }

    public static Location getInstance(){
        if (nullLocation == null){
            nullLocation = new NullLocation();
        }
        return nullLocation;
    }
}
