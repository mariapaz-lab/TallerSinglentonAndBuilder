package App;
import java.util.List;

public class Compra {
        private final Cliente cliente;
        private final Funcion funcion;
        private final List<Asiento>asientos;
        private final Combo combo;
        private final int puntosRedimidos;

        private Compra(Builder builder){
            this.cliente=builder.cliente;
            this.funcion=builder.funcion;
            this.asientos=builder.asientos;
            this.combo=builder.combo;
            this.puntosRedimidos=builder.puntosRedimidos;
        }
        public static class Builder{
            private Cliente cliente;
            private Funcion funcion;
            private List<Asiento> asientos;
            private Combo combo;
            private int puntosRedimidos;

            public Builder cliente(Cliente cliente){
                this.cliente=cliente;
                return this;
            }
            public Builder funcion(Funcion funcion){
                this.funcion=funcion;
                return this;
            }
            public Builder asientos(List<Asiento> asientos){
                this.asientos=asientos;
                return this;
            }
            public Builder combo(Combo combo){
                this.combo=combo;
                return this;
            }
            public Builder puntosRedimidos(int puntosRedimidos){
                this.puntosRedimidos=puntosRedimidos;
                return this;
            }
            public Compra build(){
           if(cliente==null){
               throw new IllegalStateException("Cliente no existe");
           }
           if(funcion==null){
           throw new IllegalStateException("Funcion no existe");}

            if(asientos==null){
                throw new IllegalStateException("Asientos no existe");
            }
            return new Compra (this);
        }

        }
    }

