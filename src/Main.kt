import java.io.File

val tarefas = mutableListOf<Tarefa>()
var id = verificarID()

    fun main(){
        //Atualiza a lista de tarefas atraves do arquivo BD.txt
        atualizarlista()
        var opc: Int

        do {
            println("Menu\n")
            println("1 - Adicionar Tarefa")
            println("2 - Listar Tarefa")
            println("3 - Marcar Tarefa Como Concluida")
            println("4 - Remover Tarefa")
            println("5 - Filtrar Tarefa")
            println("6 - Sair")
            opc = readln().toInt()

            when(opc){
                1 ->adicionarTarefa()
                2 ->listarTarefa()
                3 ->marcartarefa()
                4 ->removerTarefa()
                5 ->filtrarLista()
                6 ->salvarArquivo()
                else -> println("\nNumero Inválido!\n")
            }

        }while (opc != 6)
    }
