#language: pt

@errors
Funcionalidade: Testar mensagens de erro exibidas pelo sistema.

Cenário: Logar com usuário inválido.
Quando eu digito usuário ou senha inválidos.
Então espero a mensagem de usuário não encontrado.

Cenário: Cadastrar e-mail já existente
Quando eu tento cadastrar e-mail já existente no sistema.
Então espero a mensagem de que o e-mail já existe.

Cenário: Logar com sucesso.
Quando eu insiro os dados e clico em logar.
Então checo se estou na página home.

Cenário: Cadastrar lembrete com formato de data inválido.
Quando eu tento inserir um lembrete com formato de data inválido.
Então checo a mensagem de formato de data inválido.

Cenário: Deslogar com sucesso.
Quando eu clico no botão de logout.
Então checo se estou na página de login.