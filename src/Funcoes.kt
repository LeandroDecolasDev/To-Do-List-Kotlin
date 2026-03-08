import java.io.File

    //Atualiza o ID quando inicia o programa
    fun verificarID(): Int{
        val path = "./BD.txt"
        val file = File(path)
        var idSeparado: Int

        if (!file.exists() || file.readLines().isNullOrEmpty()){
            idSeparado = 0
        }else{
            idSeparado = file.readLines().last().split(";").first().toInt()
        }
        return idSeparado
    }

    //Adiciona a tarefa para a lista
    fun adicionarTarefa() {
        //Usuario cria tarefa
        println("\nNome da Tarfefa:\n")
        val titulo: String = readln()
        println("Descrição da Tarefa:\n")
        val descricao: String = readln()
        println("prioridade da Tarfefa:\n")
        val prioridade: Int = readln().toInt()

        id++
        //Guarda Objeto na variavel
        val novaTarefa = Tarefa(id, titulo, descricao, prioridade)

        tarefas.add(novaTarefa)
    }

    //Faz uma lista para o usuario usando a lista de tarefas
    fun listarTarefa() {
        println("-------------------------------------------------------------------------------------------")
        for (tarefa in tarefas) {
            val status = when (tarefa.concluida) {
                false -> "Não Concluida"
                else -> "Concluida"
            }
            println("ID: ${tarefa.id}\n${tarefa.titulo}\n${tarefa.descricao}\nPrioridade: ${tarefa.prioridade}\nStatus: ${status}")
            println("-------------------------------------------------------------------------------------------")
        }
    }

    fun marcartarefa(){
        println("\nQual tarefa você quer marcar como concluida?\n")
        listarTarefa()
        println("\nEscolha por ID:")

        var esc: Int?
        do {
            esc = readln().toIntOrNull()
            if (esc == null){
                println("Resposta inválida, tente de novo")
            }
        }while (esc == null)

        for (tarefa in tarefas){
            if(tarefa.id == esc){
                tarefa.concluida = true
            }
        }
    }

    fun removerTarefa(){
        println("\nQual tarefa você EXCLIR??\n")
        listarTarefa()
        println("\nEscolha por ID:")
        var esc: Int?

        do {
            esc = readln().toIntOrNull()
            if (esc == null){
                println("Resposta inválida, tente de novo")
            }
        }while (esc == null)

        val indice = tarefas.indexOfFirst { it.id == esc }
        if(indice == -1){
            println("ID não encontrado")
        }else{
            tarefas.removeAt(indice)
        }
    }

fun filtrarLista(){
    println("Filtrar lista por:\n1 - Nome de Tarefa\n2 - Prioridade")
    var tipo: Int?
    do {
        tipo = readln().toIntOrNull()
        if (tipo == null){
            println("\nNumero de filtragem desconhecido!\n Tente de novo\n")
        }
    }while (tipo != 1 && tipo != 2)


    val novalistagem = when(tipo){
        1-> tarefas.sortedBy(){it.titulo.lowercase()}
        else -> tarefas.sortedBy(){it.prioridade}
    }

        for (tarefa in novalistagem) {
            val status = when (tarefa.concluida) {
                false -> "Não Concluida"
                else -> "Concluida"
            }
            println("ID: ${tarefa.id}\n${tarefa.titulo}\n${tarefa.descricao}\nPrioridade: ${tarefa.prioridade}\nStatus: ${status}")
            println("-------------------------------------------------------------------------------------------")
        }
}

    //Atualiza a lista quando o programa inicia
    fun atualizarlista(){
        val path = "./BD.txt"
        val file = File(path)

        for (linhas in file.readLines()){
            //variavel que converte os objetos do arquivo BD.txt
            val novaTarefa = Tarefa(
                //ID
                linhas.split(";")[0].toInt(),
                //Titulo
                linhas.split(";")[1],
                //descricao
                linhas.split(";")[2],
                //prioridade
                linhas.split(";")[3].toInt(),
                //concluida
                linhas.split(";")[4].toBoolean()
            )
            tarefas.add(novaTarefa)
        }
    }

    //Salva as tarefas no arquivo BD.txt
    fun salvarArquivo(){
        //Salva no arquivo
        val path = "./BD.txt"
        val file = File(path)
        file.writeText("")

        if (!file.exists()) {//Cria um novo arquivo se não existir
            file.createNewFile()
        }

        for(tarefa in tarefas){
            file.appendText("${tarefa.id};${tarefa.titulo};${tarefa.descricao};${tarefa.prioridade};${tarefa.concluida}\n")
        }
        return println("FIM")
    }