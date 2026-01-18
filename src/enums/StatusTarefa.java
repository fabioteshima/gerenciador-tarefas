package enums;

public enum StatusTarefa {

    PENDENTE(1),
    EM_ANDAMENTO(2),
    CONCLUIDO(3);

    private int opcao;

    StatusTarefa(int opcao) {
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    }

    public static StatusTarefa ConverteOpcaoParaStatus(int opcao){
        for(StatusTarefa st : StatusTarefa.values()){
            if(st.getOpcao() == opcao){
                return st;
            }
        }
        return null;
    }
}


