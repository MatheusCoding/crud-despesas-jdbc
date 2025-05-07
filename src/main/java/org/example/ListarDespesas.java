//CRIADO E COMENTADO POR MATHEUS DE OLIVEIRA MEDEIROS
package org.example;

public class ListarDespesas {
    public static void main(String[] args) {
      /*
                //CÓDIGO EXEMPLO - INSERIR UMA DESPESA
      //Inserindo Despesas

        DespesaDAO dao = new DespesaDAO();

        Despesa despesa = new Despesa();

        //colocando os parametros das despesas

        despesa.setDescricao("Viagem ate o aeroporto");
        despesa.setCategoria(Categoria.TRANSPORTE);
        despesa.setValor(110.00);
        despesa.setData(LocalDate.of(2021, 4, 28));

        //salvando e imprimindo

        Despesa despesaInserida = dao.save(despesa);
        System.out.println("Despesa inserida: id = " + despesaInserida.getId());
        */

        /*
                  //CÓDIGO EXEMPLO - BUSCAR TODAS AS DESPESAS

        //Buscando todas as despesas

        DespesaDAO dao = new DespesaDAO();

        // criando uma lista

        List<Despesa> despesas = dao.findAll();

        //percorrendo e imprimindo a lista

        for (Despesa despesa : despesas) {
            System.out.println("ID: " + despesa.getId());
            System.out.println("Descricao: " + despesa.getDescricao());
            System.out.println("Data: " + despesa.getData());
            System.out.println("Valor: " + despesa.getValor());
            System.out.println("Categoria: " + despesa.getCategoria());
            System.out.println("============================================");

        }
        */

        /*
                   //CÓDIGO EXEMPLO - BUSCAR DESPESA PELO ID
        //Buscando uma despesa pelo id

        DespesaDAO dao = new DespesaDAO();

        // Parametros da busca pelo id

        Optional<Despesa> despesaOptional = dao.findById(2L);

        //Imprimindo caso o id seja válido

        despesaOptional.ifPresent(despesa -> {
            System.out.println("ID: " + despesa.getId());
            System.out.println("Descricao: " + despesa.getDescricao());
            System.out.println("Data: " + despesa.getData());
            System.out.println("Valor: " + despesa.getValor());
            System.out.println("Categoria: " + despesa.getCategoria());
            System.out.println("============================================");
        });
         */

        /*
                  //CÓDIGO EXEMPLO - BUSCAR DESPESA POR CATEGORIA
        //Buscando uma despesa pela categoria

        DespesaDAO dao = new DespesaDAO();

        //Parametros da busca pela categoria

        List<Despesa> despesas = dao.findByCategoria(Categoria.TRANSPORTE);

        //percorrendo e imprimindo a lista

        for (Despesa despesa : despesas) {
            System.out.println("ID: " + despesa.getId());
            System.out.println("Descricao: " + despesa.getDescricao());
            System.out.println("Data: " + despesa.getData());
            System.out.println("Valor: " + despesa.getValor());
            System.out.println("Categoria: " + despesa.getCategoria());
            System.out.println("============================================");
        }

         */

    }
}
