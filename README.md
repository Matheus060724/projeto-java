# Documentação do Sistema de Jogos – Classes e Responsabilidades

## 1. Classe `Jogo`

Representa um jogo cadastrado no sistema.

### Atributos:

*   `id` (int): Identificador único.
*   `nome` (String): Nome do jogo.
*   `genero` (String): Gênero.
*   `anoLancamento` (int): Ano de lançamento.
*   `preco` (double): Preço.
*   `disponivel` (boolean): Status.

### Métodos:

*   `getId()`
*   `getNome()`
*   `setNome()`
*   `setGenero()`
*   `setAnoLancamento()`
*   `setPreco()`
*   `setDisponivel()`

## 2. Classe `Cliente`

Representa um cliente do sistema.

### Atributos:

*   `idUsuario` (int)
*   `nome` (String)
*   `email` (String)
*   `saldo` (double)
*   `historicoCompras` (List<Venda>)

### Métodos:

*   `getIdUsuario()`
*   `getNome()`
*   `getEmail()`
*   `getSaldo()`
*   `setNome()`
*   `setEmail()`
*   `setSaldo()`
*   `adicionarHistorico()`
*   `aplicarDesconto()`

## 3. Classe `ClienteRegular`

Cliente comum sem benefícios especiais.

### Métodos:

*   `aplicarDesconto(preco)`: Implementação padrão sem desconto.

## 4. Classe `ClientePremium`

Cliente com benefícios e descontos.

### Atributos:

*   `percentualDesconto` (double)

### Métodos:

*   `getPercentualDesconto()`
*   `aplicarDesconto(preco)`

## 5. Classe `Venda`

Representa a operação de compra.

### Atributos:

*   `cliente` (Cliente)
*   `jogo` (Jogo)
*   `valorPago` (double)
*   `dataHora` (LocalDateTime)
