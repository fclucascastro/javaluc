
public class ContaPoupanca implements Conta {

    Double saldo;
    Double[] extrato;
    Integer cursor; // guarda a primeira posicao livre
    String codigo;

    public ContaPoupanca(String codigo, Double saldoInicial) {
        this.extrato = new Double[20];
        this.cursor = 0;
        this.codigo = codigo;
        this.saldo = 0.0;
        this.depositar(saldoInicial);
    }

    public void depositar(Double valor) {
        this.extrato[this.cursor] = valor; // registrar deposito na posicao livre
        this.cursor++; // avancao para proxima posicao livre
        this.saldo += valor; // alterar saldo
    }

    public Boolean sacar(Double valor) {
        if (valor <= saldo) {
            this.extrato[this.cursor] = -valor;
            this.cursor++;
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void alterarLimite(Double novoLimite) {

    }

    public Double[] emitirExtrato() {
        return this.extrato;
    }

    public Double emitirSaldo() {
        return this.saldo;
    }

    public String getCodigo() {
        return this.codigo;
    }
}