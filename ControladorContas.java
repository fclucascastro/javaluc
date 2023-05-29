
import java.util.List;
import java.util.ArrayList;

public class ControladorContas {

    private List<Conta> contas;

    public ControladorContas() {
        this.contas = new ArrayList<Conta>();
    }

    public Boolean cadastrarContaCorrente(String codigo, Double saldoInicial) {
        if (buscarConta(codigo) == null) {
            this.contas.add(new ContaCorrente(codigo, saldoInicial));
            return true;
        }
        return false;
    }

    public Boolean cadastrarContaPoupanca(String codigo, Double saldoInicial) {
        if (buscarConta(codigo) == null) {
            this.contas.add(new ContaPoupanca(codigo, saldoInicial));
            return true;
        }
        return false;
    }

    public Boolean realizarSaque(String codigo, Double valor) {
        Conta contaOrigem = buscarConta(codigo);
        if (contaOrigem != null) {
            return contaOrigem.sacar(valor); // retorno o resultado do saque
        }
        return false;
    }

    public Boolean realizarDeposito(String codigo, Double valor) {
        Conta contaDestino = buscarConta(codigo);
        if (contaDestino != null) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public Boolean realizarTransferencia(String codigoOrigem, String codigoDestino, Double valor) {
        Conta contaOrigem = buscarConta(codigoOrigem);
        Conta contaDestino = buscarConta(codigoDestino);
        // verifica se ambas contas foram achadas
        if (contaOrigem != null && contaDestino != null) {
            // verifica se saque deu certo
            if (contaOrigem.sacar(valor)) {
                // se saque deu certo, entao deposita no destino
                contaDestino.depositar(valor);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Double emitirSaldo(String codigo) {
        Conta contaDestino = buscarConta(codigo);
        if (contaDestino != null) {
            return contaDestino.emitirSaldo();
        }
        return -1.0;
    }

    private Conta buscarConta(String codigoBuscado) {
        for (Conta c : this.contas) {
            if (c.getCodigo() == codigoBuscado) {
                return c;
            }
        }
        return null;
    }
}