public interface Conta {

    public void depositar(Double valor);

    public Boolean sacar(Double valor);

    public void alterarLimite(Double novoLimite);

    public Double[] emitirExtrato();

    public Double emitirSaldo();

    public String getCodigo();

}