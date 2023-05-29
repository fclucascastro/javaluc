
public class ContaCorrente implements Conta {

    Double saldo;
    Double limite;
    Double[] extrato;
    Integer cursor; // guarda a primeira posicao livre
    String codigo;

    public ContaCorrente(String codigo, Double saldoInicial) {
        this.extrato = new Double[20];
        this.cursor = 0;
        this.codigo = codigo;
        this.saldo = 0.0;
        this.depositar(saldoInicial);
        this.limite = 100.0;
    }

    public void depositar(Double valor) {
        this.extrato[this.cursor] = valor; // registrar deposito na posicao livre
        this.cursor++; // avancao para proxima posicao livre
        this.saldo += valor; // alterar saldo
    }

    public Boolean sacar(Double valor) {
        if (valor <= (saldo + limite)) {
            this.extrato[this.cursor] = -valor;
            this.cursor++;
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void alterarLimite(Double novoLimite) {
        this.limite = novoLimite;
    }

    public Double[] emitirExtrato() {
        return this.extrato;
    }

    public Double emitirSaldo() {
        return this.saldo + this.limite;
    }

    public String getCodigo() {
        return this.codigo;
    }
}