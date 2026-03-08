```markdown
# To-Do List (Console) — Kotlin

Aplicação de **lista de tarefas (To-Do)** feita em **Kotlin**, executada no **terminal/console**.  
O programa permite cadastrar tarefas, listar, marcar como concluídas, remover, filtrar e **persistir os dados em um arquivo `.txt`** para manter as tarefas entre execuções.

---

## Funcionalidades

- **Adicionar tarefa**
  - Usuário informa: título, descrição e prioridade
  - A tarefa recebe um **ID incremental**
- **Listar tarefas**
  - Exibe todas as tarefas cadastradas com seus campos (ID, título, descrição, prioridade e status)
- **Marcar tarefa como concluída**
  - Atualiza o campo `concluida` para `true` a partir do ID informado
- **Remover tarefa**
  - Usuário informa o **ID**
  - O programa localiza a tarefa pelo ID, encontra o índice na lista e remove
- **Filtrar tarefas**
  - Permite filtrar tarefas conforme a regra implementada no menu (por exemplo: prioridade/status)
- **Persistência em arquivo**
  - Ao iniciar o programa, as tarefas são carregadas do arquivo **`BD.txt`**
  - Ao alterar dados (adicionar/remover/concluir), os dados são salvos novamente

---

## Como funciona (fluxo geral)

1. Ao iniciar, o programa tenta **ler o arquivo `BD.txt`**.
2. Cada linha do arquivo é interpretada e convertida em um objeto `Tarefa`.
3. As tarefas ficam em uma `MutableList` em memória durante a execução.
4. O menu é exibido e o usuário escolhe as opções.
5. Sempre que a lista é modificada (ex.: adiciona, remove ou conclui), o arquivo é atualizado.
6. O ID é mantido incremental para evitar repetição.

---

## Estrutura básica

- `main.kt`
  - Exibe o menu
  - Chama as funções de cada operação (adicionar/listar/remover/etc.)
  - Controla a lista em memória e o fluxo do programa
- `Tarefa.kt`
  - Classe que representa a tarefa (ID, título, descrição, prioridade e concluída)

---

## Persistência (arquivo `BD.txt`)

As tarefas são armazenadas no arquivo **`BD.txt`**, sendo **uma tarefa por linha**, com os campos separados por `;`.

Exemplo de linha:

```
1;Fazer um suco;Comprar tang;1;false
```

Campos (ordem):
1. `id` (Int)
2. `titulo` (String)
3. `descricao` (String)
4. `prioridade` (Int)
5. `concluida` (Boolean)

> Observação: por ser um formato simples, evite usar o caractere `;` dentro do título/descrição (ou implementar tratamento/escape para isso).

---

## Requisitos

- **JDK 17+** (ou outra versão compatível com seu projeto)
- **IntelliJ IDEA** (recomendado) ou outro ambiente para executar Kotlin

---

## Como executar

### IntelliJ
1. Abra o projeto no IntelliJ
2. Aguarde a indexação/compilação
3. Execute o arquivo `main.kt` (função `main`)

---

## Melhorias futuras (ideias)

- Ordenar listagem (por título, prioridade, status)
- Validação de prioridade (faixa fixa e mensagens mais amigáveis)
- Persistência em **JSON** (ex.: `kotlinx.serialization`) para maior robustez
- Filtros mais avançados (ex.: por palavra-chave no título)
- Interface gráfica ou versão Android

---

## Licença

Projeto de estudo. Se quiser publicar como open-source, adicione uma licença (ex.: MIT).
```
