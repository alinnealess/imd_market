# IMDMarket - Gerenciador de Estoques

## Descrição do Projeto
O **IMDMarket** é um aplicativo Android desenvolvido como parte da disciplina **Programação de Dispositivos Móveis** da Universidade Federal do Rio Grande do Norte. Este projeto tem como objetivo simular um gerenciador de estoques de produtos para supermercados. 

Nesta **primeira etapa**, o foco está na criação das telas e seus elementos visuais, bem como na transição entre elas, sem implementação da lógica para persistência de dados.

---

## Funcionalidades Implementadas

### 1. Tela de Login
- **Descrição**: Primeira tela exibida ao abrir o aplicativo.
- **Funcionalidades**:
  - Aceita credenciais padrão: **usuário:** `admin` e **senha:** `admin`.
  - Exibe uma opção para alteração de senha (não funcional nesta etapa).
  - Ao autenticar, redireciona para o menu principal.

---

### 2. Tela de Menu
- **Descrição**: Tela principal do aplicativo, com botões para acessar as demais funcionalidades.
- **Botões Disponíveis**:
  - **Cadastrar Produto**: Redireciona para a tela de cadastro.
  - **Alterar Produto**: Redireciona para a tela de alteração.
  - **Excluir Produto**: Redireciona para a tela de exclusão.
  - **Listar Produtos**: Redireciona para a tela de listagem.

---

### 3. Tela de Cadastro
- **Descrição**: Permite inserir informações de um produto.
- **Campos**:
  - **Código do Produto**: Obrigatório.
  - **Nome do Produto**: Obrigatório.
  - **Descrição do Produto**: Obrigatório.
  - **Estoque**: Obrigatório.
- **Funcionalidade do Botão Salvar**:
  - Exibe um `Toast` se algum campo obrigatório estiver vazio.
  - Redireciona para o menu principal após salvar (apenas transição visual; sem persistência de dados nesta etapa).
- **Botão Limpar**:
  - Reseta todos os campos do formulário.
- **Botão Voltar**:
  - Retorna ao menu principal.

---

### 4. Tela de Alteração
- **Descrição**: Permite alterar informações de um produto existente.
- **Campos**:
  - **Código do Produto**: Obrigatório.
  - **Demais campos** (Nome, Descrição e Estoque): Opcionais.
- **Botão Salvar**:
  - Exibe um `Toast` confirmando a alteração (sem persistência nesta etapa).
  - Redireciona para o menu principal.
- **Botão Limpar**:
  - Reseta os campos do formulário.
- **Botão Voltar**:
  - Retorna ao menu principal.

---

### 5. Tela de Exclusão
- **Descrição**: Permite excluir um produto.
- **Campo**:
  - **Código do Produto**: Obrigatório.
- **Botão Deletar**:
  - Exibe um `Toast` confirmando a exclusão (sem persistência nesta etapa).
  - Retorna automaticamente para o menu principal.
- **Botão Limpar**:
  - Reseta o campo de código.
- **Botão Voltar**:
  - Retorna ao menu principal.

---

### 6. Tela de Listagem
- **Descrição**: Tela que futuramente exibirá uma lista de produtos cadastrados.
- **Atual Implementação**:
  - Apenas reservada a área do `ListView` no layout gráfico.
  - Nenhuma funcionalidade implementada nesta etapa.

---

## Estrutura do Projeto

### Pacote Principal
- **Activities Implementadas**:
  - `LoginActivity`
  - `MenuActivity`
  - `CadastroActivity`
  - `AlteracaoActivity`
  - `ExclusaoActivity`
  - `ListagemActivity`

### Layouts XML
- Cada tela possui seu arquivo XML em `res/layout/`, estruturado com base nos requisitos da proposta.

---

## Como Executar
1. Clone ou extraia o projeto em um ambiente de desenvolvimento Android (Android Studio).
2. Compile e execute o aplicativo em um dispositivo físico ou emulador.
3. Use as credenciais padrão:
   - **Usuário:** `admin`
   - **Senha:** `admin`

---

## Observações
- **Sem persistência de dados**: Nesta primeira etapa, os dados inseridos não são salvos.
- **Feedback visual**: Mensagens `Toast` são utilizadas para indicar ações bem-sucedidas ou erros.
- **Navegação funcional**: Todas as telas estão interligadas, permitindo transições suaves entre elas.
