#language: pt

@reminders
Funcionalidade: Manipular Lembretes.

Cenário: Logar com sucesso.
Quando eu insiro os dados e clico em logar.
Então checo se estou na página home.

Cenário: Registrar Lembrete.
Quando eu preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se o lembrete foi registrado com sucesso.

Cenário: Editar Lembrete.
Quando eu clico em editar um lembrete.
E Preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se os dados foram alterados com sucesso.

Cenário: Deletar Lembrete.
Quando eu clico em deletar um lembrete.
Então eu checo se o lembrete foi deletado com sucesso.

Cenário: Criar editar lembrete com dois cliques depois deleta-lo.
Quando eu preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se o lembrete foi registrado com sucesso.

Quando eu clico em editar um lembrete por dois cliques.
E Preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se os dados foram alterados com sucesso.

Quando eu clico em deletar um lembrete.
Então eu checo se o lembrete foi deletado com sucesso.

Cenário: Deslogar com sucesso.
Quando eu clico no botão de logout.
Então checo se estou na página de login.