#language: pt

@reminders
Funcionalidade: Manipular Lembretes.

Cenário: Registrar Lembretes.
Quando eu preencho os campos do formulário.
Então eu checo se o lembrete foi registrado com sucesso.

Cenário: Editar Lembrete.
Quando eu clico em editar um lembrete.
E Preencho os campos do formulário.
Então eu checo se os dados foram alterados com sucesso.

Cenário: Deletar Lembrete.
Quando eu clico em deletar um lembrete.
Então eu checo se o lembrete foi deletado com sucesso.