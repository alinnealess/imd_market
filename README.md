# IMDMarket - Gerenciador de Estoques

## Descrição do Projeto
O **IMDMarket** é um aplicativo Android desenvolvido como parte da avaliação da segunda unidade da  disciplina **Desenvolvimento de Dispositivos Móveis** de 2024.2 da Universidade Federal do Rio Grande do Norte. Este projeto tem como objetivo criar um gerenciador de estoques para supermercados, permitindo realizar operações de cadastro, alteração, exclusão e listagem de produtos, com persistência de dados utilizando SQLite.


---

## Funcionalidades Implementadas

### 1. Tela de Login
- **Descrição**: Tela inicial do aplicativo que valida as credenciais do usuário.
- **Funcionalidades**:
  - **Credenciais padrão**: 
    - **Usuário:** `admin`
    - **Senha:** `admin`
  - **Autenticação**:
    - Caso as credenciais sejam válidas, redireciona para o menu principal.
    - Caso sejam inválidas, exibe um `Toast` com mensagem de erro.

---

### 2. Tela de Menu
- **Descrição**: Tela principal do aplicativo com acesso às funcionalidades do sistema.
- **Botões Disponíveis**:
  - **Cadastrar Produto**: Redireciona para a tela de cadastro.
  - **Alterar Produto**: Redireciona para a tela de alteração.
  - **Excluir Produto**: Redireciona para a tela de exclusão.
  - **Listar Produtos**: Redireciona para a tela de listagem.

---

### 3. Tela de Cadastro
- **Descrição**: Permite cadastrar novos produtos no sistema.
- **Campos**:
  - **Código do Produto**: Obrigatório.
  - **Nome do Produto**: Obrigatório.
  - **Descrição do Produto**: Obrigatório.
  - **Estoque**: Obrigatório.
- **Funcionalidades**:
  - **Validação**: Exibe um `Toast` caso algum campo obrigatório esteja vazio.
  - **Persistência**: Salva os dados no banco SQLite utilizando o método `saveProduto` da classe `DatabaseHelper`.
  - **Botões**:
    - **Salvar**: Cadastra o produto e retorna ao menu principal.
    - **Limpar**: Reseta os campos do formulário.
    - **Voltar**: Retorna ao menu principal.

---

### 4. Tela de Alteração
- **Descrição**: Permite alterar as informações de um produto existente.
- **Campos**:
  - **Código do Produto**: Obrigatório para identificar o produto a ser alterado.
  - **Nome, Descrição e Estoque**: Campos opcionais para alteração.
- **Funcionalidades**:
  - **Validação**:
    - Verifica se o código do produto existe no banco usando o método `isProdutoExistente`.
  - **Persistência**:
    - Atualiza os dados no banco SQLite utilizando o método `updateProduto` da classe `DatabaseHelper`.
  - **Botões**:
    - **Salvar**: Altera os dados do produto e retorna ao menu principal.
    - **Limpar**: Reseta os campos do formulário.
    - **Voltar**: Retorna ao menu principal.

---

### 5. Tela de Exclusão
- **Descrição**: Permite excluir produtos cadastrados.
- **Campo**:
  - **Código do Produto**: Obrigatório.
- **Funcionalidades**:
  - **Validação**: Verifica se o código do produto existe no banco usando o método `isProdutoExistente`.
  - **Persistência**: Exclui o produto do banco SQLite utilizando o método `deleteProduto` da classe `DatabaseHelper`.
  - **Botões**:
    - **Deletar**: Exclui o produto e retorna ao menu principal.
    - **Limpar**: Reseta o campo de código.
    - **Voltar**: Retorna ao menu principal.

---

### 6. Tela de Listagem
- **Descrição**: Exibe todos os produtos cadastrados.
- **Funcionalidades**:
  - **Busca de Produtos**: Carrega os produtos cadastrados no banco SQLite utilizando o método `listAllProdutos` da classe `DatabaseHelper`.
  - **Exibição**:
    - Mostra o código, nome, descrição e quantidade em estoque de cada produto em um `ListView`.
    - O layout é customizado para exibir os detalhes em formato de "subitem" (nome em destaque, descrição e quantidade em tom mais claro).
  - **Botão Voltar**: Retorna ao menu principal.

---

## Estrutura do Projeto

### 1. Pacote Principal
- **Activities Implementadas**:
  - `LoginActivity`: Autenticação de usuários.
  - `MenuActivity`: Tela principal com navegação para as funcionalidades.
  - `CadastroActivity`: Cadastro de produtos.
  - `AlteracaoActivity`: Alteração de produtos.
  - `ExclusaoActivity`: Exclusão de produtos.
  - `ListagemActivity`: Listagem de produtos.

### 2. Banco de Dados
- **Classe `DatabaseHelper`**:
  - Responsável pela criação e gerenciamento do banco SQLite.
  - Tabelas:
    - **Produtos**: Armazena código, nome, descrição e estoque de produtos.
    - **Usuários**: Armazena login e senha dos usuários.
  - Métodos:
    - `saveProduto`: Insere um novo produto no banco.
    - `updateProduto`: Atualiza um produto existente.
    - `deleteProduto`: Remove um produto pelo código.
    - `listAllProdutos`: Lista todos os produtos cadastrados.
    - `validateUser`: Valida o login do usuário.
    - `isProdutoExistente`: Verifica se um produto existe no banco.

---

## Como Executar
1. Clone ou extraia o projeto em um ambiente de desenvolvimento Android (Android Studio).
2. Compile e execute o aplicativo em um dispositivo físico ou emulador.
3. Utilize as credenciais padrão para login:
   - **Usuário:** `admin`
   - **Senha:** `admin`
4. Navegue pelas funcionalidades disponíveis.

---

## Observações
- **Persistência de Dados**:
  - Todos os dados são armazenados no banco SQLite local.
- **Interface de Usuário**:
  - Design simples e funcional, com mensagens `Toast` para feedback.
- **Modularidade**:
  - Código organizado em classes separadas para cada funcionalidade.

---

