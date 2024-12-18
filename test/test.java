interface nigga{
    void monega();
}

abstract class check implements nigga {

    @Override
    abstract public void monega();
}

class check2 extends check{
    @Override
    public void monega() {
        // TODO Auto-generated method stub
        System.out.println("works");
    }
}

public class test{
    public static void main(String[] args) {
        check2 c = new check2();
        c.monega();
    }   
}
