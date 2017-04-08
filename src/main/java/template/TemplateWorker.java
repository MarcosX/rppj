package template;

import java.util.concurrent.TimeoutException;

public abstract class TemplateWorker {

    public <T>T executar(Object parametros) {
        antesExecucao(parametros);
        T resultado = valorPadraoDeRetorno();
        while (deveContinuarTentando()) {
            try {
                resultado = trabalhar(parametros);
            } catch (TimeoutException e) {
                trataExcecao(e);
            }
        }
        return resultado;
    }

    protected abstract <T> T valorPadraoDeRetorno();

    protected abstract void trataExcecao(TimeoutException e);

    protected abstract boolean deveContinuarTentando();

    protected abstract <T>T trabalhar(Object parametros) throws TimeoutException;

    protected abstract void antesExecucao(Object parametros);
}
