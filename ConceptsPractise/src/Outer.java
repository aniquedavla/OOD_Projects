
//Test scope of static/nonstatic inner classes, and its static and non static props.
public class Outer
{ private int i ;
    private static int s;

    public void im()
    { i++;
        s++;

        Inner inner = new Inner();
        inner.inner_var++;w
        inner.innerMethod();

        SNClass snclass = new SNClass();
        snclass.var++;
        snclass.inMethod();

        SNClass.svar++;
        SNClass.snMethod();
    }

    public static void sm()
    {
        // i++;
        s++;

        //Inner inner = new Inner();
        //inner.inner_var++;
        //inner.innerMethod();

        SNClass snclass = new SNClass();
        snclass.var++;
        SNClass.svar++;

    }

    public class Inner
    {
        private int inner_var = 5;
        public void innerMethod()
        {           inner_var++;
            i++;
            s++;
            im();
            sm();
        }
    }

    public static class SNClass
    {
        private int var ;
        private static int svar ;
        public void inMethod()
        {
            var++;
            svar++;

            // i++; non-static variable i cannot be referenced from a static context
            (new Outer()).i++;

            s++;

            // im();
            (new Outer()).im();

            sm();

        }

        public static void snMethod()
        {  // var++;
            svar++;

            // i++;
            (new Outer()).i++;

            s++;

            //im();
            (new Outer()).im();
            sm();
        }

    }



}

