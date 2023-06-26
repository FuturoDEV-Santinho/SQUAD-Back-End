# Dev in Adotion API - Documentação

Esta é a documentação da API de exemplo desenvolvida em Java utilizando o SpringBoot. A API fornece endpoints para manipulação de usuários, armazéns, produtos e busca de animais.

## Endpoints

### Usuários

#### Login de Usuário

Realiza o login de um usuário.

**URL**: `POST /usuarios/login`

- **Parâmetros**:

  - `email` (string, obrigatório): O email do usuário.
  - `senha` (string, obrigatório): A senha do usuário.

- **Exemplo de Requisição**:
  POST /usuarios/login?email=teste@teste.com&senha=teste

#### Cadastro de Usuário

Realiza o cadastro de um novo usuário.

- **URL**: `POST /usuarios/cadastro`

- **Corpo da Requisição** (JSON):

```json
{
  "nome": "Teste",
  "email": "teste@teste.com",
  "senha": "teste"
}
```

## Armazéns

### Adiciona Armazém

Adiciona um novo armazém.

**URL:** `POST /armazem`

**Corpo da Requisição** (JSON):

```json
{
  "nome": "Armazém 1",
  "tipoAnimal": "GATO"
}
```

## Lista Armazém

Lista todos os armazéns cadastrados.

**URL:** `GET /armazem`

## Edita Armazém

Edita um armazém existente.

**URL:** `PUT /armazem/{id}`

_Parâmetros:_

`id` (inteiro, obrigatório): O ID do armazém a ser editado.
**Corpo da Requisição** (JSON):

```json
{
  "nome": "Armazem Nome Alterado",
  "tipoAnimal": "GATO"
}
```

## Exclui Armazém

Exclui um armazém existente.

**URL:** `DELETE /armazem/{id}`

`Parâmetros`:

id (inteiro, obrigatório): O ID do armazém a ser excluído.
Produtos
Adiciona Produto
Adiciona um novo produto.

URL: POST /produto

Corpo da Requisição (JSON):

```json
{
  "categoria": "ADULTO",
  "nomeArmazem": "Armazém 1",
  "quantidade": "1",
  "tipoAnimal": "GATO",
  "tipoProduto": "ANTIPULGAS",
  "armazem": {
    "id": 1
  }
}
```

Lista Produto
Lista todos os produtos em estoque.

URL: GET /produto/estoque
Edita Produto
Edita um produto em estoque.

URL: PUT /produto/{id}/estoque

Parâmetros:

id (inteiro, obrigatório): O ID do produto a ser editado.
Corpo da Requisição (JSON):

```json
{
  "nomeArmazem": "Armazém 1 editado",
  "quantidade": 20
}
```

Exclui Produto
Exclui um produto do estoque.

URL: DELETE /produto/{id}/estoque

Parâmetros:

id (inteiro, obrigatório): O ID do produto a ser excluído.
Dashboard
Busca Todos
Busca informações sobre todos os animais.

URL: GET /animais/agruparTodos
Busca Específica
Busca informações sobre animais específicos.

URL: GET /animais/{tipoAnimal}/{categoria}

Parâmetros:

tipoAnimal (string, obrigatório): O tipo de animal (exemplo: "Gato").
categoria (string, obrigatório): A categoria do animal (exemplo: "Adulto").

# Considerações Finais

Esta documentação fornece uma visão geral dos endpoints disponíveis na API de exemplo. Certifique-se de fornecer os parâmetros corretos e formatar as requisições adequadamente para obter os resultados desejados. Em caso de dúvidas ou problemas, não hesite em entrar em contato com a equipe.
