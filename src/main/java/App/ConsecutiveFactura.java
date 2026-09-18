package App;

import java.util.concurrent.atomic.AtomicInteger;

public class ConsecutiveFactura {
    private final AtomicInteger unico = new AtomicInteger(0);

    private ConsecutiveFactura() {} //constructor

    private static class Holder { //holder

        private static final ConsecutiveFactura INSTANCIA =
                new ConsecutiveFactura();
    }

    public static ConsecutiveFactura getInstancia() {
        return Holder.INSTANCIA;
    }

    public int siguiente() {
        return unico.incrementAndGet();
    }
}
