#language: pt

@errors
Funcionalidade: Testar mensagens de erro exibidas pelo sistema.

Cenário: Logar com usuário inválido.
Quando eu digito usuário ou senha inválidos.
Então espero a mensagem de usuário não encontrado.

Cenário: Cadastrar e-mail já existente
Quando eu tento cadastrar e-mail já existente no sistema.
Então espero a mensagem de que o e-mail já existe.