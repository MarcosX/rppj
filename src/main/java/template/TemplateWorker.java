package template;

import java.util.concurrent.TimeoutException;

public abstract class TemplateWorker {

    public <T>T executar(Object parametros) {
        antesExecucao(parametros);
        T resultado = valorPadraoDeRetorno();
        do {
            try {
                resultado = trabalhar(parametros);
            } catch (TimeoutException e) {
                trataExcecao(e);
            }
        } while (deveContinuarTentando());
        return resultado;
    }

    protected abstract <T> T valorPadraoDeRetorno();

    protected abstract void trataExcecao(TimeoutException e);

    protected boolean deveContinuarTentando() {
        return false;
    };

    protected abstract <T>T trabalhar(Object parametros) throws TimeoutException;

    protected void antesExecucao(Object parametros) {};
}
