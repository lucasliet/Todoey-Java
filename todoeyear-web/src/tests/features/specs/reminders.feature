#language: pt

@reminders
Funcionalidade: Manipular Lembretes.

Cenário: Logar com sucesso.
Quando eu insiro os dados e clico em logar.
Então checo se estou na página home.

Cenário: Registrar Lembretes.
Quando eu preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se o lembrete foi registrado com sucesso.

Cenário: Registrar Lembretes.
Quando eu preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se o lembrete foi registrado com sucesso.

Cenário: Editar Lembrete.
Quando eu clico em editar um lembrete.
E Preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se os dados foram alterados com sucesso.

Cenário: Editar lembrete com dois cliques.
Quando eu clico em editar um lembrete por dois cliques.
E Preencho os campos do formulário.
Então checo se estou na página home.
Então eu checo se os dados foram alterados com sucesso.

Cenário: Deletar Lembrete.
Quando eu clico em deletar um lembrete.
Então eu checo se o lembrete foi deletado com sucesso.

Cenário: Deletar Lembrete.
Quando eu clico em deletar um lembrete.
Então eu checo se o lembrete foi deletado com sucesso.

Cenário: Deslogar com sucesso.
Quando eu clico no botão de logout.
Então checo se estou na página de login.